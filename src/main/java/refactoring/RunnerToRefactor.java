package refactoring;

import dtos.Bird;
import dtos.Mathematician;

public class RunnerToRefactor {

    public static void main(String[] args) {
        FlyingThings plane = new Plane();
        System.out.println(Mathematician.getInstance().add(2, 3));
        Plane plane1 = (Plane) plane;
        int speed = plane1.getSpeed();
        int high = plane1.getHigh();
        new SportPlane().chaseOtherPlane(plane1);
        Helicopter helicopter1 = new Helicopter();
        helicopter1.startFromRoof();
        System.out.println(String.format("Plane in %s meters over ground and flies %s km/h", speed, high));
        plane1.countBeforeStart(10);
    }
}
