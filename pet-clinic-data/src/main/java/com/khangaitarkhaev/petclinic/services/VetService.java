package com.khangaitarkhaev.petclinic.services;

import com.khangaitarkhaev.petclinic.model.Owner;
import com.khangaitarkhaev.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(int id);

    void save(Vet vet);

    Set<Vet> findAll();
}
