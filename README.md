# Spring Hateos Example

O propósito deste exemplo é demonstrar o uso do Spring HATEOAS, uma extensão do framework Spring que oferece suporte para a criação de serviços 
RESTful que seguem o estilo arquitetural HATEOAS (Hypermedia as the Engine of Application State).

De acordo com os níveis de maturidade de Richardson, divididos em nível 0, 1 , 2 e 3, o nível 3 faz referência a Controles de hipermídia, ou seja APIs que possuem estes controles possuem o mais alto nível de maturidade.

Para exemplo foi construida uma simples API com Spring-Boot e Banco de dados H2, com uma entidade Cliente, na qual é possível cadastrar um cliente, listar um cliente e listar todos os clientes.

Para isso, após iniciar a aplicação, basta acessar o endereço http://localhost:8080/swagger-ui/index.html#/

![](https://user-images.githubusercontent.com/414878/218900738-c4472ae9-0820-4fca-becc-f26f1fb43efd.PNG)

Cadastre dois ou mais clientes através do método POST (um por vez):
![](https://user-images.githubusercontent.com/414878/218904273-891334c7-b1ff-46ae-8344-6a22c8be3c71.PNG)

E Liste os objetos com seus respectivos links de navegação, via swagger:
![](https://user-images.githubusercontent.com/414878/218901676-e5886022-088a-49e3-8ed1-d185a8eda829.PNG)
![](https://user-images.githubusercontent.com/414878/218901887-6b46d10e-5d96-4138-b6cd-451c63cd7bcc.PNG)


Ou via Postman:

![](https://user-images.githubusercontent.com/414878/218902186-fc8ee899-ef3d-4033-89a6-62ea3554facb.PNG)

O que foi feito:

Dentro do pom.xml foi adicionada a dependência do Spring-Hateoas:
![](https://user-images.githubusercontent.com/414878/218905707-47e3e9bb-32c5-4274-b0d3-7787cd43f189.PNG)

A entidade Client começa a extender representantionModel:
![](https://user-images.githubusercontent.com/414878/218905820-3c5919f5-e6eb-46f8-b830-1fe762e9485d.PNG)

Na controler cria-se uma iteração sobre a lista de clientes contidos na página clientPage e adiciona um link de autoreferência a cada cliente:
![](https://user-images.githubusercontent.com/414878/218905980-4a387ce8-7af8-4789-8fe1-5cb3829aa87b.PNG)
