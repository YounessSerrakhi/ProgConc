public class RechercheTableau extends Thread {
    private int lost;
    private int[] tab;
    private int deb;
    private int pos = -1;

    public RechercheTableau(int nbr, int[] tab, int deb) {
        this.lost = nbr;
        this.tab = tab;
        this.deb = deb;
    }

    public int getPos() {
        return pos;
    }

    @Override
    public void run() {
        if (deb < tab.length) {
            if (tab[deb] == lost) {
                pos = deb;
            } else {
                try {
                    RechercheTableau child = new RechercheTableau(lost, tab, deb + 1);
                    child.start();
                    child.join();
                    pos = child.getPos();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] tableau = {3, 14, 5, 76, 0, 2};
        int recherche = 76;

        RechercheTableau test = new RechercheTableau(recherche, tableau, 0);
        try {
            test.start();
            test.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Pos " + test.getPos());
    }
}
