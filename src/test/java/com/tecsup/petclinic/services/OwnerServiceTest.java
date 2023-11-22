package com.tecsup.petclinic.services;

import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.repositories.OwnerRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@Slf4j
public class OwnerServiceTest {

	@Mock
	private OwnerRepository ownerRepository;

	@InjectMocks
	private OwnerServicelmpl ownerService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindByOwnerId() {
		Integer ID = 1;
		String FIRST_NAME = "George";
		String LAST_NAME = "Franklin";
		String ADDRESS = "110 W. Liberty St.";
		String CITY = "Madison";
		String TELEPHONE = "6085551023";
		Owner owner = null;

		try {
			owner = this.ownerService.findById(ID);
			System.out.println("Se encontró el owner");
			log.info("" + owner);
			assertEquals(FIRST_NAME, owner.getFirstName());
			assertEquals(LAST_NAME, owner.getLastName());
			assertEquals(ADDRESS, owner.getAddress());
			assertEquals(CITY, owner.getCity());
			assertEquals(TELEPHONE, owner.getTelephone());

		} catch (OwnerNotFoundException e) {
			System.out.println("No se encontró el owner");
            throw new RuntimeException(e);
        }


	}

}
