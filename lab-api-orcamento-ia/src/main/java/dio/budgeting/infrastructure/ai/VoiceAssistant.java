package dio.budgeting.infrastructure.ai;

import org.springframework.ai.audio.transcription.AudioTranscriptionPrompt;
import org.springframework.ai.audio.transcription.TranscriptionModel;
import org.springframework.ai.audio.tts.TextToSpeechModel;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/** Orquestra o fluxo: audio -> texto -> intencao -> ferramenta -> audio. */
@Service
public class VoiceAssistant {

    private final TranscriptionModel transcriptionModel;
    private final ChatClient chatClient;
    private final TextToSpeechModel textToSpeechModel;

    public VoiceAssistant(TranscriptionModel transcriptionModel,
                          ChatClient chatClient,
                          TextToSpeechModel textToSpeechModel) {
        this.transcriptionModel = transcriptionModel;
        this.chatClient = chatClient;
        this.textToSpeechModel = textToSpeechModel;
    }

    public VoiceResult processarAudio(MultipartFile arquivo) throws IOException {
        if (arquivo == null || arquivo.isEmpty()) {
            throw new IllegalArgumentException("Envie um arquivo de audio");
        }
        String nome = arquivo.getOriginalFilename();
        ByteArrayResource recurso = new ByteArrayResource(arquivo.getBytes()) {
            @Override
            public String getFilename() {
                return nome;
            }
        };
        String transcricao = transcriptionModel
                .call(new AudioTranscriptionPrompt(recurso))
                .getResult()
                .getOutput();
        return processarTexto(transcricao);
    }

    public VoiceResult processarTexto(String transcricao) {
        String resposta = chatClient.prompt().user(transcricao).call().content();
        byte[] audio = textToSpeechModel.call(resposta);
        return new VoiceResult(transcricao, resposta, audio);
    }

    public record VoiceResult(String transcricao, String resposta, byte[] audio) {
    }
}
