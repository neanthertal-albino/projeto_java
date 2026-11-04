package one.digitalinovation.lab_padroes_projeto_spring.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository do Endereco.
 *
 * Tipo generico: <Endereco, String> -> a chave primaria do Endereco e o CEP
 * (uma String), e nao um Long como no Cliente.
 */
@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {

}
