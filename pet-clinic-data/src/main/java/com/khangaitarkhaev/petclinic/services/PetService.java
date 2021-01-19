package com.khangaitarkhaev.petclinic.services;

import com.khangaitarkhaev.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(int id);

    void save(Pet pet);

    Set<Pet> findAll();
}
