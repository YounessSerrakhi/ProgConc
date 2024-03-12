package ex6;

public class Test {
    public static void main(String[] args) {
        GrandeEspace grandeEspace = new GrandeEspace(3, 3);

        for (int i = 1; i <= 9; i++) {
            Client client = new Client("Client" + i, i % 3); // Use i % 3 for service ID
            client.start();

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            for (int i = 1; i <= 9; i++) {
                Client client = new Client("Client" + i, i % 3);
                client.join();
            }

            System.out.println("Tous les clients sont servis");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
