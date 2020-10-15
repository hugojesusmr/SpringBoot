package net.javacode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javacode.entity.Client;
import net.javacode.repository.ClientRepository;

@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public List<Client> findAll() {
	
		return (List<Client>) clientRepository.findAll();
	}

	@Override
	public void save(Client client) {
		clientRepository.save(client);
	}

	@Override
	public Client findById(Long id) {
		return clientRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		clientRepository.deleteById(id);

	}

}
