package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.exception.PetNotFoundException;

import java.util.List;

public interface OwnerService {
    /**
     *
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
     * @throws OwnerNotFoundException
     */
    void delete(Integer id) throws OwnerNotFoundException;

    /**
     *
     * @param id
     * @return
     */
    Owner findById(Integer id) throws OwnerNotFoundException;

    /**
     *
     * @param first_name
     * @return
     */
    List<Owner> findByFirstName(String first_name);

    /**
     *
     * @param last_name
     * @return
     */
    List<Owner> findByLastName(String last_name);

    /**
     *
     * @param id
     * @return
     */
    List<Owner> findByOwnerId(int id);

    /**
     *
     * @return
     */
    List<Owner> findAll();


}
