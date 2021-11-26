package refactoring;

import dtos.Bird;
import exceptions.FlyingException;

public class Plane implements FlyingThings{
    @Override
    public void fly() {
        System.out.println("Plane flies differently than Bird. It cannot have broken wing");
    }

    public void countBeforeStart(int counter) {
        while (counter >= 0) {
            System.out.println(counter--);
        }
    }

    public int getSpeed() {
        return 1000;
    }

    public int getHigh() {
        return 800;
    }
}
