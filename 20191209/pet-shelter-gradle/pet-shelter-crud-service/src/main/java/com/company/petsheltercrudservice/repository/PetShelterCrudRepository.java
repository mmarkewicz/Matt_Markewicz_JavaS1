package com.company.petsheltercrudservice.repository;

import com.company.petsheltercrudservice.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetShelterCrudRepository extends JpaRepository<Pet, Integer> {
}
