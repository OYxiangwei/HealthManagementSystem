package com.oy.entity;

import java.sql.Date;

public class EnergyDate {
    private int energy;
    private Date collectDate;

    public EnergyDate(int energy, Date collectDate) {
        this.energy = energy;
        this.collectDate = collectDate;
    }

    public EnergyDate() {
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public Date getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(Date collectDate) {
        this.collectDate = collectDate;
    }

    @Override
    public String toString() {
        return "EnergyDate{" +
                "energy=" + energy +
                ", collectDate=" + collectDate +
                '}';
    }
}
