package ex2;


public class Test {
    public static void main(String[] args) {
        RP rp = new RP();
        Producteur producteur=new Producteur(rp);
        Consommateur consommateur=new Consommateur(rp);

        producteur.start();
        consommateur.start();
    }
}
