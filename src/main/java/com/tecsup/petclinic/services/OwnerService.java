package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.exception.PetNotFoundException;

import java.util.List;

public interface OwnerService {
    /**
     * @param owner
     * @return
     */
    Owner create(Owner owner);
    /**
     *
     * @param owner
     * @return
     */
    Owner update(Owner owner);
    /**
     *
     * @param id
     * @return
     */
    Owner findById(Integer id) throws OwnerNotFoundException;

}
