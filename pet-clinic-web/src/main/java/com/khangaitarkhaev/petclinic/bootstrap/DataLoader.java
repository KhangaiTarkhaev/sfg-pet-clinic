package com.khangaitarkhaev.petclinic.bootstrap;

import com.khangaitarkhaev.petclinic.model.Owner;
import com.khangaitarkhaev.petclinic.model.Pet;
import com.khangaitarkhaev.petclinic.model.PetType;
import com.khangaitarkhaev.petclinic.model.Vet;
import com.khangaitarkhaev.petclinic.services.OwnerService;
import com.khangaitarkhaev.petclinic.services.PetTypeService;
import com.khangaitarkhaev.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);





        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Bickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("123456789");

        Pet pet1 = new Pet();
        pet1.setName("Neko");
        pet1.setPetType(savedCatPetType);
        pet1.setBirthday(LocalDate.now());
        pet1.setOwner(owner1);

        owner1.getPets().add(pet1);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glennane");
        owner2.setAddress("123 Bickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("123456789");

        Pet pet2 = new Pet();
        pet2.setName("Doge");
        pet2.setPetType(saveDogPetType);
        pet2.setBirthday(LocalDate.now());
        pet2.setOwner(owner2);

        owner2.getPets().add(pet2);
        ownerService.save(owner2);
        System.out.println("Loading Owners ...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loading Vets ...");

    }
}
