# Spring Hateos Example

The purpose of this example is to demonstrate the use of Spring HATEOAS, an extension of the Spring framework that supports creating services
RESTful that follows the HATEOAS (Hypermedia as the Engine of Application State) architectural style.

According to Richardson's maturity levels, divided into levels 0, 1, 2 and 3, level 3 refers to Hypermedia Controls, ie APIs that have these controls have the highest level of maturity.

For example, a simple API was built with Spring-Boot and H2 Database, with a Customer entity, in which it is possible to register a customer, list a customer and list all customers.



To do this, after starting the application, just access the swagger url:  http://localhost:8080/swagger-ui/index.html#/

![](https://user-images.githubusercontent.com/414878/218900738-c4472ae9-0820-4fca-becc-f26f1fb43efd.PNG)

Register two or more clients using the POST method (one at a time):
![](https://user-images.githubusercontent.com/414878/218904273-891334c7-b1ff-46ae-8344-6a22c8be3c71.PNG)

And List the objects with their respective navigation links, via swagger:
![](https://user-images.githubusercontent.com/414878/218901676-e5886022-088a-49e3-8ed1-d185a8eda829.PNG)
![](https://user-images.githubusercontent.com/414878/218901887-6b46d10e-5d96-4138-b6cd-451c63cd7bcc.PNG)


Or via Postman:

![](https://user-images.githubusercontent.com/414878/218902186-fc8ee899-ef3d-4033-89a6-62ea3554facb.PNG)

What I did:

Inside the pom.xml the Spring-Hateoas dependency was added:
![](https://user-images.githubusercontent.com/414878/218905707-47e3e9bb-32c5-4274-b0d3-7787cd43f189.PNG)

The Client entity starts to extend representationModel:
![](https://user-images.githubusercontent.com/414878/218905820-3c5919f5-e6eb-46f8-b830-1fe762e9485d.PNG)

In the controller we iterate over the list of customers contained in the clientPage page and add a self-referral link to each customer:
![](https://user-images.githubusercontent.com/414878/218905980-4a387ce8-7af8-4789-8fe1-5cb3829aa87b.PNG)
