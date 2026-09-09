# API Calculadora

Este repositório contém o projeto da **API Calculadora**, incluindo a configuração Docker, automação de build/push e suíte de testes automatizados com Newman.

## Estrutura de Arquivos

* `Dockerfile`: Configuração para containerização da aplicação.
* `docker-compose.yml`: Arquivo de orquestração do Docker Compose.
* `api-calculadora.postman_collection.json`: Coleção de testes do Postman.
* `build.bat`: Script de build e push para o Docker Hub.
* `execute_compose.bat`: Script para subir o ambiente usando o Docker Compose.
* `execute_newman.bat`: Script para executar os testes automatizados via Newman.

---

## Como Executar o Projeto

### 1. Subindo o Container com Docker Compose
Para iniciar a aplicação em segundo plano (detached mode), utilize o Docker Compose:

```bash
docker compose up -d
```
*(Ou utilize o arquivo `execute_compose.bat` se estiver no Windows).*

### 2. Executando os Testes Automatizados (Newman)
O projeto conta com testes automatizados do Postman executados via linha de comando através do Newman. O script verifica se o Node.js está instalado e se o Newman já está presente na máquina antes de rodar:

```bash
npm install -g newman --silent
echo Executando a colecao de testes com o Newman...
newman run api-calculadora.postman_collection.json
```
*(Ou execute diretamente o script `execute_newman.bat`).*

---

# Swagger / OpenAPI

A API possui documentação interativa utilizando **Swagger UI** e **Springdoc OpenAPI**.

Com a aplicação em execução, acesse:

```text
http://localhost:8080/swagger-ui/index.html
```

O Swagger UI permite:

* Visualizar os endpoints disponíveis;
* Visualizar os métodos HTTP;
* Consultar os parâmetros das requisições;
* Visualizar os modelos de Request e Response;
* Testar os endpoints diretamente pelo navegador;
* Enviar requisições `POST`;
* Visualizar as respostas da API.

## Acessar o Swagger

Após iniciar a aplicação:

```bash
mvn spring-boot:run
```

acesse:

```text
http://localhost:8080/swagger-ui/index.html
```

### Swagger UI

```text
http://localhost:8080/swagger-ui/index.html
```

### Documentação OpenAPI

A especificação OpenAPI também pode ser acessada através de:

```text
http://localhost:8080/v3/api-docs
```

A documentação permite testar, por exemplo, o endpoint:

```http
POST /calculadora/somar
```

Com a seguinte requisição:

```json
{
  "numero1": 10,
  "numero2": 5,
  "operacao": "SOMAR"
}
```

Resultado esperado:

```json
{
  "numero1": 10,
  "numero2": 5,
  "operacao": "SOMAR",
  "resultado": 15
}
```

# API Calculadora

API REST desenvolvida com **Java 25** e **Spring Boot 4.1.1** para execução de operações matemáticas básicas:

* Soma
* Subtração
* Multiplicação
* Divisão

O projeto foi desenvolvido com foco em boas práticas de desenvolvimento Java, organização em camadas, DTOs, Enum, Service, Controller, Bean Validation e testes automatizados.

---

## Tecnologias

| Tecnologia        | Versão / Utilização      |
| ----------------- | ------------------------ |
| Java              | 25                       |
| Spring Boot       | 4.1.1                    |
| Spring MVC        | API REST                 |
| Bean Validation   | Validação de dados (DTO) |
| Maven             | Gerenciamento do projeto |
| JUnit             | 6.1.2                    |
| Mockito           | 5.23.0                   |
| Springdoc OpenAPI | 3.1.0                    |
| Git               | Controle de versão       |

---

## Arquitetura

O projeto utiliza uma arquitetura simples baseada em camadas:

```text
Controller
    ↓
Service
    ↓
Enum / Regras de cálculo
```

### Estrutura principal

```text
src
├── main
│   └── java
│       └── com.botelho.loester.api_calculadora
│           ├── controller
│           │   └── CalculadoraController.java
│           │
│           ├── dto
│           │   ├── request
│           │   │   └── CalculadoraRequisicao.java
│           │   │
│           │   └── response
│           │       └── CalculadoraResposta.java
│           │
│           ├── enums
│           │   └── Operacoes.java
│           │
│           ├── service
│           │   └── CalculadoraService.java
│           │
│           └── ApiCalculadoraApplication.java
│
└── test
    └── java
        └── com.botelho.loester.api_calculadora
            ├── controller
            │   └── CalculadoraControllerTest.java
            │
            ├── service
            │   └── CalculadoraServiceTest.java
            │
            └── ApiCalculadoraApplicationTests.java
```

---

# Como executar

Clone o projeto:

```bash
git clone https://github.com/LoesterBotelho/api-calculadora.git
```

Entre no diretório:

```bash
cd api-calculadora
```

Execute a aplicação:

```bash
mvn spring-boot:run
```

