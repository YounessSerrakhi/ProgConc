package ex5;
import java.util.Random;

public class Traitement extends Thread {
    private Compte compte;
    private String operation;
    private double montant;
    private Compte destinataire;

    public Traitement(Compte compte, String operation, double montant, Compte destinataire) {
        this.compte = compte;
        this.operation = operation;
        this.montant = montant;
        this.destinataire = destinataire;
    }

    public Traitement(Compte compte, String operation, double montant) {
        this.compte = compte;
        this.operation = operation;
        this.montant = montant;
    }

    @Override
    public void run() {
        Random random = new Random();
        int dureeTraitement = random.nextInt(5000) + 1000;

        System.out.println("Traitement en cours pour le compte " + compte.getNumeroCompte() +
                ". Durée estimée : " + dureeTraitement + " millisecondes.");

        try {
            Thread.sleep(dureeTraitement);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        switch (operation){
            case("Retrait"):
                compte.retirer(montant);
                break;
            case("Virement")  :
                compte.virerVers(destinataire,montant);
                break;
            case("Dépôt"):
                compte.deposer(montant);
                break;
        }

        System.out.println("Traitement terminé pour le compte " + compte.getNumeroCompte() +
                ". Solde final : " + compte.getSolde());
    }
}
