package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@Slf4j
public class OwnerServiceTest {

	@Autowired
   	private OwnerService ownerService;

	/**
	 * 
	 */

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

}
