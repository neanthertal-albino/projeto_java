package one.digitalinovation.lab_padroes_projeto_spring.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository (parte do padrao Strategy/Repository do Spring Data).
 *
 * Nao precisamos escrever SQL: basta estender CrudRepository e o Spring cria
 * os metodos prontos (save, findAll, findById, deleteById...).
 *
 * Tipo generico: <Cliente, Long> -> entidade Cliente, chave primaria Long.
 */
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
