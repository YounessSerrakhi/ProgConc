package ex5;
public class Test {
    public static void main(String[] args) {
        final String RETRAIT ="Retrait";
        final String VIREMENT ="Virement";
        final String DEPOT ="Dépôt";
        Compte compte1 = new Compte("1", 1000.0, "ABC123");
        Compte compte2 = new Compte("2", 2000.0, "DEF456");

        Traitement traitement1 = new Traitement(compte1,RETRAIT,900);
        Traitement traitement2 = new Traitement(compte1,VIREMENT,500,compte2);

        traitement1.start();
        traitement2.start();
    }
}
