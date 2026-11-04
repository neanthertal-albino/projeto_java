package one.digitalinovation.lab_padroes_projeto_spring.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import one.digitalinovation.lab_padroes_projeto_spring.model.Endereco;

/**
 * Cliente HTTP do ViaCEP criado com OpenFeign.
 *
 * O Feign faz o trabalho pesado: em vez de escrever codigo para abrir conexao,
 * montar URL, ler o JSON e converter, basta declarar a interface. O Spring
 * gera a implementacao em tempo de execucao.
 *
 * Exemplo de chamada gerada:
 *   GET https://viacep.com.br/ws/01001000/json/
 *
 * O JSON devolvido e convertido automaticamente em um objeto Endereco.
 *
 * @see <a href="https://viacep.com.br">ViaCEP</a>
 */
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

	@GetMapping("/{cep}/json/")
	Endereco consultarCep(@PathVariable("cep") String cep);

}
