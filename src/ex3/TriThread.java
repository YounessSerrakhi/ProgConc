package ex3;

public class TriThread extends Thread{
    Tableau tab;
    int taille;
    TriFusion tf;
    public TriThread(String Nom, int taille, Tableau tab){
    	super(Nom);
    	this.taille=taille;
    	this.tab=tab;
    }
    
   	public void run(){ 
	tf = new TriFusion("Thread-1",0,taille-1,tab);
	tf.start();
	System.out.println(getName()+" Attend ");
	try {
				tf.join();
				new fenetreRes(taille,tab);
		} catch(Exception e) {}
}
}