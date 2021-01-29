# password validator
API de validação de senha, considerando validas Nove ou mais caracteres, Ao menos 1 dígito, Ao menos 1 letra minúscula, Ao menos 1 letra maiúscula, Ao menos 1 caractere especial, Considerando como especial os seguintes caracteres: !@#$%^&*()-+, Não possuir caracteres repetidos dentro do conjunto, Com um metodo POST para validação 

# Stack

| Item        | Version           | 
| ------------- |:-------------:| 
| Java     | 11 | 
| Lombok      |     | 
| Spring-boot | 2.3.4.RELEASE |
| Swagger | 2.9.2 |
| Jacoco | Latest |

# Configurações padrões 

- `Cobertura de testes: 95%`
- `Porta padrão: 8080`


# Como executar a aplicação localmente ?

Na raiz do projeto execultar o comando abaixo para que o projeto seja buildado e os testes sejam executados,  
```
gradle build
```
Com o comando executado bastar ir na classe main do projeto e executar o projeto, assim que startado o serviço do springboot ficará online 

# IMG

# Requisições da API 

Com a aplicação online, podemos realizar requisições na API, para que seja mais produtivo realizei a configuração do Swagger para documentar a API, Abaixo endereço padrão do Swagger 

(http://localhost:8080/swagger-ui.html#/)

Abaixo url para Consumo ou teste no postman 

```
http://localhost:8080/password-validation
```
Exemplo de Request

```
{
  "password": "string"
}
```

# Detalhe sobre a solução

A ideia do projeto é uma API de validação de senhas onde o usuario informa a senha e o sistema retorna se a senha é valida ou inválida, para que a solicitação fosse atendida precisei criar 2 metodos, um onde checa se é verdeiro ou falso, e outra para ver se a senha segue os padrões, eu preferi deixar cada metodo com sua responsabilidade até por uma questão de reaproveitamento de codigo no futuro com o surgimento de uma nova demanda em cima da solução, para o validador criei uma Função regex para atender os requisitos, Ao menos 1 dígito, Ao menos 1 letra minúscula, Ao menos 1 letra maiúscula, Ao menos 1 caractere especial, Considerando como especial os seguintes caracteres: !@#$%^&*()-+, e para Não possuir caracteres repetidos dentro do conjunto criei uma logica em Java.

Como a necessidade do projeto era retornar apenas um boolean então decidi criar essa logicas em uma service, Mas em outra solução onde o usuario necessitasse de algo mais detalhado, eu criaria no request um @Pattern com os regex para validação e mensagem de falha, criaria um advice para interceptar tudo que o usuario informou errado, exemplo de json abaixo 

```
{
  "errors": [
    "Necessario uma letra maiuscula",
    "Necessario um caracter especial"
    
  ]
}
```
Como a requisição sempre é feita com sucesso independente da senha ser verdadeira ou falsa optei por sempre retornar 200OK, O jacoco é uma ferramenta otima para garantir a qualidade do projeto conseguindo medir minha cobertura de testes e gerando relatorios assim é possivel saber que o projeto será aprovado na esteira devOps



