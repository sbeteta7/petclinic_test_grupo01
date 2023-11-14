package com.tecsup.petclinic.repositories;

import com.tecsup.petclinic.entities.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository
extends CrudRepository<Owner,Integer> {

    // Fetch owner by name
    List<Owner> findByFirstName(String first_name);

    List<Owner> findByLastName(String Last_name);

    // Fetch owner by ownerId
    List<Owner> findByOwnerId(int id);

    @Override
    List<Owner> findAll();

}
