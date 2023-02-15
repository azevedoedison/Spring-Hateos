package com.azevedoedison.hateoas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.azevedoedison.hateoas.model.Client;
import com.azevedoedison.hateoas.repository.ClientRepository;


@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public Client save(Client client) {
		return repository.save(client);		
	}		
	
	public Page<Client> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
	
	public Optional<Client> getClient(Long id) {
		return repository.findById(id);
	}

}
