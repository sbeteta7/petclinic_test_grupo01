package com.tecsup.petclinic.services;


import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.exception.PetNotFoundException;
import com.tecsup.petclinic.repositories.OwnerRepository;
import com.tecsup.petclinic.repositories.PetRepository;
import com.tecsup.petclinic.util.TObjectCreator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class OwnerServiceMockitoTest {

    private OwnerService ownerService;

    @Mock
    private OwnerRepository repository;

    @BeforeEach
    void setUp() {
        this.ownerService = new OwnerServicelmpl(this.repository);
    }

    /**
     *
     */
/*
    @Test
    public void testFindOwnerById() {

        Owner ownerExpected = TObjectCreator.getOwner();




        Mockito.when(this.repository.findById(ownerExpected.getId()))
                .thenReturn((Optional.of(ownerExpected)));



        try {
            ownerExpected = this.ownerService.findById(ownerExpected.getId());
        } catch (PetNotFoundException e) {
            fail(e.getMessage());
        }

        log.info("" + ownerExpected);
        assertEquals(ownerExpected.getName(), ownerExpected.getName());

    }

*/

    /**
     * To get ID generate , you need
     * setup in id primary key in your
     * entity this annotation :
     *
     * @GeneratedValue(strategy = GenerationType.IDENTITY)
     */
    @Test
    public void testCreateOwner() {

        Owner newOwner = TObjectCreator.newOwner();
        Owner newCreateOwner = TObjectCreator.newOwnerCreated();

        Mockito.when(this.repository.save(newOwner))
                .thenReturn(newCreateOwner);

        Owner ownerCreated = this.ownerService.create(newOwner);

        log.info("Owner created : {}" , ownerCreated);

        assertNotNull(ownerCreated.getId());
        assertEquals(newCreateOwner.getFirst_name(), ownerCreated.getFirst_name());
        assertEquals(newCreateOwner.getLast_name(), ownerCreated.getLast_name());


    }

    /**
     *
     */


    @Test
    public void testUpdatePet() {

        String UP_OWNER_NAME = "Fernando";
        String UP_OWNER_LASTNAME="Villa";


        Owner newOwner = TObjectCreator.newOwnerForUpdate();
        Owner newOwnerCreate = TObjectCreator.newOwnerCreatedForUpdate();

        // ------------ Create ---------------

        Mockito.when(this.repository.save(newOwner))
                .thenReturn(newOwnerCreate);

        Owner ownerCreated = this.ownerService.create(newOwner);
        log.info("{}" , ownerCreated);

        // ------------ Update ---------------

        // Prepare data for update
        ownerCreated.setFirst_name(UP_OWNER_NAME);
        ownerCreated.setLast_name(UP_OWNER_LASTNAME);


        Owner newUpdate = ownerCreated;

        // Create
        Mockito.when(this.repository.save(ownerCreated))
                .thenReturn(newUpdate);

        // Execute update
        Owner upgradeOwner = this.ownerService.update(ownerCreated);
        log.info("{}" + upgradeOwner);

        //            EXPECTED           ACTUAL
        assertEquals(UP_OWNER_NAME, upgradeOwner.getFirst_name());
        assertEquals(UP_OWNER_LASTNAME, upgradeOwner.getLast_name());

    }

    @Test
    public void testFindPetById() {

        Owner ownerExpected = TObjectCreator.getOwner();

        Mockito.when(this.repository.findById(ownerExpected.getId()))
                .thenReturn((Optional.of(ownerExpected)));



        try {
            ownerExpected = this.ownerService.findById(ownerExpected.getId());
        } catch (OwnerNotFoundException e) {
            fail(e.getMessage());
        }

        log.info("" + ownerExpected);
        assertEquals(ownerExpected.getFirst_name(), ownerExpected.getFirst_name());

    }



}
