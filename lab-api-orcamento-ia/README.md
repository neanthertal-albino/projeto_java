# API de Orçamento com IA (versão local, sem chave)

Projeto de estudo baseado no desafio final do bootcamp (Spring Boot + Spring AI).
Aqui o fluxo completo funciona **sem chave OpenAI, sem Docker e sem MySQL**:

```
áudio → transcrição → ChatClient + @Tool → caso de uso → H2 → resposta → WAV
```

Os três modelos de IA (`LocalTranscriptionModel`, `LocalChatModel`,
`LocalTextToSpeechModel`) implementam as interfaces reais do Spring AI, mas são
determinísticos. Depois é só trocar os beans pelos modelos reais.

## Como executar

```bash
./mvnw spring-boot:run
```

Requisito: JDK 21. O banco H2 é em memória.

## Endpoints

| Método | Caminho | O que faz |
| --- | --- | --- |
| `POST` | `/transactions` | cria uma transação (valor em centavos) |
| `GET` | `/transactions/{category}` | lista por categoria |
| `POST` | `/assistant/voice` | `multipart/form-data`, campo `file`: áudio → WAV em base64 |
| `POST` | `/assistant/text` | testa o tool calling sem áudio |

Exemplos em `requests.http`.

## Minha melhoria

Coloquei a validação no construtor de `domain/Transaction.java`: a transação
só é criada se tiver descrição preenchida, valor maior que zero e categoria.
Se algo estiver errado, ela lança `InvalidTransactionException` e a API devolve
`400` com uma mensagem clara.

A regra fica no domínio porque tanto o endpoint REST quanto o comando de voz
passam pelo mesmo construtor. Assim não dá para salvar um gasto inválido
"pulando" a validação — a IA escolhe a ferramenta, mas quem decide o que é
válido é o Java.

- [x] Validação: descrição obrigatória
- [x] Validação: valor > 0
- [x] Validação: categoria obrigatória

## Testes

```bash
./mvnw test
```

`TransactionTest` cobre a validação (caso válido, descrição vazia, valor
inválido e categoria nula). `ApiFlowTest` cobre o fluxo REST + tool calling +
geração de áudio. Todos passam.

## Tecnologias

Java 21, Spring Boot 3.5, Spring AI 1.1 (interfaces de modelo/chat), Spring Data
JPA, H2, JUnit 5 e MockMvc.

## O que eu aprendi

- O `ChatClient` entende a intenção e escolhe qual `@Tool` chamar, mas quem
  grava no banco é o caso de uso Java — a IA não acessa o repositório.
- Colocar a regra no domínio evita repetir validação no controller e na tool:
  os dois caminhos usam o mesmo `new Transaction(...)`.
- Dá para estudar o fluxo inteiro sem chave de IA implementando as interfaces
  do Spring AI (`TranscriptionModel`, `ChatModel`, `TextToSpeechModel`) com
  versões locais e determinísticas.
- Teste de integração com MockMvc prova o fluxo de ponta a ponta sem subir
  servidor nem depender de rede.