A API estará disponível em:

```text
http://localhost:8080
```

---

# Endpoints

A API disponibiliza quatro endpoints `POST` para execução das operações matemáticas.

| Operação      | Endpoint                   |
| ------------- | -------------------------- |
| Soma          | `/calculadora/somar`       |
| Subtração     | `/calculadora/subtrair`    |
| Multiplicação | `/calculadora/multiplicar` |
| Divisão       | `/calculadora/dividir`     |

Todos os endpoints utilizam:

```http
Content-Type: application/json
```

---

# Objeto de requisição

A API recebe um objeto `CalculadoraRequisicao`:

```json
{
  "numero1": 10,
  "numero2": 5,
  "operacao": "SOMAR"
}
```

## Campos

| Campo      | Tipo        | Descrição                                |
| ---------- | ----------- | ---------------------------------------- |
| `numero1`  | `int`       | Primeiro número da operação              |
| `numero2`  | `int`       | Segundo número da operação               |
| `operacao` | `Operacoes` | Tipo da operação matemática (`@NotNull`) |

---

# Operações disponíveis

A API suporta as seguintes operações:

```text
SOMAR
SUBTRAIR
MULTIPLICAR
DIVIDIR
```

Correspondência matemática:

```text
SOMAR       → +
SUBTRAIR    → -
MULTIPLICAR → *
DIVIDIR     → /
```

---

# Exemplos de utilização

## 1. Soma

### Request

```http
POST /calculadora/somar
Content-Type: application/json
```

```json
{
  "numero1": 10,
  "numero2": 5,
  "operacao": "SOMAR"
}
```

### Response

```json
{
  "numero1": 10,
  "numero2": 5,
  "operacao": "SOMAR",
  "resultado": 15
}
```

---

## 2. Subtração

### Request

```http
POST /calculadora/subtrair
Content-Type: application/json
```

```json
{
  "numero1": 10,
  "numero2": 5,
  "operacao": "SUBTRAIR"
}
```

### Response

```json
{
  "numero1": 10,
  "numero2": 5,
  "operacao": "SUBTRAIR",
  "resultado": 5
}
```

---

## 3. Multiplicação

### Request

```http
POST /calculadora/multiplicar
Content-Type: application/json
```

```json
{
  "numero1": 10,
  "numero2": 5,
  "operacao": "MULTIPLICAR"
}
```

### Response

```json
{
  "numero1": 10,
  "numero2": 5,
  "operacao": "MULTIPLICAR",
  "resultado": 50
}
```

---

## 4. Divisão

### Request

```http
POST /calculadora/dividir
Content-Type: application/json
```

```json
{
  "numero1": 10,
  "numero2": 5,
  "operacao": "DIVIDIR"
}
```

### Response

```json
{
  "numero1": 10,
  "numero2": 5,
  "operacao": "DIVIDIR",
  "resultado": 2
}
```

---

# Divisão por zero

A aplicação possui uma regra específica para divisão por zero.

Quando o campo `numero2` recebe o valor `0` em uma operação de divisão, o Service retorna `0` como resultado.

### Request

```http
POST /calculadora/dividir
Content-Type: application/json
```

```json
{
  "numero1": 10,
  "numero2": 0,
  "operacao": "DIVIDIR"
}
```

### Response

```json
{
  "numero1": 10,
  "numero2": 0,
  "operacao": "DIVIDIR",
  "resultado": 0
}
```

Essa regra evita a ocorrência de erro durante a execução da operação.

---

# Enum Operacoes

A classe `Operacoes` é um `enum` responsável por representar as operações matemáticas disponíveis na API.

Exemplo:

```java
public enum Operacoes {

    SOMAR,
    SUBTRAIR,
    MULTIPLICAR,
    DIVIDIR

}
```

O `enum` centraliza as operações disponíveis e evita a utilização de valores arbitrários para representar as regras de cálculo.

---

# Validação dos dados

A requisição utiliza **Bean Validation** para validar os dados recebidos pela API.

O campo `operacao` utiliza a anotação:

```java
@NotNull
```

Exemplo:

```java
@NotNull
private Operacoes operacao;
```

Dessa forma, a API valida se uma operação foi informada na requisição.

A validação é acionada no Controller através da anotação:

```java
@Valid
```

Exemplo:

```java
public CalculadoraResposta calcular(
        @Valid @RequestBody CalculadoraRequisicao requisicao
)
```

---

# Testes automatizados

O projeto possui testes automatizados utilizando:

* **JUnit 6**
* **Mockito**
* `@ParameterizedTest`
* `@CsvSource`
* `assertEquals`
* `assertThrows`
* `verify`
* `when`

Os testes são separados por responsabilidade.

```text
CalculadoraServiceTest
        ↓
Testa as regras de cálculo

CalculadoraControllerTest
        ↓
Testa o Controller e a comunicação com o Service

ApiCalculadoraApplicationTests
        ↓
Testa a inicialização do contexto Spring Boot
```

