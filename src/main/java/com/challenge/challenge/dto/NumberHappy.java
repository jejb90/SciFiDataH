package com.challenge.challenge.dto;

public class NumberHappy {

    private int number;
    private boolean isHappy;

    public NumberHappy(int number, boolean isHappy) {
        this.number = number;
        this.isHappy = isHappy;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isHappy() {
        return isHappy;
    }

    public void setHappy(boolean happy) {
        isHappy = happy;
    }
}
