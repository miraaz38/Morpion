/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author damien
 */
public class VueTournoi extends Observable{
    private final JFrame window ;
    private JButton boutonValider;
    private JButton boutonRetour;
    private JButton boutonUnContreUn;
    private JButton boutonTournoi;
    private JLabel bienvenue;
    
    
    public VueTournoi(){
        Font f = new Font("arial", 0, 50);
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setSize(600, 400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        window.setTitle("MORPION");
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel) ;
        
        // =================================================================================
        // NORD
        JPanel panelHaut = new JPanel() ;
        mainPanel.add(panelHaut, BorderLayout.NORTH);
        bienvenue = new JLabel("BIENVENUE");
        panelHaut.add(bienvenue);
        bienvenue.setFont(f);
        
        // =================================================================================
        // OUEST 
        JPanel panelOuest = new JPanel();
        mainPanel.add(panelOuest, BorderLayout.WEST);
        
        // =================================================================================
        // EST
        JPanel panelEst = new JPanel();
        mainPanel.add(panelEst, BorderLayout.EAST);
        
        // =================================================================================
        // CENTRE
        JPanel panelCentre = new JPanel(new GridLayout(5,5));
        mainPanel.add(panelCentre, BorderLayout.CENTER);
        boutonUnContreUn = new JButton("1 vs 1");
        boutonTournoi = new JButton("Tournoi");
        for (int i = 0; i < 11; i++) {
            panelCentre.add(new JLabel());
        }
        panelCentre.add(boutonUnContreUn);
        panelCentre.add(new JLabel());
        panelCentre.add(boutonTournoi);
        for (int i = 0; i < 11; i++) {
            panelCentre.add(new JLabel());
        }
        
        
        // =================================================================================
        // SUD
        JPanel panelBas = new JPanel(new GridLayout(1,3)) ;
        mainPanel.add(panelBas, BorderLayout.SOUTH);
        boutonRetour = new JButton("Retour");
        
        panelBas.add(boutonRetour);
        panelBas.add(new JLabel()) ;
        
        boutonValider = new JButton("Valider");
        
        panelBas.add(boutonValider);
    }
    
    public void afficher() {
        this.window.setVisible(true);
    }
    
    public static void main(String [] args) {
        VueAcceuil exemple1 = new VueAcceuil();
        exemple1.afficher();
   }
    
}
