package ex6;

import java.util.LinkedList;
import java.util.Queue;

public class Guichet {
    private int id;
    private Queue<Service> fileAtt = new LinkedList<>();

    public Guichet(int id) {
        this.id = id;
    }

    public synchronized int getTempAtt() {
        int time = 0;
        for (Service s : fileAtt) {
            time += s.getDuree();
        }
        return time;
    }

    public synchronized boolean addService(Service service) {
        return fileAtt.add(service);
    }
    public synchronized Service finService() {
        System.out.print('[');
        for (Service s : fileAtt) {
            System.out.print(s.getId());
            System.out.print(',');
        }
        System.out.println("] guivhe n"+id);
        return fileAtt.poll();
    }
    public int getId() {
        return id;
    }
}
