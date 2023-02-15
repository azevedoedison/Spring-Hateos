package com.azevedoedison.hateoas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.azevedoedison.hateoas.model.Client;
import com.azevedoedison.hateoas.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client save(Client client) {
		return service.save(client);
	}

	@GetMapping
	public ResponseEntity<Page<Client>> getAllUsers(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		Page<Client> clientPage = service.findAll(pageable);
				
		if (!clientPage.isEmpty()) {
			/* itera sobre a lista de clientes contidos na página clientPage e adiciona um link de autoreferência a cada cliente.*/
			clientPage.toList().forEach(client -> client
					.add(linkTo(methodOn(ClientController.class).getClient(client.getId())).withSelfRel()));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(clientPage);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Client getClient(@PathVariable("id") Long id) {
		return service.getClient(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

}
