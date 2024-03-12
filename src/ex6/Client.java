package ex6;

public class Client extends Thread {
    private String nom;
    private int idService;
    public static GrandeEspace grandeEspace = new GrandeEspace(2,5);

    public Client(String nom , int idService) {
        this.nom = nom;
        this.idService=idService;
    }

    public synchronized Guichet  getBestGuichet() {
        Guichet[] guichets = grandeEspace.getGuichets();

        if (guichets.length == 0) {
            return null;
        }

        Guichet guichetMin = guichets[0];
        int dureeMin = guichetMin.getTempAtt();

        for (int i = 1; i < guichets.length; i++) {
            int dureeFileActuelle = guichets[i].getTempAtt();
            if (dureeFileActuelle < dureeMin) {
                guichetMin = guichets[i];
                dureeMin = dureeFileActuelle;
            }
        }
        guichetMin.addService(grandeEspace.getService(idService));
        System.out.println("le client "+nom+" entre a la file d'attente du guichet n"+guichetMin.getId()+" avec un temps dattemps "+(guichetMin.getTempAtt()-grandeEspace.getService(idService).getDuree())+"pour un service qui deroule "+grandeEspace.getService(idService).getDuree());
        return guichetMin;

    }

    @Override
    public void run() {
        Guichet choice = this.getBestGuichet();
            try {
                Thread.sleep(choice.getTempAtt());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Service s= choice.finService();
            System.out.println("le client "+nom+" a fini son service dans le guichet n"+choice.getId());


    }
}
