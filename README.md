# Password validator
API de validação de senha, considerando validas Nove ou mais caracteres, Ao menos 1 dígito, Ao menos 1 letra minúscula, Ao menos 1 letra maiúscula, Ao menos 1 caractere especial, Considerando como especial os seguintes caracteres: !@#$%^&*()-+, Não possuir caracteres repetidos dentro do conjunto, Com um método POST para validação

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

Na raiz do projeto executar o comando abaixo para que o projeto seja buildado e os testes sejam executados,  
  
```
gradle build
```
![terminal](https://user-images.githubusercontent.com/67074676/106300045-bd60ef00-6234-11eb-8b48-1223cebf9787.JPG)

Com o comando executado bastar ir na classe main do projeto e executar o projeto, assim que startado o serviço do spring boot ficará online 

![tempsnip](https://user-images.githubusercontent.com/67074676/106299450-edf45900-6233-11eb-88a9-47240f1d67ab.png)


# Requisições da API 

Com a aplicação online, podemos realizar requisições na API, para que seja mais produtivo realizei a configuração do Swagger para documentar a API, Abaixo endereço padrão do Swagger 

(http://localhost:8080/swagger-ui.html#/)

Abaixo url para Consumo ou teste no postman 

```
http://localhost:8080/password-validation
```
![Capturar](https://user-images.githubusercontent.com/67074676/106299770-5b07ee80-6234-11eb-8a4f-5e5cdcb4e638.JPG)

Exemplo de Request

```
{
  "password": "string"
}
```

# Detalhe sobre a solução
A ideia do projeto é uma API de validação de senhas onde o usuário informa a senha e o sistema retorna se a senha é valida ou inválida, para que a solicitação fosse atendida precisei criar 2 métodos, um onde checa se é verdadeiro ou falso, e outra para ver se a senha segue os padrões, eu preferi deixar cada método com sua responsabilidade até por uma questão de reaproveitamento de código no futuro com o surgimento de uma nova demanda em cima da solução, para o validador criei uma Função regex para atender os requisitos, Ao menos 1 dígito, Ao menos 1 letra minúscula, Ao menos 1 letra maiúscula, Ao menos 1 caractere especial, Considerando como especial os seguintes caracteres: !@#$%^&*()-+, e para Não possuir caracteres repetidos dentro do conjunto criei uma logica em Java. 

Como a necessidade do projeto era retornar apenas um boolean então decidi criar essa logicas em uma service, Mas em outra solução onde o usuário necessitasse de algo mais detalhado, eu criaria no request um @Pattern com os regex para validação e mensagem de falha, criaria um advice para interceptar tudo que o usuário informou errado, exemplo de json abaixo 

```
{
  "errors": [
    "Necessario uma letra maiuscula",
    "Necessario um caracter especial"
    
  ]
}
```
Como a requisição sempre é feita com sucesso independente da senha ser verdadeira ou falsa optei por sempre retornar 200OK, O jacoco é uma ferramenta ótima para garantir a qualidade do projeto conseguindo medir minha cobertura de testes e gerando relatórios assim é possível saber que o projeto será aprovado na esteira devOps

Docker File - optei por não configurar e instruir o usuário a executar a aplicação usando o docker, assim o usuário não tem a dependência de instalar ferramentas para executar o projeto 
