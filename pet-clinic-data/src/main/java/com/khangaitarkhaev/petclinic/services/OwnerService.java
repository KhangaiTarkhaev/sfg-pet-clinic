package com.khangaitarkhaev.petclinic.services;

import com.khangaitarkhaev.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName();

}
