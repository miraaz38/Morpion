/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import morpion.Bouton;
import morpion.*;

/**
 *
 * @author damien
 */
public class Controle implements Observer{
    
    private Joueur j1 = new Joueur("toto", Symbole.CROIX);
    private Joueur j2 = new Joueur("titi", Symbole.ROND);
//    private Morpion morpion = new Morpion(j1, j2, 3);
    
    private Joueur currentJ;
    private Plateau plateau;
    private JFrame vueActive;
    
    
    public Controle(Joueur j1, Joueur j2, int n){
        setJ1(j1);
        setJ2(j2);
        this.plateau = new Plateau(n);
    }
    
    public void cocherCase(Bouton b){
        Symbole s = getCurrentJ().getSymbole();
        int x = b.getX();
        int y = b.getY();
        plateau.addCaseCoche();
        if (s == Symbole.CROIX){
            plateau.ajoutMatriceCroix(x, y);
        }else{
            plateau.ajoutMatriceRond(x, y);
        }
        
    }
    
    public void joueurSuivant(){
        if (getCurrentJ() == getJ1()) {
            setCurrentJ(getJ2());
        } else{
            setCurrentJ(getJ1());
        }
    }
    
//    public String resultat(int x, int y) // n coté du morpion 
//    {
//        
//        Symbole s = getCurrentJ().getSymbole();
//        if (s == Symbole.CROIX && verifCroix(x,y) || s== Symbole.ROND && verifRond(x,y) ){
//            return "Partie Gagne";
//        }else if(plateau.getNbCasesCochees()== plateau.getNbCase()){
//            return "Match nul";
//        }else{
//            return "Continue";
//        }
//    }
        
   


    /**
     * @return the currentJ
     */
    public Joueur getCurrentJ() {
        return currentJ;
    }

    /**
     * @param currentJ the currentJ to set
     */
    public void setCurrentJ(Joueur currentJ) {
        
    }

    /**
     * @return the j1
     */
    public Joueur getJ1() {
        return j1;
    }

    /**
     * @param j1 the j1 to set
     */
    public void setJ1(Joueur j1) {
        this.j1 = j1;
    }

    /**
     * @return the j2
     */
    public Joueur getJ2() {
        return j2;
    }

    /**
     * @param j2 the j2 to set
     */
    public void setJ2(Joueur j2) {
        this.j2 = j2;
    }

    /**
     * @return the plateau
     */
    public Plateau getPlateau() {
        return this.plateau;
    }


    
    @Override
    public void update(Observable VueMorpion, Object b) {
        if (b instanceof Bouton) {
            Bouton bouton = (Bouton) b;
            cocherCase(bouton);
//            if (resultat(bouton.getX()-1, bouton.getY()-1)== "Partie Gagne"){
//                
//            }
        }
        
        joueurSuivant(); 
        
        }
    
 
    
}

//Fin de code commentaires après



