package one.digitalinovation.lab_padroes_projeto_spring.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinovation.lab_padroes_projeto_spring.model.Cliente;
import one.digitalinovation.lab_padroes_projeto_spring.model.ClienteRepository;
import one.digitalinovation.lab_padroes_projeto_spring.model.Endereco;
import one.digitalinovation.lab_padroes_projeto_spring.model.EnderecoRepository;
import one.digitalinovation.lab_padroes_projeto_spring.service.ClienteService;
import one.digitalinovation.lab_padroes_projeto_spring.service.ViaCepService;

/**
 * Implementacao do padrao STRATEGY (contrato ClienteService).
 *
 * O @Service faz o Spring criar e gerenciar UMA instancia desta classe para a
 * aplicacao inteira -> padrao SINGLETON do Spring.
 *
 * O @Autowired pede ao Spring para injetar os objetos prontos aqui dentro;
 * nao precisamos usar "new" neles.
 *
 * A classe tambem e uma FACADE: esconde a complexidade do banco (repositories)
 * e da API externa (ViaCEP) atras de metodos simples.
 */
@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepService viaCepService;

	@Override
	public Iterable<Cliente> buscarTodos() {
		// Devolve todos os clientes do banco.
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		// findById devolve Optional; se nao achar, devolvemos null.
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	public void inserir(Cliente cliente) {
		// Nao salva direto: garante o endereco (banco ou ViaCEP) primeiro.
		salvarClienteComCep(cliente);
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		// So atualiza se o cliente existir.
		Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if (clienteBd.isPresent()) {
			salvarClienteComCep(cliente);
		}
	}

	@Override
	public void deletar(Long id) {
		clienteRepository.deleteById(id);
	}

	@Override
	public void atualizarCep(Long id, String cep) {
		// Atualizacao parcial: cria um Endereco novo com o CEP informado e
		// reaproveita a regra do salvarClienteComCep (banco ou ViaCEP).
		//
		// Obs.: o CEP e a chave primaria do Endereco, por isso criamos um
		// Endereco novo em vez de alterar o cep do antigo.
		Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if (clienteBd.isPresent()) {
			Cliente cliente = clienteBd.get();
			Endereco novoEndereco = new Endereco();
			novoEndereco.setCep(cep);
			cliente.setEndereco(novoEndereco);
			salvarClienteComCep(cliente);
		}
	}

	/**
	 * Salva o cliente garantindo o endereco correto.
	 *
	 * 1) Pega o CEP que veio dentro do cliente.
	 * 2) Procura esse CEP no banco.
	 * 3) Se nao existir, consulta o ViaCEP, salva o endereco retornado e usa.
	 * 4) Coloca o endereco no cliente e salva o cliente.
	 */
	private void salvarClienteComCep(Cliente cliente) {
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			// Importante: save devolve a instancia gerenciada pelo JPA.
			// Usar o retorno evita o erro de "unsaved transient instance".
			return enderecoRepository.save(novoEndereco);
		});
		cliente.setEndereco(endereco);
		clienteRepository.save(cliente);
	}

}
