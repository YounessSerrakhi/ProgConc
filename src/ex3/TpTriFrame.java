package ex3;

import java.awt.*;
import java.awt.event.*;

/**
 * Sample application using Frame.
 *
 * @author 
 * @version 1.00 06/02/19
 */
public class TpTriFrame extends Frame {
    //Les Attributs
    TextField Taille;
    Label LTaille;
    Button Ok,CalValeur;
    int taille;
    Tableau tab;
    Panel contenurTableau, ConteneurTaille;
    TextField TabValeur[];
    TriThread thread;
    
    
    /**
     * The constructor.
     */  
     public TpTriFrame() {
                
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu();
        MenuItem menuFileExit = new MenuItem();
        
        menuFile.setLabel("File");
        menuFileExit.setLabel("Exit");
        
        // Add action listener.for the menu button
        menuFileExit.addActionListener
        (
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    TpTriFrame.this.windowClosed();
                }
            }
        ); 
        menuFile.add(menuFileExit);
        menuBar.add(menuFile);
        
        setTitle("TpTri");
        setMenuBar(menuBar);
        setSize(new Dimension(400, 400));
        
        // Add window listener.
        this.addWindowListener
        (
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    TpTriFrame.this.windowClosed();
                }
            }
        );  
    setLayout(new BorderLayout());
    ConteneurTaille=new Panel();
    ConteneurTaille.setLayout(new FlowLayout());
    Taille=new TextField(5);
    LTaille=new Label("Taille");
    Ok = new Button("OK");
  
    add("North",ConteneurTaille);
    ConteneurTaille.add(LTaille);
    ConteneurTaille.add(Taille);
    ConteneurTaille.add(Ok);
    
      Ok.addActionListener
    (
    	new ActionListener(){
    		public synchronized void actionPerformed(ActionEvent e) {
    	
   		try{
			taille=Integer.parseInt(Taille.getText());
		}
		catch(NumberFormatException ee){
			taille=0;
		}	
    		if(taille>0){
	
			affichTableau();
		}
		else {
			System.out.println("Taille Incorrecte!!!!");
			System.exit(0);
		}	
    		
    		
    		
    		
    		}
    }		
    );
    }
 
    
    /**
     * Shutdown procedure when run as an application.
     */
    protected void windowClosed() {
    	
    	// TODO: Check if it is safe to close the application
    	
        // Exit application.
        System.exit(0);
    }
   
   void affichTableau(){
   	contenurTableau=new Panel();
   	add("Center",contenurTableau);
   	TabValeur = new TextField [taille];
   	CalValeur =new Button("RempTab");
   	tab = new Tableau(taille);
   	contenurTableau.setLayout(new FlowLayout());
   	for (int i=0;i<taille;i++){
   		TabValeur[i]=new TextField (3);
   		contenurTableau.add(TabValeur[i]);
   	}
   	contenurTableau.add(CalValeur);
   	setVisible(true);
   	CalValeur.addActionListener
    (
    	new ActionListener(){
    		public synchronized void actionPerformed(ActionEvent e) {
    			 	for (int i=0;i<taille;i++){
   	
   		try{
				tab.setValeur(i,Integer.parseInt(TabValeur[i].getText()));
			
		}
		catch(NumberFormatException ee){
			tab.setValeur(i,0);
			}
   }
   	   		thread = new TriThread("PRINCIPAL",taille,tab);
   	   		thread.start();
   	   		
	   }
   }
   );


}

   void affichRes(){

   	}

}
