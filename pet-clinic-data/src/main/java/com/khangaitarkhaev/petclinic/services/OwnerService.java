package com.khangaitarkhaev.petclinic.services;

import com.khangaitarkhaev.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName();

    Owner findById(int id);

    void save(Owner owner);

    Set<Owner> findAll();
}
