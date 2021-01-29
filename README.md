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

[link para o Swagger!] (http://localhost:8080/swagger-ui.html#/)

Abaixo url para Consumo ou teste no postman 

```
http://localhost:8080/password-validation
```

