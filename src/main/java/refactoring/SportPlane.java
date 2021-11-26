package refactoring;

public class SportPlane extends Plane {
    public void chaseOtherPlane(Plane plane) {
        System.out.println("Chasing plane " + plane.toString());
    }
}
