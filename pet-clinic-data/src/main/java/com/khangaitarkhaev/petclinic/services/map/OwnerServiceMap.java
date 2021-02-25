package com.khangaitarkhaev.petclinic.services.map;

import com.khangaitarkhaev.petclinic.model.Owner;
import com.khangaitarkhaev.petclinic.model.Vet;
import com.khangaitarkhaev.petclinic.services.CrudService;
import com.khangaitarkhaev.petclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractServiceMap<Owner, Long> implements OwnerService {

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId() ,object);
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
