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
        assertEquals(0, physics.calculateForce(50.00d, 0), 0.0); // if denominator = 0, return 0
    }

    @Test
    public void shouldCalculateVelocityReturnDivision() {
        assertEquals(100.00d, physics.calculateVelocity(500.00d, 600.00d, 5.00d, 6.00d), 0.1);
        assertEquals(0d, physics.calculateVelocity(500.00d, 600.00d, 5.00d, 5.00d), 0.1); // if dividing by 0, return 0
        assertEquals(-1100.00d, physics.calculateVelocity(500.00d, -600.00d, 5.00d, 6.00d), 0.1);
    }

    @Test
    public void shouldCalculateMassReturnWeightDividedByGravity() {
        assertEquals(100, physics.calculateMass(100, 1), 0.1);
        assertEquals(0, physics.calculateMass(100, 0), 0.1); // if denominator = 0; return 0
        assertEquals(0, physics.calculateMass(0, 100), 0.1);
    }

    @Test
    public void shouldCalculateAccelerationReturnVelocityDeltaDividedByTimeDelta() {
        assertEquals(100, physics.calculateAcceleration(300, 400, 9, 10), 0.1);
        assertEquals(0, physics.calculateAcceleration(500, 600, 10, 10), 0.1);
        assertEquals(0, physics.calculateAcceleration(600, 600, 10, 9), 0.1);
    }

    @Test
    public void shouldCalculateDistanceReturnVelocityTimesTime() {
        assertEquals(100, physics.calculateDistance(10, 10), 0.0001);
        assertEquals(0, physics.calculateDistance(0, 100), 0.0001);
        assertEquals(0, physics.calculateDistance(100, 0), 0.0001);
    }


}
