package com.team3.canvas;

public class Infections {

    private int healthy;
    private int infected;
    private int mutated;

    public Infections(int healthy, int infected, int mutated){
        this.healthy = healthy;
        this.infected = infected;
        this.mutated = mutated;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getInfected() {
        return infected;
    }

    public void setInfected(int infected) {
        this.infected = infected;
    }

    public int getMutated() {
        return mutated;
    }

    public void setMutated(int mutated) {
        this.mutated = mutated;
    }
}