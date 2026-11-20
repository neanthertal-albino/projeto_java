package dio.budgeting.infrastructure.ai;

import org.springframework.ai.audio.tts.Speech;
import org.springframework.ai.audio.tts.TextToSpeechModel;
import org.springframework.ai.audio.tts.TextToSpeechPrompt;
import org.springframework.ai.audio.tts.TextToSpeechResponse;
import org.springframework.stereotype.Component;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import reactor.core.publisher.Flux;

/**
 * FAKE do text-to-speech: gera um WAV curto (um "bipe") com recursos do JDK.
 * Implementa TextToSpeechModel, entao a troca pelo modelo real e so trocar o bean.
 */
@Component
public class LocalTextToSpeechModel implements TextToSpeechModel {

    @Override
    public TextToSpeechResponse call(TextToSpeechPrompt prompt) {
        String texto = prompt.getInstructions().getText();
        if (texto == null || texto.isBlank()) {
            throw new IllegalArgumentException("Texto vazio para sintetizar");
        }

        byte[] wav = gerarBipe();
        return new TextToSpeechResponse(List.of(new Speech(wav)));
    }

    @Override
    public Flux<TextToSpeechResponse> stream(TextToSpeechPrompt prompt) {
        return Flux.just(call(prompt));
    }

    private byte[] gerarBipe() {
        int duracao = 8_000;
        int taxa = 8_000;
        byte[] amostras = new byte[duracao];
        for (int i = 0; i < amostras.length; i++) {
            amostras[i] = (byte) (Math.sin(2 * Math.PI * 440 * i / taxa) * 60);
        }

        AudioFormat formato = new AudioFormat(taxa, 8, 1, true, false);
        try (AudioInputStream audio = new AudioInputStream(
                new ByteArrayInputStream(amostras), formato, amostras.length);
             ByteArrayOutputStream saida = new ByteArrayOutputStream()) {
            AudioSystem.write(audio, AudioFileFormat.Type.WAVE, saida);
            return saida.toByteArray();
        } catch (Exception e) {
            throw new IllegalStateException("Falha ao gerar WAV", e);
        }
    }
}
