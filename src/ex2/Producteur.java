package ex2;
import java.util.Random;

public class Producteur extends Thread{
    private RP rp;
    public Producteur(RP rp){
        this.rp=rp;

    }
    @Override
    public void run(){
        while(true){
            Random random = new Random();
            int n = random.nextInt(10);
            rp.produit(n);
        }

    }
}
