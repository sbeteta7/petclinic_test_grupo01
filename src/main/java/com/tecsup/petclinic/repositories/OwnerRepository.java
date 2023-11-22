package com.tecsup.petclinic.repositories;

import com.tecsup.petclinic.entities.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OwnerRepository
extends CrudRepository<Owner,Integer> {

    // Fetch owner by name
    List<Owner> findByfirstName(String firstName);

    List<Owner> findBylastName(String lastName);

    // Fetch owner by ownerId
    List<Owner> findById(int id);

    @Override
    List<Owner> findAll();

}
