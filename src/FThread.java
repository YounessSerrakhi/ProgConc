public class FThread extends Thread {
    private final int n;
    private long result;

    public FThread(int n) {
        this.n = n;
        this.result = -1;
        start();
    }

    public long getResult() {
        return result;
    }

    private long calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }

    @Override
    public void run() {
        result = calculateFactorial(n - 1);
    }

    public static void main(String[] args) {
        int numberToCalculateFactorial = 2;
        FThread fThread = new FThread(numberToCalculateFactorial);

        try {
            fThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long result = fThread.getResult();
        System.out.println("Factorial of " + (numberToCalculateFactorial - 1) + ": " + result);
    }
}
