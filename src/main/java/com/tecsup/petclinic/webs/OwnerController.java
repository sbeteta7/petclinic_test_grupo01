package com.tecsup.petclinic.webs;

import com.tecsup.petclinic.domain.OwnerTo;
import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.mapper.OwnerMapper;
import com.tecsup.petclinic.services.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class OwnerController {

    //@Autowired
    private OwnerService ownerService;

    //@Autowired
    private OwnerMapper mapper;

    /**
     *  Change
     * @param ownerService
     * @param mapper
     */
    public OwnerController(OwnerService ownerService, OwnerMapper mapper){
        this.ownerService = ownerService;
        this.mapper = mapper ;
    }

    @GetMapping(value = "/owners")
    public ResponseEntity<List<OwnerTo>> findAllOwners() {

        List<Owner> owners = (List<Owner>) ownerService.findAll();
        log.info("owner: " + owners);
        owners.forEach(item -> log.info("Owner >>  {} ", item));

        List<OwnerTo> ownerTo = this.mapper.toOwnerTOList(owners);
        log.info("ownerTo: " + ownerTo);
        ownerTo.forEach(item -> log.info("OwnerTo >>  {} ", item));

        return ResponseEntity.ok(ownerTo);

    }

    @GetMapping(value = "/owner/{id}")
    ResponseEntity<OwnerTo> findById(@PathVariable Integer id) {

        OwnerTo ownetTo = null;

        try {
            Owner owner = ownerService.findById(id);
            ownetTo = this.mapper.toOwnerTo(owner);

        } catch (OwnerNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ownetTo);

    }
}
