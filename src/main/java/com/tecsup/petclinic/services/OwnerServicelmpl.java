package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.repositories.OwnerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class OwnerServicelmpl implements OwnerService{

    OwnerRepository ownerRepository;

    public OwnerServicelmpl (OwnerRepository ownerRepository) {
        this. ownerRepository = ownerRepository;
    }


    /**
     *
     * @param owner
     * @return
     */
    @Override
    public Owner create(Owner owner) {
        return ownerRepository.save(owner);
    }

    /**
     *
     * @param owner
     * @return
     */
    @Override
    public Owner update(Owner owner) {
        return ownerRepository.save(owner);
    }



    /**
     *
     * @param id
     * @return
     */
    @Override
    public Owner findById(Integer id) throws OwnerNotFoundException {

        Optional<Owner> owner = ownerRepository.findById(id);

        if ( !owner.isPresent())
            throw new OwnerNotFoundException("Record not found...!");

        return owner.get();
    }

}
