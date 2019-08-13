package com.ewelina.petclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "types")
public class PetType extends BaseEntity{

    private String name;

    @Override
    public String toString() {
        return name;
    }
}
