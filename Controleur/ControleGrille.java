/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.util.Observable;
import java.util.Observer;
import morpion.Bouton;
import morpion.*;

/**
 *
 * @author damien
 */
public class ControleGrille implements Observer{
    
    private Joueur j1 = new Joueur("toto", Symbole.CROIX);
    private Joueur j2 = new Joueur("titi", Symbole.ROND);
    private Morpion morpion = new Morpion(j1, j2, 3);
    
    @Override
    public void update(Observable VueMorpion, Object b) {
        if (b instanceof Bouton) {
            Bouton bouton = (Bouton) b;
            morpion.cocherCase(bouton);
        }
        
        morpion.joueurSuivant(); 
        
        }
    
 
    
}
