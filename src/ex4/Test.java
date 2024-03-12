package ex4;

public class Test {
    public static void main(String[] args) {
        double base = 2.0;
        int exponent = 5;

        PuissanceThread powerThread = new PuissanceThread(base, exponent);
        powerThread.start();

        try {
            powerThread.join();
            double result = powerThread.getResult();

            System.out.println(base + " power of " + exponent + " is: " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}