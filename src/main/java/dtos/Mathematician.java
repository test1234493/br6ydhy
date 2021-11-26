package dtos;

public class Mathematician extends Human{

    private static Mathematician mathematician;

    public static Mathematician getInstance() {
        if (mathematician == null) {
            mathematician = new Mathematician();
        }
        return mathematician;
    }

    private Mathematician() {

    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }


}
