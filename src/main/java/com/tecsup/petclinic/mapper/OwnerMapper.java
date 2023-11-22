package com.tecsup.petclinic.mapper;

import com.tecsup.petclinic.domain.OwnerTo;
import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.entities.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface OwnerMapper {
    OwnerMapper INSTANCE = Mappers.getMapper(OwnerMapper.class);

    @Mappings({
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "city", target = "city"),
            @Mapping(source = "telephone", target = "telephone")
    })

    List<OwnerTo> toOwnerTOList(List<Owner> ownerList);

    List<Owner> toOwnerList(List<OwnerTo> ownerTOList);

    Owner toOwner(OwnerTo ownerTo);
    OwnerTo toOwnerTo(Owner owner);
}
