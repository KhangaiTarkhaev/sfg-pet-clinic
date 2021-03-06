package com.khangaitarkhaev.petclinic.services.map;

import com.khangaitarkhaev.petclinic.model.Owner;
import com.khangaitarkhaev.petclinic.model.Pet;
import com.khangaitarkhaev.petclinic.model.PetType;
import com.khangaitarkhaev.petclinic.model.Vet;
import com.khangaitarkhaev.petclinic.services.CrudService;
import com.khangaitarkhaev.petclinic.services.OwnerService;
import com.khangaitarkhaev.petclinic.services.PetService;
import com.khangaitarkhaev.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractServiceMap<Owner, Long> implements OwnerService {

    private PetTypeService petTypeService;

    private PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        if (owner != null) {
            if (!owner.getPets().isEmpty()) {
                owner.getPets().forEach(pet -> {
                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw  new RuntimeException("Pet Type is required");
                    }

                });
            }
            return super.save(owner);
        } else {
            return null;
        }
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName() {
        return null;
    }
}
