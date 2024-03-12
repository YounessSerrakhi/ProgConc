package ex2;

public class Consommateur extends Thread{

    private RP rp;
    public Consommateur(RP rp){
        this.rp=rp;

    }

    @Override
    public void run() {
        while (true) {
            int tmp = rp.Consomme();
        }
    }
}
