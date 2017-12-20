/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import morpion.Bouton;

/**
 *
 * @author carrierd
 */
public class VueParamPlateau {
    private JFrame window ;
    
    public VueParamPlateau(){
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setSize(700, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel) ;
        
        // =================================================================================
        // NORD
        JPanel panelHaut = new JPanel() ;
        //panelHaut.setSize(695, 95);
        mainPanel.add(panelHaut, BorderLayout.NORTH);
        panelHaut.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panelHaut.add(new JLabel("Choix du Plateau")) ;
 
        // =================================================================================
        // CENTRE
        JPanel panelCentre = new JPanel();
        mainPanel.add(panelCentre, BorderLayout.CENTER);
        panelCentre.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panelCentre.add(new J)
    
        // =================================================================================
        // SUD
        JPanel panelBas = new JPanel(new GridLayout(1,3)) ;
        mainPanel.add(panelBas, BorderLayout.SOUTH);
        //panelOuest.setSize(695, 45);
        panelBas.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panelBas.add(new JButton("Retour"));
        panelBas.add(new JLabel());
        panelBas.add(new JButton("Valider"));
        
        
    }
}
