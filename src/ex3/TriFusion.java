package ex3;

public class TriFusion extends Thread{
	int debut,fin;
	Tableau tableau;
	public TriFusion(String Nom, int d, int f, Tableau tab ){
		super(Nom);
		debut=d;
		fin =f;
		System.out.println(Nom+" est lance ");
		tableau=tab;

	}
	public void run(){
		TriFusion fils1,fils2;
		int milieu;
		if (fin-debut < 2){
		tableau.echange(debut,fin);
		}
		else{
	
		milieu = debut + (fin - debut)/2 ;
		
		fils1=new TriFusion(getName()+"-1",debut,milieu,tableau);
		fils2=new TriFusion(getName()+"-2",milieu+1,fin,tableau);
		fils1.start();
		fils2.start();
		//tableau.fusion(debut,fin);
		try {
				System.out.println(getName()+" Attend ");
				fils1.join();
				fils2.join();
				System.out.println(getName()+" Reprend ");
				tableau.fusion(debut,fin);
			//	tableau.afficheTab();
			} catch(Exception e) {}
		
			}


	}
}