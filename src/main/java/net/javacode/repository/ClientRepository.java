package net.javacode.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.javacode.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

}
