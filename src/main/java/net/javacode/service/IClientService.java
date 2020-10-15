package net.javacode.service;

import java.util.List;

import net.javacode.entity.Client;

public interface IClientService {
	public List<Client> findAll();
	public void save(Client client);
	public Client findById(Long id);
	public void delete(Long id);

}
