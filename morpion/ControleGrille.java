/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morpion;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author damien
 */
public class ControleGrille implements Observer{
    
    private Joueur j1 = new Joueur("toto", Symbole.CROIX);
    private Joueur j2 = new Joueur("titi", Symbole.ROND);
    private Joueur currentJ;

    @Override
    public void update(Observable VueMorpion, Object b) {
            cocherCase();
            joueurSuivant();                    
        }
    
    public void cocherCase(Bouton b){
        Symbole s = currentJ.getSymbole();
        int x = b.getX();
        int y = b.getY();
    }
    
    public void joueurSuivant(){
        if (currentJ == j1) {
            currentJ = j2;
        } else{
            currentJ = j1;
        }
    }
    
    public void resultat(){
        int o = 0;
        int x = 0;
        //on parcourt ligne première case si x : x++ si o, o++, deuxième case
        // si x et x avant x++ si o et o avant o++ si x et o avant o=0 et x++ etc
        //si x ==3 ou o == 3 victoire
        // sinon on parcourt en diago idem
        // idem pour les colonnes
        
    }
    
}
