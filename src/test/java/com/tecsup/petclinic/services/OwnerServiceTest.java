package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class OwnerServiceTest {

	@Autowired
   	private OwnerService ownerService;

	/**
	 * 
	 */
/*
	@Test
	public void testFindOwnerById() {

		Integer ID = 1;
		String NAME = "Jaime";
		Owner owner = null;
		
		try {
			
			owner = this.ownerService.findById(ID);
			
		} catch (OwnerNotFoundException e) {
			fail(e.getMessage());
		}
		log.info("" + owner);

		assertEquals(NAME, owner.getFirst_name());

	}
*/
	@Test
	public void testCreateOwner() {

		String OWNER_NAME = "Mario";
		String OWNER_LASTNAME="Ventosilla";


		Owner owner = new Owner(OWNER_NAME, OWNER_LASTNAME,null,null,null);

		Owner ownerCreated = this.ownerService.create(owner);

		log.info("OWNER CREATED :" + ownerCreated.toString());

		assertNotNull(ownerCreated.getId());
		assertEquals(OWNER_NAME, ownerCreated.getFirst_name());
		assertEquals(OWNER_LASTNAME, ownerCreated.getLast_name());
	}

	@Test
	public void testUpdateOwner() {

		String OWNER_NAME = "Fernanda";
		String OWNER_LASTNAME="Villo";

		String UP_OWNER_NAME = "Fernando";
		String UP_OWNER_LASTNAME="Villa";


		Owner owner = new Owner(OWNER_NAME, OWNER_LASTNAME, null, null,null);

		// ------------ Create ---------------

		log.info(">" + owner);
		Owner ownerCreated = this.ownerService.create(owner);
		log.info(">>" + ownerCreated);

		// ------------ Update ---------------

		// Prepare data for update
		ownerCreated.setFirst_name(UP_OWNER_NAME);
		ownerCreated.setLast_name(UP_OWNER_LASTNAME);


		// Execute update
		Owner upgradeOwner = this.ownerService.update(ownerCreated);
		log.info(">>>>" + upgradeOwner);

		//            EXPECTED        ACTUAL
		assertEquals(UP_OWNER_NAME, upgradeOwner.getFirst_name());
		assertEquals(UP_OWNER_LASTNAME, upgradeOwner.getLast_name());

	}




}
