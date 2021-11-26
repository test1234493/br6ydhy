package mathematician.tests;

import dtos.Mathematician;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculationTest {

    private Mathematician mathematician;

    @BeforeClass
    public void beforeClass() {
        mathematician = Mathematician.getInstance();
    }

    @DataProvider(name = "numbersToAdd")
    public Object[][] addingDataProvider() {
        return new Object[][]{
                {1,2,3},
                {5,5,10},
                {10, 15, 25}
        };
    }

    @Test(dataProvider = "numbersToAdd")
    public void addingTest(int a, int b, int expectedResult) {
        int result = mathematician.add(a, b);
        assertEquals(result, expectedResult);
    }

    @DataProvider(name = "numbersToSubtract")
    public Object[][] subtractDataProvider() {
        return new Object[][]{
                {3,2,1},
                {5,5,0},
                {35, 15, 20}
        };
    }

    @Test(dataProvider = "numbersToSubtract")
    public void subtractingTest(int a, int b, int expectedResult) {
        int result = mathematician.subtract(a, b);
        assertEquals(result, expectedResult);
    }

    @DataProvider(name = "numbersToMultiply")
    public Object[][] multiplyDataProvider() {
        return new Object[][]{
                {3,2,6},
                {5,5,25},
                {10, 15, 150}
        };
    }

    @Test(dataProvider = "numbersToMultiply")
    public void multiplyingTest(int a, int b, int expectedResult) {
        int result = mathematician.multiply(a, b);
        assertEquals(result, expectedResult);
    }

    @DataProvider(name = "numbersToDivide")
    public Object[][] divideDataProvider() {
        return new Object[][]{
                {4,2,2},
                {10,5,2},
                {45, 15, 3}
        };
    }

    @Test(dataProvider = "numbersToDivide")
    public void dividingTest(int a, int b, int expectedResult) {
        int result = mathematician.divide(a, b);
        assertEquals(result, expectedResult);
    }
}