/**        int o = 0;
*        int x = 0;
*        int resX = 0;
*       int resO = 0;
*       //on parcourt ligne première case si x : x++ si o, o++, deuxième case
*       // si x et x avant x++ si o et o avant o++ si x et o avant o=0 et x++ etc
*       //si x ==3 ou o == 3 victoire
*       // sinon on parcourt en diago idem
*       // idem pour les colonnes
*       ArrayList<Case> cases = getPlateau().getCases();
*       
*       //lignes
*       for (int i = 0; i < n; i++) {
*           x = 0;
*           o = 0;
*           for (int j = 0; j < n; j++) {
*               if (cases.get(i-1 + n + j - 1).getSymbole() == Symbole.CROIX && o > 0) {
*                   x++;
*                   o = 0;
*                   if (x == 3) {
*                       resX++;
*                       x = 0;
*                   }
*                   
*                   if (resX == n - 2) {
*                       return "X";
*                   }
*                   
*               }else if (cases.get(i-1 + n + j - 1).getSymbole() == Symbole.ROND && x >= 0) {
*                   o++;
*                   x = 0;
*                   if (o == 3) {
*                       resO++;
*                       o = 0;
*                   }
*                   
*                   if (resO == n - 2) {
*                       return "O";
*                   }
*                   
*               }else{
*                   x = 0;
*                  o = 0;
*               }
*           }
*   }
*       
*       //colonnes
*       for (int j = 0; j < n; j++) {
*           x = 0;
*           o = 0;
*           for (int i = 0; i < n; i++) {
*               if (cases.get(i-1 + n + j - 1).getSymbole() == Symbole.CROIX && o >= 0) {
*                   x++;
*                   o = 0;
*                   
*                   if (x == 3) {
*                       resX++;
*                       x = 0;
*                   }
*                   
*                   if (resX == n - 2) {
*                       return "X";
*                   }
*                   
*               }else if (cases.get(i-1 + n + j - 1).getSymbole() == Symbole.ROND && x >= 0) {
*                   o++;
*                   x = 0;
*                   
*                   if (o == 3) {
*                       resO++;
*                       o = 0;
*                   }
*                   
*                   if (resO == n - 2) {
*                       return "O";
*                   }
*                   
*               }else{
*                   x = 0;
*                   o = 0;
*               }
*           }
*       }
*       
*       //diagonales descendantes de gauche à droite
*       x = 0;
*       o = 0;
*       
*       if (n == 3) {
*           if (cases.get(1).getSymbole() == Symbole.CROIX 
*                   && cases.get(5).getSymbole() == Symbole.CROIX 
*                   && cases.get(9).getSymbole() == Symbole.CROIX) {
*               resX++;
*               
*               if (resX == n - 2) {
*                       return "X";
*                   }
*               
*           }else if (cases.get(1).getSymbole() == Symbole.ROND 
*                   && cases.get(5).getSymbole() == Symbole.ROND 
*                   && cases.get(9).getSymbole() == Symbole.ROND) {
*               resO++;
*               
*               if (resO == n - 2) {
*                       return "O";
*                   }
*           }
*       }else if (n == 4) {
*           if (cases.get(1).getSymbole() == Symbole.CROIX 
*                   && cases.get(6).getSymbole() == Symbole.CROIX 
*                   && cases.get(11).getSymbole() == Symbole.CROIX) {
*               if (cases.get(16).getSymbole() == Symbole.CROIX) {
*                   resX+=2;
*               }else{
*                   resX++;
*               }
*               
*               if (resX == n - 2) {
*                       return "X";
*                   }
*               
*           }else if (cases.get(1).getSymbole() == Symbole.ROND 
*                   && cases.get(6).getSymbole() == Symbole.ROND                    && cases.get(11).getSymbole() == Symbole.ROND) {
* 
*
*               if (cases.get(16).getSymbole() == Symbole.ROND) {
*
*   resO+=2;
*               }else{
*                   resO++;
*               }
*               
*               if (resO == n - 2) {
*                       return "O";
*                   }
*               
*           }else if (cases.get(2).getSymbole() == Symbole.CROIX 
*                   && cases.get(7).getSymbole() == Symbole.CROIX 
*                   && cases.get(12).getSymbole() == Symbole.CROIX) {
*               resX++;
*               
*               if (resX == n - 2) {
*                       return "X";
*                   }
*               
*           }else if (cases.get(2).getSymbole() == Symbole.ROND 
*                   && cases.get(7).getSymbole() == Symbole.ROND 
*                   && cases.get(12).getSymbole() == Symbole.ROND){
*               resO++;
*               
*               if (resO == n - 2) {
*                       return "X";
*                   }
*           }else if (cases.get(5).getSymbole() == Symbole.CROIX 
*                   && cases.get(10).getSymbole() == Symbole.CROIX 
*                   && cases.get(15).getSymbole() == Symbole.CROIX) {
*               resX++;
*
*
*   
*   
*               if (resX == n - 2) {
*                       return "X";
*                   }
*               
*           }else if (cases.get(5).getSymbole() == Symbole.ROND 
*                   && cases.get(10).getSymbole() == Symbole.ROND 
*                   && cases.get(15).getSymbole() == Symbole.ROND){
*               resO++;
*               
*               if (resO == n - 2) {
*                       return "X";
*                   }
*           }
*       }else if (n == 5) {
*           
*       }
*       
*       //diagonales montantes de gauche à droite
*       
*      return null; 
    }*/