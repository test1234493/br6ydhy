package dtos;

import exceptions.WalkingException;

public class Animal {

    public void walk() throws WalkingException {
        System.out.println("Walking");
    }

    public void eat() {
        System.out.println("Eating");
    }
}
