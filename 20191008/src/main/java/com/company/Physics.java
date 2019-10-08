package com.company;

public class Physics {

    public double calculateForce(double mass, double acceleration) {
        if (acceleration == 0) {
            return 0;
        } else {
            return mass * acceleration;
        }
    }

    public double calculateVelocity(double distance1, double distance2, double time1, double time2) {
        if (time2 - time1 == 0) {
            return 0;
        } else {
            return (distance2 - distance1) / (time2 - time1);
        }
    }

    public double calculateMass(double weight, double gravity) {
        if (gravity == 0) {
            return 0;
        } else {
            return weight / gravity;
        }
    }

    public double calculateAcceleration(double velocity1, double velocity2, double time1, double time2) {
        if (time2 - time1 == 0) {
            return 0;
        } else {
            return (velocity2 - velocity1) / (time2 - time1);
        }
    }

    public double calculateDistance(double velocity, double time) {
        return velocity * time;
    }
}
