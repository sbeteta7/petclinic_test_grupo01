package com.tecsup.petclinic.webs;


import com.tecsup.petclinic.mapper.OwnerMapper;
import com.tecsup.petclinic.services.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.tecsup.petclinic.domain.OwnerTO;
import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.services.OwnerService;
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

    /**
     * Create owner
     *
     * @param ownerTO
     * @return
     */
    @PostMapping(value = "/owners")
    @ResponseStatus(HttpStatus.CREATED)
     ResponseEntity<OwnerTO> create(@RequestBody OwnerTO ownerTO) {

        Owner newOwner = this.mapper.toOwner(ownerTO);
        OwnerTO newOwnerTO = this.mapper.toOwnerTO(ownerService.create(newOwner));

        return  ResponseEntity.status(HttpStatus.CREATED).body(newOwnerTO);

    }
}
