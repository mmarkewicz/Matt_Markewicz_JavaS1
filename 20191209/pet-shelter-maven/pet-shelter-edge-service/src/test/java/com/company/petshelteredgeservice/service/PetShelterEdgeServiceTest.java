package com.company.petshelteredgeservice.service;

import com.company.petshelteredgeservice.feign.PetShelterCrudFeign;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class PetShelterEdgeServiceTest {

    PetShelterEdgeService service;

    @Mock
    PetShelterCrudFeign feign;

    @Before
    public void setUp() {
        setUpMocks();
        service = new PetShelterEdgeService(feign);
    }

    private void setUpMocks() {
        // getPetById
        // getPetsByOwner
        // deletePet
    }
}
