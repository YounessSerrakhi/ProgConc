package ex7;

public class Baguette {
    private boolean libre = true;
    private int id;

    public Baguette(int id) {
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public boolean prendre(){

        if(libre){
            libre=false;
            return true;
        }else return false;

    }
    public void pose(){
        libre=true;
    }


}
