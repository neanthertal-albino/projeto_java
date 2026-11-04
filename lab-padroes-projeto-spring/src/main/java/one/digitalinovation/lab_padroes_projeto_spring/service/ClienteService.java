package one.digitalinovation.lab_padroes_projeto_spring.service;

import one.digitalinovation.lab_padroes_projeto_spring.model.Cliente;

/**
 * PADRAO STRATEGY.
 *
 * Esta interface define O QUE o servico de cliente faz, mas nao COMO.
 * A implementacao fica em service/impl/ClienteServiceImpl.
 *
 * Vantagem: se um dia precisarmos de outra implementacao (ex.: outro banco,
 * outra regra de negocio), basta criar outra classe que implemente esta
 * interface, sem mexer no controller.
 */
public interface ClienteService {

	Iterable<Cliente> buscarTodos();

	Cliente buscarPorId(Long id);

	void inserir(Cliente cliente);

	void atualizar(Long id, Cliente cliente);

	void deletar(Long id);

	/**
	 * Atualizacao parcial (PATCH): troca apenas o CEP do cliente.
	 */
	void atualizarCep(Long id, String cep);

}
