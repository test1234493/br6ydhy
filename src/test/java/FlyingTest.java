import dtos.Bird;
import exceptions.FlyingException;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class FlyingTest {

    @Test
    public void birdWithBrokenWingCantFly() {
        Bird bird = new Bird();
        bird.setBrokenWing(true);

        try {
            bird.fly();
            fail("It's a miracle");
        } catch (FlyingException e) {
            System.out.println("Poor bird can't fly because of broken wing");
        }
    }
}
