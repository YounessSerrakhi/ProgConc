package ex6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class GrandeEspace {
    private static Guichet[] guichets;
    private static Service[] services;

    public GrandeEspace(int nombreDeGuichets, int nombreDeServices) {
        guichets = new Guichet[nombreDeGuichets];
        services = new Service[nombreDeServices];

        // Create services
        for (int i = 0; i < nombreDeServices; i++) {
            Random r = new Random();
            services[i] = new Service(i, r.nextInt(10)+1); // Example: Service duration increases with the ID
        }

        // Create guichets
        for (int i = 0; i < nombreDeGuichets; i++) {
            guichets[i] = new Guichet(i);
        }
    }

    public  Guichet[] getGuichets() {
        return guichets;
    }

    public  Service[] getServices() {
        return services;
    }

    public Service getService(int i) {
        return services[i];
    }


}
