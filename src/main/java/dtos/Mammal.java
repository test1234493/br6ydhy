package dtos;

import exceptions.WalkingException;

public class Mammal extends Animal {
    private boolean brokenLeg;

    public Mammal(boolean brokenLeg) {
        this.brokenLeg = brokenLeg;
    }

    public boolean isBrokenLeg() {
        return brokenLeg;
    }

    public void setBrokenLeg(boolean brokenLeg) {
        this.brokenLeg = brokenLeg;
    }

    public Mammal(){};

    @Override
    public void walk() throws WalkingException {
        if (brokenLeg) {
            throw new WalkingException("Mammal can't walk because of broken leg");
        }
        super.walk();


    }
}
