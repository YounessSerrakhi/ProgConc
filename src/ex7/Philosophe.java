package ex7;

import java.util.Random;

public class Philosophe extends Thread {
    private String nom;
    private Baguette bDroit;
    private Baguette bGauche;

    public Philosophe(String nom,Baguette bDroit,Baguette bGauche) {
        this.nom = nom;
        this.bGauche=bGauche;
        this.bDroit=bDroit;
    }
    public void dinner(){
        Random r = new Random();
        System.out.println("le philosophe "+nom+"commence a manger");
        try {
            Thread.sleep(r.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("le philosophe "+nom+"termine son repas");

    }

    @Override
    public void run() {
        while(bDroit.prendre()){
            System.out.println("le philosophe "+this.nom+ " prend la baguete droit n"+bDroit.getId());
            if(bGauche.prendre()){
                System.out.println("le philosophe "+this.nom+ " prend la baguete gauche n"+bGauche.getId());
                dinner();
                bDroit.pose();
                bGauche.pose();
                System.out.println("le philosophe "+this.nom+ " pose les 2 baguette");
                break;//pour que les philosopje continue a manger il suffit de commenter cette ligne
            }else{
                bDroit.pose();
                System.out.println("le philosophe "+this.nom+ " pose les1er baguette n"+bDroit.getId());
                Random r = new Random();
                try {
                    Thread.sleep(r.nextInt(4000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


            }
}
