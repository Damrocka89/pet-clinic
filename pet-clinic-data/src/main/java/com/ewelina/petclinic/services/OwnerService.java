package com.ewelina.petclinic.services;

import com.ewelina.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
