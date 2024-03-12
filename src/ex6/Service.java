package ex6;

public class Service {
    private int id;
    private int duree;//(ms)

    public int getId() {
        return id;
    }

    public Service(int id, int duree) {
        this.id = id;
        this.duree = duree;
    }

    public int getDuree() {
        return duree;
    }
}
