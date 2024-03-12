package ex1;

import java.util.Random;

class Compteur implements Runnable {
    private String name;
    private int count;
    private int n;
    private static int ordre =1;


    public Compteur(String name,int n) {
        this.name = name;
        this.n=n;
        this.count = 0;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (count < n) {
            try {
                Thread.sleep(random.nextInt(5000));
                System.out.println(name + " Compteur: " + count++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Le Thread " + name + " a fini de compter jusqu'à "+n + "en ordre:"+ ordre++);
    }
}


