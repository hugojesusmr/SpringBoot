package net.javacode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javacode.entity.Client;

@Repository
public interface ClientRepository extends  JpaRepository<Client, Long> {

}
