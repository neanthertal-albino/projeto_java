package dio.budgeting.infrastructure.http;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ApiFlowTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void restCriaEListaTransacao() throws Exception {
        mvc.perform(post("/transactions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"description\":\"Mercado\",\"amount\":12500,\"category\":\"GROCERIES\"}"))
                .andExpect(status().isCreated());

        String lista = mvc.perform(get("/transactions/GROCERIES"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        assertThat(lista).contains("Mercado");
    }

    @Test
    void vozTranscreveDecideChamaFerramentaEGeneraAudio() throws Exception {
        String resposta = mvc.perform(post("/assistant/text")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"texto\":\"Gastei 60 reais em estacionamento\"}"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        JsonNode json = mapper.readTree(resposta);
        assertThat(json.get("transcricao").asText()).contains("estacionamento");
        assertThat(json.get("resposta").asText()).isNotBlank();
        assertThat(json.get("audioBase64").asText()).isNotEmpty();
    }
}
