package com.khangaitarkhaev.petclinic.services.map;

import com.khangaitarkhaev.petclinic.model.Vet;
import com.khangaitarkhaev.petclinic.services.CrudService;
import com.khangaitarkhaev.petclinic.services.VetService;

import java.util.Set;

public class VetServiceMap extends AbstractServiceMap<Vet, Long> implements CrudService<Vet, Long> {

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId() ,object);
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
