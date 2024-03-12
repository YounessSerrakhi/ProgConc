package ex3;

import java.awt.*;
public class fenetreRes extends Frame {
	Tableau tab;
	int taille;
public fenetreRes(int taille,Tableau tab){
		this.tab=tab;
		this.taille =taille;
		Panel 	conteneurRes=new Panel();
   	add(conteneurRes);
   	Label TabRes []= new Label [taille];
   	conteneurRes.setLayout(new FlowLayout());
   	for (int i=0;i<taille;i++){
   		TabRes[i]=new Label (String.valueOf(tab.getValeur(i)));
   		conteneurRes.add(TabRes[i]);
   	   	}
   	pack();
   	setVisible(true);
   	}
   	}