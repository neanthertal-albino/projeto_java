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
 * aplicacao inteira -> isso e o padrao SINGLETON do Spring.
 *
 * O @Autowired pede ao Spring para "injetar" os objetos prontos aqui dentro.
 * Voce nao precisa dar "new" em nenhum deles.
 *
 * A classe tambem e uma FACADE: os metodos escondem a complexidade de falar
 * com o banco (repositories) e com a API externa (ViaCEP).
 *
 * ============ SUAS LACUNAS ============
 * Complete os metodos marcados com (todo) Cada um tem a dica do que fazer.
 * Enquanto nao completar, eles lancam UnsupportedOperationException, mas o
 * projeto continua compilando.
 */
@Service
public class ClienteServiceImpl implements ClienteService {

	// SINGLETON: o Spring injeta os componentes prontos (@Autowired).
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepService viaCepService;

	@Override
	public Iterable<Cliente> buscarTodos() {
		// TODO 1: devolver todos os clientes do banco.
		// Dica: o repository tem um metodo pronto para isso.
		//       return clienteRepository.______();
		
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		// TODO 2: buscar um cliente pelo id.
		// Dica: findById devolve um Optional<Cliente>.
		//       Voce pode usar .orElse(null) para devolver null se nao achar,
		//       ou guardar em um Optional e usar .get().
		//       Optional<Cliente> cliente = clienteRepository.______(id);
		//       return ______;
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	public void inserir(Cliente cliente) {
		// TODO 3: inserir um novo cliente.
		// Dica: nao salve direto! Use o metodo salvarClienteComCep(cliente)
		//       para garantir que o endereco exista/esteja completo.
		salvarClienteComCep(cliente);
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		// TODO 4: atualizar um cliente que ja existe.
		// Dica: antes de salvar, confira se o id existe no banco:
		//       Optional<Cliente> clienteBd = clienteRepository.______(id);
		//       if (clienteBd.______()) { salvarClienteComCep(cliente); }
		Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if (clienteBd.isPresent()) {
			salvarClienteComCep(cliente);
		}
	}

	@Override
	public void deletar(Long id) {
		// TODO 5: deletar o cliente pelo id.
		// Dica: clienteRepository.______(id);
		clienteRepository.deleteById(id);
	}

	@Override
	public void atualizarCep(Long id, String cep) {
		// TODO 7 (NOVO): trocar somente o CEP de um cliente que ja existe.
		//
		// CUIDADO: o CEP e o @Id do Endereco. Nao altere o cep do endereco
		// antigo (JPA nao deixa trocar chave primaria); crie um Endereco novo.
		//
		// Passos:
		// 1) Optional<Cliente> clienteBd = clienteRepository.findById(id);
		// 2) if (clienteBd.isPresent()) {
		//      Cliente cliente = clienteBd.get();
		//      Endereco novoEndereco = new Endereco();
		//      novoEndereco.setCep(cep);
		//      cliente.setEndereco(novoEndereco);
		//      salvarClienteComCep(cliente);  // reaproveita a regra do ViaCEP
		//    }
		Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if (clienteBd.isPresent()) {
			Cliente cliente = clienteBd.get();
			Endereco novoEndereco = new Endereco();
			novoEndereco.setCep(cep);
			cliente.setEndereco(novoEndereco);
			salvarClienteComCep(cliente);
		}
	}

	/*
	 * Metodo auxiliar que salva o cliente garantindo o endereco correto.
	 *
	 * Regra (Facade + Strategy):
	 *   1) Pegar o CEP que veio dentro do cliente.
	 *   2) Procurar esse CEP no banco (enderecoRepository.findById(cep)).
	 *   3) Se NAO existir, chamar a API do ViaCEP (viaCepService.consultarCep),
	 *      salvar o endereco retornado e usar esse endereco.
	 *   4) Colocar o endereco no cliente e salvar o cliente.
	 *
	 * Dica de Java: `orElseGet(() -> { ... })` executa o bloco so quando o
	 * Optional esta vazio (ou seja, quando o CEP ainda nao esta no banco).
	 *
	 * Estrutura sugerida:
	 *
	 *   String cep = cliente.getEndereco().getCep();
	 *   Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
	 *       Endereco novoEndereco = viaCepService.consultarCep(cep);
	 *       enderecoRepository.save(novoEndereco);
	 *       return novoEndereco;
	 *   });
	 *   cliente.setEndereco(endereco);
	 *   clienteRepository.save(cliente);
	 */
	private void salvarClienteComCep(Cliente cliente) {
		// TODO 6: implementar conforme a estrutura acima.
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(()-> {
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		cliente.setEndereco(endereco);
		clienteRepository.save(cliente); 
	}

}
