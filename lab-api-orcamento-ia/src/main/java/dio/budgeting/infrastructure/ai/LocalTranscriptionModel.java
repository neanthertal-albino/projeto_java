package dio.budgeting.infrastructure.ai;

import org.springframework.ai.audio.transcription.AudioTranscription;
import org.springframework.ai.audio.transcription.AudioTranscriptionPrompt;
import org.springframework.ai.audio.transcription.AudioTranscriptionResponse;
import org.springframework.ai.audio.transcription.TranscriptionModel;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * FAKE do speech-to-text: implementa a MESMA interface do Spring AI.
 *
 * No projeto do Poiani, aqui entra o modelo Whisper da OpenAI (com chave).
 * Aqui devolvemos uma frase fixa so para o fluxo funcionar sem rede.
 * Troque este bean pelo OpenAiAudioTranscriptionModel quando quiser.
 */
@Component
public class LocalTranscriptionModel implements TranscriptionModel {

    @Override
    public AudioTranscriptionResponse call(AudioTranscriptionPrompt prompt) {
        Resource audio = prompt.getInstructions();
        try {
            if (audio.contentLength() == 0) {
                throw new IllegalArgumentException("Arquivo de audio vazio");
            }
        } catch (IOException e) {
            throw new IllegalStateException("Nao foi possivel ler o audio", e);
        }

        String nome = audio.getFilename() == null ? "" : audio.getFilename().toLowerCase();
        String frase;
        if (nome.contains("mercado")) {
            frase = "Gastei 125 reais no mercado";
        } else if (nome.contains("farmacia")) {
            frase = "Gastei 32 reais na farmacia";
        } else {
            frase = "Gastei 60 reais em estacionamento";
        }
        return new AudioTranscriptionResponse(new AudioTranscription(frase));
    }
}
