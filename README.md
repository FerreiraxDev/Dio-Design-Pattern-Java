# Projeto Car Builder API

Este repositório contém um projeto de exemplo em Java e Spring Boot que demonstra a aplicação prática do **Builder Design Pattern** em uma arquitetura de API REST moderna e robusta. O objetivo é mostrar como construir objetos complexos e imutáveis de forma limpa e legível dentro de uma aplicação em camadas.

---

## ✨ Conceitos e Padrões Demonstrados

- **Padrão de Projeto Builder**: Utilizado para construir objetos `Carro` complexos, separando o processo de construção da representação final do objeto, resultando em um código mais limpo e na criação de objetos imutáveis.
- **Arquitetura em Camadas**: Separação clara de responsabilidades entre Controllers (API), Services (Lógica de Negócio) e DTOs.
- **API REST com Spring Web (MVC)**: Exposição de endpoints `POST` e `GET` para interagir com o sistema.
- **Uso de DTOs (Data Transfer Objects)**: O `CarroRequestDTO` desacopla o modelo da API do modelo de domínio interno (`Carro`), além de servir como portador para as validações.
- **Validação de Requisições (Bean Validation)**: Validação automática e declarativa dos dados de entrada para garantir a integridade antes de processá-los.
- **Injeção de Dependências**: O framework Spring Boot gerencia o ciclo de vida e a injeção de componentes como o `CarroService`.

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Maven** (Gerenciador de dependências)
- **Spring Web** (Para a construção da API REST)
- **Spring Validation** (Para a validação de dados)
- **Lombok** (Para reduzir código boilerplate - Opcional, mas recomendado)

---

## 📂 Estrutura do Projeto

A estrutura do projeto segue as convenções do Spring Boot, separando as classes por sua responsabilidade:

```
src/main/java/com/example/carbuilder/
├── CarBuilderApplication.java  // Ponto de entrada da aplicação
├── model/
│   └── Carro.java              // A entidade de domínio imutável com o Builder
├── dto/
│   └── CarroRequestDTO.java    // Objeto para transferência de dados da API
├── service/
│   └── CarroService.java       // Camada de serviço com a lógica de negócio
└── controller/
    └── CarroController.java    // Controller REST que expõe os endpoints
```

---

## 🚀 Como Executar o Projeto

### Pré-requisitos

- **JDK 17** ou superior instalado.
- **Apache Maven 3.8+** instalado.

### Passos

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/car-builder.git](https://github.com/seu-usuario/car-builder.git)
    ```

2.  **Navegue até o diretório do projeto:**
    ```bash
    cd car-builder
    ```

3.  **Execute a aplicação com o Maven:**
    ```bash
    mvn spring-boot:run
    ```

4.  A aplicação será iniciada e estará disponível em `http://localhost:8080`.

---

## 📋 Documentação da API

A API expõe dois endpoints para gerenciar os carros.

### 1. Criar um Carro

Cria um novo objeto `Carro` com base nos dados fornecidos.

- **URL**: `/api/carros`
- **Método**: `POST`
- **Content-Type**: `application/json`

#### Exemplo de Corpo da Requisição (JSON)

Os campos `motor` e `rodas` são obrigatórios. Os demais são opcionais.

```json
{
    "motor": "V8 Turbo",
    "rodas": 4,
    "cor": "Vermelho",
    "temGps": true,
    "temTetoSolar": false,
    "temSpoiler": true
}
```

#### Resposta de Sucesso (Código `201 Created`)

```json
{
    "id": 1,
    "motor": "V8 Turbo",
    "rodas": 4,
    "cor": "Vermelho",
    "temGps": true,
    "temTetoSolar": false,
    "temSpoiler": true
}
```

#### Resposta de Erro (Código `400 Bad Request`)

Ocorre se os dados obrigatórios não forem fornecidos ou se a validação falhar.

```json
{
    "timestamp": "2025-08-27T19:55:00.123+00:00",
    "status": 400,
    "error": "Bad Request",
    "errors": [
        {
            "defaultMessage": "O motor é obrigatório.",
            "field": "motor"
        }
    ],
    "path": "/api/carros"
}
```

### 2. Listar todos os Carros

Retorna uma lista de todos os carros que foram criados.

- **URL**: `/api/carros`
- **Método**: `GET`

#### Resposta de Sucesso (Código `200 OK`)

```json
[
    {
        "id": 1,
        "motor": "V8 Turbo",
        "rodas": 4,
        "cor": "Vermelho",
        "temGps": true,
        "temTetoSolar": false,
        "temSpoiler": true
    },
    {
        "id": 2,
        "motor": "1.0 Flex",
        "rodas": 4,
        "cor": "Branco",
        "temGps": false,
        "temTetoSolar": false,
        "temSpoiler": false
    }
]
```
