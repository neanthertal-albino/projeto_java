# Lab Padrões de Projeto com Spring Boot

API REST de cadastro de **clientes** com seus **endereços**, feita no Bootcamp
de Java da DIO. O endereço é buscado automaticamente na API do
[ViaCEP](https://viacep.com.br) a partir do CEP.

## Tecnologias

- Java 21
- Spring Boot 4
- Spring Data JPA
- Spring Web (MVC)
- OpenFeign (consumo do ViaCEP)
- H2 (banco em memória)
- Maven

## Padrões de projeto utilizados

| Padrão | Onde está | Por que |
|--------|-----------|---------|
| **Singleton** | `@Service` e `@Repository` | O Spring cria uma única instância de cada componente para toda a aplicação, economizando recursos e mantendo o estado consistente. |
| **Strategy** | interface `ClienteService` + `ClienteServiceImpl` | O contrato define o que o serviço faz. Se amanhã surgir outra implementação, basta criar outra classe sem alterar o controller. |
| **Facade** | `ClienteRestController` e `ClienteServiceImpl` | Escondem a complexidade (banco H2, JPA, ViaCEP) atrás de uma interface simples: as rotas REST. |
| **Repository** | `ClienteRepository` / `EnderecoRepository` | O Spring Data gera o acesso ao banco só pela declaração da interface. |

## Como rodar

```bash
./mvnw spring-boot:run
```

A aplicação sobe em `http://localhost:8080`.

Console do H2: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:labpadroes`
- Usuário: `sa`
- Senha: (vazia)

## Endpoints

| Método | Rota | Ação |
|--------|------|------|
| GET | `/clientes` | lista todos os clientes |
| GET | `/clientes/{id}` | busca um cliente por id |
| POST | `/clientes` | cria um cliente |
| PUT | `/clientes/{id}` | atualiza um cliente |
| PATCH | `/clientes/{id}/cep?cep=20040000` | troca **somente** o CEP do cliente |
| DELETE | `/clientes/{id}` | remove um cliente |

A rota `PATCH` é uma atualização **parcial**: ela reaproveita o
`salvarClienteComCep` para buscar o novo CEP no banco ou no ViaCEP.

Exemplo de corpo para POST/PUT (o CEP é consultado no ViaCEP):

```json
{
  "nome": "Iago",
  "endereco": { "cep": "01001000" }
}
```
