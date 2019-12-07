package com.company.petsheltercrudservice.repository;

import com.company.petsheltercrudservice.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetShelterCrudServiceRepository extends JpaRepository<Pet, Integer> {
}
