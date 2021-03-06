package com.khangaitarkhaev.petclinic.services.map;

import com.khangaitarkhaev.petclinic.model.Specialty;
import com.khangaitarkhaev.petclinic.services.SpecialtiesService;

import java.util.Set;

public class SpecialtyServiceMap extends AbstractServiceMap<Specialty, Long> implements SpecialtiesService {


    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Specialty save(Specialty specialty) {
        return super.save(specialty);
    }

    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Specialty specialty) {
        super.delete(specialty);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
