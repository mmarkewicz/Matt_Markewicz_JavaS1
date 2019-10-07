package com.company;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PhysicsTest {

    Physics physics;

    @Before
    public void setUp() {
        physics = new Physics();
    }

    @Test
    public void shouldCalculateForceReturnProduct() {
        assertEquals(100, physics.calculateForce(10, 10), 0.1);
        assertEquals(500.00d, physics.calculateForce(50.0d, 10.0d), 0.1);
    }

    @Test
    public void shouldCalculateVelocityReturnDivision() {
        assertEquals(100.00d, physics.calculateVelocity(500.00d, 600.00d, 5.00d, 6.00d), 0.1);
    }

}
