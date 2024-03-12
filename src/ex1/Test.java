package ex1;

public class Test {
    public static void main(String[] args) {
        Thread counter1 = new Thread(new Compteur("Process1",10));
        Thread counter2 = new Thread(new Compteur("Process2",10));


        counter1.start();
        counter2.start();

        try {
            counter1.join();
            counter2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("tous les compteur sont finis");
    }
}