import dtos.Bird;
import dtos.Human;
import exceptions.AllTeethsRemovedException;
import exceptions.EatingException;

import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class EatingTest {

    @Test
    public void humanIsAbleToEatTest() {
        Human human = new Human();
        human.eat();
    }

    @Test
    public void humanIsAfterDentistAndCantEat() {
        Human human = new Human();
        human.setAfterDentist(true);
        try {
            human.eat();
            fail("Human shouldn't eat after dentist");
        } catch (EatingException e) {
            System.out.println("It's fine that human don't eat after dentist");
        }
    }

    @Test
    public void humanWithNoTeethAndCantEat() {
        Human human = new Human();
        human.setAllTeethRemoved(true);
        try {
            human.eat();
            fail("Human shouldn't eat after dentist");
        } catch (AllTeethsRemovedException e) {
            System.out.println("All teeth removed so human is not eating it's OK");
        } catch (EatingException e) {
            fail("Because all teeth removed exception was raised this exception shouldn't be executed");
        }
    }

    @Test
    public void birdWhoAlreadyAteCantEat() {
        Bird bird = new Bird();
        bird.setAlreadyAte(true);

        try {
            bird.eat();
            fail("Bird already eaten. Failed.");
        } catch (EatingException e) {
            System.out.println("Bird is not eating cause it already did. Passed.");
        }
    }
}
