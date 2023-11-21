package com.tecsup.petclinic.webs;

import com.tecsup.petclinic.entities.Pet;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class OwnerController {
    @GetMapping(value = "/pets")
    public ResponseEntity<List<PetTO>> findAllPets() {

        List<Pet> pets = (List<Pet>) petService.findAll();
        log.info("pets: " + pets);
        pets.forEach(item -> log.info("Pet >>  {} ", item));

        List<PetTO> petsTO = this.mapper.toPetTOList(pets);
        log.info("petsTO: " + petsTO);
        petsTO.forEach(item -> log.info("PetTO >>  {} ", item));

        return ResponseEntity.ok(petsTO);

    }
}
