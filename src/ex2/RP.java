package ex2;
public class RP {
    private int n;
    private boolean exist;

    public synchronized void produit(int n) {
        if (exist) {
            try {
                System.out.println("Production bloquee");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Producteur produit "+n);
        this.n=n;
        exist=true;
        System.out.println("Producteur notifie le consommateur");
        notify();
    }


    public synchronized int Consomme() {
        if (!exist) {
            System.out.println("Consommateur bloquee");
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        int tmp;
        System.out.println("Consommateur veut consommer");
        tmp=n;
        exist=false;
        System.out.println("Consommateur consomme "+tmp+" et notify le producteur");
        notify();
        return tmp;

    }
}