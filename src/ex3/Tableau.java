package ex3;

public class Tableau{
	
	// les attribut
	 int taille;
	int[] tableau;
	
	//le constructeur
	public Tableau(int taille ){
	this.taille=taille;
	tableau = new int[taille];
	}
	public void setValeur(int i,int v){
		tableau[i]=v;
	}
	public int getValeur(int i){
		return tableau[i];
	}
	public int getTaille(){
		return taille;
	}
	public void afficheTab(){
		for(int i=0;i<taille;i++){
		System.out.println(tableau[i]);
			}
	}
	public synchronized void echange(int i,int j){
		int tmp;
		if  (tableau[i] > tableau[j]){
			 tmp= tableau [i];
			 tableau [i]=tableau [j];
			 tableau [j] = tmp;
			 
			 }
		}
	public synchronized void fusion (int debut,int fin){
		int milieu =debut + (fin - debut)/2 ;
		int i=debut;
		int j=milieu+1;
		int k=milieu;
		int TmpTab[]=new int [taille];
		for (i = milieu;i>=debut;i--) TmpTab[i] = tableau[i];//remplir tmp par les meme val de tableau origine dans le premier interval
        for (j= milieu+1;j<=fin;j++) TmpTab[fin+milieu+1-j]= tableau[j];//remplir tmp par les meme val de tableau origine dans le 2eme interval
        i = debut; j = fin;
        for (k = debut;k<=fin;k++){
            if (TmpTab[i] < TmpTab[j]){
          
                 tableau[k] = TmpTab[i]; i = i + 1; 
                 }
            else
                { tableau[k] = TmpTab[j]; j= j - 1 ;
				}
		}
		}
}