package ex4;
public class PuissanceThread extends Thread {
    private double base;
    private int exponent;
    private double result;

    public PuissanceThread(double base, int exponent) {
        this.base = base;
        this.exponent = exponent;
    }

    public double getResult() {
        return result;
    }

    @Override
    public void run() {
        if (exponent == 0) {
            result = 1;
            return;
        }
        if (exponent == 1) {
            result = base;
            return;
        }

        PuissanceThread subThread = new PuissanceThread(base, exponent / 2);
        subThread.start();
        try {
            subThread.join();

            result = subThread.getResult() * subThread.getResult();//A^(2n) = (A^n)^2

            if (exponent % 2 == 1) {
                result *= base; // A^(2n+1) = (A^n)^2 * A
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
