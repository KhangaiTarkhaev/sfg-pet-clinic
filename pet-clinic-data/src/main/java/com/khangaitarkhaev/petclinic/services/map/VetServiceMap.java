package com.khangaitarkhaev.petclinic.services.map;

import com.khangaitarkhaev.petclinic.model.Specialty;
import com.khangaitarkhaev.petclinic.model.Vet;
import com.khangaitarkhaev.petclinic.services.CrudService;
import com.khangaitarkhaev.petclinic.services.OwnerService;
import com.khangaitarkhaev.petclinic.services.SpecialtyService;
import com.khangaitarkhaev.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractServiceMap<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {
        if (vet != null) {
            if (!vet.getSpecialties().isEmpty()) {
                vet.getSpecialties().forEach(specialty -> {
                    if (specialty.getId() == null) {
                        Specialty savedSpecialty = specialtyService.save(specialty);
                        specialty.setId(savedSpecialty.getId());
                    }
                });
            }
            return super.save(vet);
        } else {
            return null;
        }
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
