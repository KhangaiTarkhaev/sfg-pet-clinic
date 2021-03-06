package com.khangaitarkhaev.petclinic.bootstrap;

import com.khangaitarkhaev.petclinic.model.*;
import com.khangaitarkhaev.petclinic.services.OwnerService;
import com.khangaitarkhaev.petclinic.services.PetTypeService;
import com.khangaitarkhaev.petclinic.services.SpecialtyService;
import com.khangaitarkhaev.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        //Start PetType initialization
        PetType dog = new PetType();
        dog.setName("dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);
        //End of PetType initialization

        //Start of owners and pets initialization
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
        //End of owners and pets initialization


        //Start of vets and specialization initialization
        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");

        vet1.getSpecialties().add(specialtyService.save(radiology));

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");

        vet2.getSpecialties().add(specialtyService.save(surgery));
        vetService.save(vet2);

        System.out.println("Loading Vets ...");
        //End of vets and specs initialization
    }
}
