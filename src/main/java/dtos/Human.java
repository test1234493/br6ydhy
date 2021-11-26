package dtos;

import exceptions.AllTeethsRemovedException;
import exceptions.EatingException;
import exceptions.WalkingException;

public class Human extends Mammal{
    private boolean afterDentist;
    private boolean allTeethRemoved;
    private boolean covidPositive;

    public boolean isAfterDentist() {
        return afterDentist;
    }

    public void setAfterDentist(boolean afterDentist) {
        this.afterDentist = afterDentist;
    }

    public boolean isAllTeethRemoved() {
        return allTeethRemoved;
    }

    public void setAllTeethRemoved(boolean allTeethRemoved) {
        this.allTeethRemoved = allTeethRemoved;
    }

    public boolean isCovidPositive() {
        return covidPositive;
    }

    public void setCovidPositive(boolean covidPositive) {
        this.covidPositive = covidPositive;
    }

    public Human() {
    }

    @Override
    public void eat() {
        if (allTeethRemoved){
            throw new AllTeethsRemovedException("You never eat again!");
        }
        if (afterDentist) {
            throw new EatingException("Don't eat!");
        }
        super.eat();
    }

    @Override
    public void walk() throws WalkingException {
        if (covidPositive) {
            throw new WalkingException("Walking exception");
        }
        super.walk();
    }
}
