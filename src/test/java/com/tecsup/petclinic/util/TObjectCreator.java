package com.tecsup.petclinic.util;

import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.entities.Owner;

import java.util.ArrayList;
import java.util.List;

public class TObjectCreator {

	public static Pet getPet() {
		return new Pet(1,"Leo",1,1, null);
	}

	public static Pet newPet() {
		return new Pet(0,"Punky",1,1, null);
	}

	public static Pet newPetCreated() {
		Pet pet = newPet();
		pet.setId(1000);
		return pet;
	}

	public static Pet newPetForUpdate() {
		return new Pet(0,"Bear",1,1,null);
	}

	public static Pet newPetCreatedForUpdate() {
		Pet pet = newPetForUpdate();
		pet.setId(4000);
		return pet;
	}

	public static Pet newPetForDelete() {
		return new Pet(0,"Bird",1,1, null);
	}

	public static Pet newPetCreatedForDelete() {
		Pet pet = newPetForDelete();
		pet.setId(2000);
		return pet;
	}

	public static List<Pet> getPetsForFindByName() {
		List<Pet> pets  = new ArrayList<Pet>();
		pets.add(new Pet(1,"Leo",1,1, null));
		return pets;
	}

	public static List<Pet> getPetsForFindByTypeId() {
		List<Pet> pets  = new ArrayList<Pet>();
		pets.add(new Pet(9,"Lucky",5,7, null));
		pets.add(new Pet(11,"Freddy",5,9, null));
		return pets;
	}

	public static List<Pet> getPetsForFindByOwnerId() {
		List<Pet> pets  = new ArrayList<Pet>();
		pets.add(new Pet(12,"Lucky",2,10, null));
		pets.add(new Pet(13,"Sly",1,10, null));
		return pets;
	}



	/* OWNER */
	public static Owner getOwner() {
		return new Owner(1,"Mario", "Espinoza",null,null,null);
	}

	public static Owner newOwner() {
		return new Owner(0,"Mario","Ventosilla",null,null, null);
	}

	public static Owner newOwnerCreated() {
		Owner owner = newOwner();
		owner.setId(1000);
		return owner;
	}

	public static Owner newOwnerForUpdate() {
		return new Owner(0,"Fernanda","Villo",null,null,null);
	}

	public static Owner newOwnerCreatedForUpdate() {
		Owner owner = newOwnerForUpdate();
		owner.setId(4000);
		return owner;
	}

}
