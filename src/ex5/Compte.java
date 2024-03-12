package ex5;
public class Compte {
    private String numeroCompte;
    private double solde;
    private String cin;

    public Compte(String numeroCompte, double solde, String cin) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.cin = cin;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public synchronized double getSolde() {
        return solde;
    }

    public synchronized void retirer(double montant) {
        if (montant > 0 && montant <= solde) {
            //pour voir l'effet de synchronized
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            solde -= montant;
            System.out.println("Retrait de " + montant + " effectué. Nouveau solde : " + solde);
        } else {
            System.out.println("Impossible de retirer le montant spécifié.");
        }
    }

    public synchronized void virerVers(Compte destinataire, double montant) {
        if (montant > 0 && montant <= solde) {
            solde -= montant;
            destinataire.deposer(montant);
            System.out.println("Virement de " + montant + " effectué vers le compte " + destinataire.getNumeroCompte());
            System.out.println("Nouveau solde du compte source : " + solde);
        } else {
            System.out.println("Impossible d'effectuer le virement avec le montant spécifié.");
        }
    }

    public synchronized void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println("Dépôt de " + montant + " effectué. Nouveau solde : " + solde);
        } else {
            System.out.println("Impossible de déposer le montant spécifié.");
        }
    }
}
