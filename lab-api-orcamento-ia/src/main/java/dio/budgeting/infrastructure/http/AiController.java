package dio.budgeting.infrastructure.http;

import dio.budgeting.infrastructure.ai.VoiceAssistant;
import dio.budgeting.infrastructure.ai.VoiceAssistant.VoiceResult;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/assistant")
public class AiController {

    private final VoiceAssistant assistant;

    public AiController(VoiceAssistant assistant) {
        this.assistant = assistant;
    }

    /** Caminho principal do desafio: audio entra, audio (WAV) sai. */
    @PostMapping(value = "/voice", consumes = "multipart/form-data")
    public VoiceResponse voz(@RequestParam("file") MultipartFile file) throws IOException {
        return paraResponse(assistant.processarAudio(file));
    }

    /** Atalho para testar o tool calling sem gravar audio. */
    @PostMapping("/text")
    public VoiceResponse texto(@RequestBody TextoRequest request) {
        return paraResponse(assistant.processarTexto(request.texto()));
    }

    private VoiceResponse paraResponse(VoiceResult resultado) {
        return new VoiceResponse(resultado.transcricao(), resultado.resposta(),
                Base64.getEncoder().encodeToString(resultado.audio()));
    }

    public record TextoRequest(String texto) {
    }

    public record VoiceResponse(String transcricao, String resposta, String audioBase64) {
    }
}
