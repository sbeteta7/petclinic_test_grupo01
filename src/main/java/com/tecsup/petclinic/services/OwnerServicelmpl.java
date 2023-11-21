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
     * @throws OwnerNotFoundException
     */
    @Override
    public void delete(Integer id) throws OwnerNotFoundException{

        Owner owner = findById(id);
        ownerRepository.delete(owner);

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

    /**
     *
     * @param first_name
     * @return
     */
    @Override
    public List<Owner> findByFirstName(String first_name) {

        List<Owner> owners = ownerRepository.findByfirstName(first_name);

        owners.stream().forEach(owner -> log.info("" + owner));

        return owners;
    }

    /**
     *
     * @param last_name
     * @return
     */
    @Override
    public List<Owner> findByLastName(String last_name) {

        List<Owner> owners = ownerRepository.findBylastName(last_name);

        owners.stream().forEach(owner -> log.info("" + owner));

        return owners;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public List<Owner> findByOwnerId(int id) {

        List<Owner> owners = ownerRepository.findById(id);

        owners.stream().forEach(owner -> log.info("" + owner));

        return owners;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Owner> findAll() {
        //
        return ownerRepository.findAll();

    }
}
