package com.tecsup.petclinic.mapper;

import com.tecsup.petclinic.domain.OwnerTO;
import com.tecsup.petclinic.domain.PetTO;
import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.entities.Pet;
import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValueMappingStrategy =  NullValueMappingStrategy.RETURN_DEFAULT)
public interface OwnerMapper {
    OwnerMapper INSTANCE = Mappers.getMapper(OwnerMapper.class);
    @Mapping(source = "last_name", target = "last_name")
    OwnerTO toOwnerTO(Owner owner);

    @Mapping(source = "last_name", target = "last_name")
    Owner toOwner(OwnerTO ownerTO);

}
