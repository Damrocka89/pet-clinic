package com.ewelina.petclinic.services.map;

import com.ewelina.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        ownerMapService=new OwnerMapService(new PetTypeMapService(), new PetMapService());

        ownerMapService.save(Owner.builder().firstName("Ola").lastName("Nowak").build());

    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1,ownerSet.size());
    }

    @Test
    void deleteById() {
        ownerMapService.save(Owner.builder().firstName("Ala").lastName("Nowak").build());
        ownerMapService.deleteById(2L);
        assertEquals(1, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.save(Owner.builder().firstName("Ala").lastName("Nowak").build());
        ownerMapService.delete(ownerMapService.findById(2L));
        assertEquals(1, ownerMapService.findAll().size());
    }

    @Test
    void save() {
        Owner owner2=Owner.builder().firstName("Franek").build();
        Owner savedOwner=ownerMapService.save(owner2);
        assertEquals(2L, savedOwner.getId());
    }

    @Test
    void findById() {
        Owner owner=ownerMapService.findById(1L);
        assertEquals(1,owner.getId());
    }

    @Test
    void findByLastName() {
        Owner nowak = ownerMapService.findByLastName("Nowak");
        assertEquals(1L,nowak.getId());
    }


    @Test
    void findByLastNameNoName() {
        Owner nowak = ownerMapService.findByLastName("bbbbb");
        assertNull(nowak);
    }
}