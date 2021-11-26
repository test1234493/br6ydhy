package dtos;

import exceptions.EatingException;
import exceptions.FlyingException;
import lombok.SneakyThrows;
import refactoring.FlyingThings;

public class Bird extends Animal implements FlyingThings {
    private boolean brokenWing;
    private boolean alreadyAte;

    public boolean isBrokenWing() {
        return brokenWing;
    }

    public void setBrokenWing(boolean brokenWing) {
        this.brokenWing = brokenWing;
    }

    public boolean isAlreadyAte() {
        return alreadyAte;
    }

    public void setAlreadyAte(boolean alreadyAte) {
        this.alreadyAte = alreadyAte;
    }

    @SneakyThrows
    public void fly() {
        if (brokenWing) {
            throw new FlyingException("Birds with broken wing don't fly");
        }
        System.out.println("Flying high");
    }

    @Override
    public void eat() {
        if (alreadyAte) {
            throw new EatingException("Bird has already eaten");
        }
        super.eat();
    }
}
