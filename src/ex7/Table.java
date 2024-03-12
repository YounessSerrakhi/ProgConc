package ex7;

public class Table {
    private int numberOfPhilosophers;

    public Table(int numberOfPhilosophers) {
        this.numberOfPhilosophers = numberOfPhilosophers;
    }

    public void createTable() {
        Baguette[] baguettes = new Baguette[numberOfPhilosophers];
        Philosophe[] philosophers = new Philosophe[numberOfPhilosophers];

        // Create baguettes
        for (int i = 0; i < numberOfPhilosophers; i++) {
            baguettes[i] = new Baguette(i + 1);
        }

        // Create philosophers with their baquettes
        for (int i = 0; i < numberOfPhilosophers; i++) {
            Baguette bDroit = baguettes[i];
            Baguette bGauche;
            if(i==0) {
                bGauche = baguettes[numberOfPhilosophers - 1];
            } else {
                bGauche = baguettes[i - 1];
            }

            philosophers[i] = new Philosophe("p" + (i + 1), bDroit, bGauche);
        }

        // Start philosophers
        for (Philosophe philosopher : philosophers) {
            philosopher.start();
        }
    }
}
