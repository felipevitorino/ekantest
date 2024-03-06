# API de Gerenciamento de Beneficiários

## Escopo de Criação

A aplicação foi desenvolvida com foco nas funcionalidades principais, visando os seus comportamentos. 

Não foram implementadas classes de serviço devido à simplicidade das regras, ficando assim a cargo do controller.

### Tecnologias Utilizadas
- Java 17
- Spring
- JPA
- Eclipse IDE
- Banco de Dados H2 (embarcado)
- Insomnia (para testes/debug durante o desenvolvimento)
- SpringDoc (para acesso e documentação da API via navegador)
- Maven
- Git

## Instruções para Instalação

1. Clonar o repositório:

```bash
git clone https://github.com/felipevitorino/ekantest.git
```
2. Compilar o pacote com Maven:
```bash
mvn package
```
3. Executar o artefato gerado no subdiretório do projeto /target/ekan-0.0.1-SNAPSHOT.jar:
```bash
java -jar <diretório>/target/ekan-0.0.1-SNAPSHOT.jar
```
## Instruções para Testar as Funcionalidades

Você pode utilizar qualquer cliente RESTful de sua preferência. A seguir, estão listadas as requisições e seus conteúdos:

### Cadastrar Beneficiário
<img src="https://github.com/felipevitorino/ekantest/assets/8423063/e1386eff-27e6-4037-898b-f4e21c46b42d">

- POST **URL:** `http://localhost:8080/beneficiarios`
- **JSON:**
  ```json
  {
      "nome": "Joao da Silva",
      "telefone": "1199887744",
      "dataNascimento": "2024-03-01T10:00:00",
      "documentos": [
          {
              "tipoDocumento": "RG",
              "descricao": "Registro Geral"
          },
          {
              "tipoDocumento": "CPF",
              "descricao": "Cadastro Pessoa Física"
          }
      ]
  }
  ```

### Listar Beneficiários
<img src="https://github.com/felipevitorino/ekantest/assets/8423063/b0785ac2-1a64-4278-8064-9987bb38677a">

- GET **URL:** [http://localhost:8080/beneficiarios](http://localhost:8080/beneficiarios)

### Listar Documentos por Beneficiário
<img src="https://github.com/felipevitorino/ekantest/assets/8423063/875eab4d-fa64-474a-a9ad-becc0b66ab4d">

- GET **URL:** [http://localhost:8080/documentos/beneficiario/1](http://localhost:8080/documentos/beneficiario/1)

### Atualizar Benficiário
<img src="https://github.com/felipevitorino/ekantest/assets/8423063/a8263993-5f0a-4e9e-8669-d7445836d4bb">

- PUT **URL:** `http://localhost:8080/beneficiarios`
- - **JSON:**
  ```json
	{
    "id": 1,
	"nome": "Felipe Vitorino",
    "telefone": "123",
    "dataNascimento": "1988-03-15T10:00:00"
  }
  ```

### Apagar Benficiário
<img src="https://github.com/felipevitorino/ekantest/assets/8423063/9527a656-cafa-4f11-bed2-1cc83430ee54">

 - DELETE **URL:** [http://localhost:8080/documentos/beneficiario/1](http://localhost:8080/beneficiario/1)