---

# Testes do Service

O `CalculadoraServiceTest` testa as regras de cálculo da aplicação.

São testadas as seguintes operações:

```text
10 + 5 = 15
10 - 5 = 5
10 * 5 = 50
10 / 5 = 2
```

Também é testada a regra de divisão por zero:

```text
10 / 0 = 0
```

Os testes podem utilizar `@ParameterizedTest` e `@CsvSource` para validar múltiplos valores em um único método de teste.

Exemplo de cenários:

```text
10 + 5   = 15
20 + 10  = 30
100 + 50 = 150

10 - 5   = 5
20 - 10  = 10
100 - 50 = 50

10 * 5   = 50
20 * 10  = 200
100 * 2  = 200

10 / 5   = 2
20 / 10  = 2
100 / 5  = 20
```

---

# Testes do Controller

O `CalculadoraControllerTest` utiliza Mockito para isolar o `CalculadoraService`.

O objetivo é verificar a comunicação entre o Controller e o Service:

```text
Request
   ↓
Controller
   ↓
Service Mock
   ↓
Response
```

Também são utilizados testes parametrizados para validar diferentes operações e valores.

Exemplos:

```text
10 + 5   = 15
10 - 5   = 5
10 * 5   = 50
10 / 5   = 2
```

O teste também verifica a utilização da validação `@Valid`.

---

# Testes de validação

A aplicação testa cenários em que os dados da requisição são inválidos.

Um dos cenários avaliados é a ausência da operação:

```json
{
  "numero1": 10,
  "numero2": 5,
  "operacao": null
}
```

Nesse cenário, a validação `@NotNull` deve identificar que a operação não foi informada.

---

# Comandos Maven

| Comando               | Descrição                                                                 |
| --------------------- | ------------------------------------------------------------------------- |
| `mvn clean install`   | Limpa, compila, executa os testes e instala o `.jar` no repositório local |
| `mvn clean package`   | Limpa, compila, executa os testes e gera o `.jar` em `target`             |
| `mvn clean test`      | Limpa o projeto e executa todos os testes                                 |
| `mvn spring-boot:run` | Inicia a aplicação Spring Boot                                            |
| `mvn test`            | Executa os testes sem limpar o projeto                                    |
| `mvn clean`           | Remove os arquivos gerados anteriormente                                  |

---

# Gerar o projeto

Para realizar uma compilação completa:

```bash
mvn clean install
```

Para apenas compilar, executar os testes e gerar o `.jar`:

```bash
mvn clean package
```

O arquivo será gerado no diretório:

```text
target/
```

---

# Executar os testes

Para executar todos os testes:

```bash
mvn clean test
```

Ou:

```bash
mvn test
```

O Maven exibirá o resultado dos testes no console.

Exemplo:

```text
Tests run: 15, Failures: 0, Errors: 0, Skipped: 0
```

---

# Executar a aplicação

```bash
mvn spring-boot:run
```

A aplicação será executada em:

```text
http://localhost:8080
```

---

# Swagger / OpenAPI

A documentação da API pode ser acessada através do Swagger UI:

```text
http://localhost:8080/swagger-ui/index.html
```

O Swagger permite visualizar e executar os endpoints diretamente pelo navegador.

---

# Exemplo utilizando cURL

## Soma

```bash
curl -X POST http://localhost:8080/calculadora/somar \
  -H "Content-Type: application/json" \
  -d "{\"numero1\":10,\"numero2\":5,\"operacao\":\"SOMAR\"}"
```

Resposta:

```json
{
  "numero1": 10,
  "numero2": 5,
  "operacao": "SOMAR",
  "resultado": 15
}
```

---

# Regras matemáticas

## Soma

```text
resultado = numero1 + numero2
```

## Subtração

```text
resultado = numero1 - numero2
```

## Multiplicação

```text
resultado = numero1 * numero2
```

## Divisão

```text
resultado = numero1 / numero2
```

Quando `numero2` for `0`:

```text
resultado = 0
```

---

# Objetivo

Projeto desenvolvido para praticar e demonstrar conhecimentos em:

* Java 25
* Spring Boot 4.1.1
* Spring MVC
* API REST
* Controllers
* Services
* DTOs
* Enums
* Injeção de dependência
* Injeção por construtor
* Bean Validation
* `@Valid`
* `@NotNull`
* Regras de negócio
* JUnit 6
* Testes parametrizados
* `@ParameterizedTest`
* `@CsvSource`
* `assertEquals`
* `assertThrows`
* Mockito
* `when`
* `verify`
* Testes unitários
* Testes de Controller
* Springdoc OpenAPI
* Maven

---

# Status do projeto

**Em desenvolvimento / projeto de estudos**

Novas funcionalidades, regras matemáticas e melhorias nos testes poderão ser adicionadas futuramente.
