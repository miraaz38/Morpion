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
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import morpion.Bouton;

/**
 *
 * @author carrierd
 */
public class VueParamPlateau {
    private JFrame window ;
    private HashMap<Integer, JRadioButton> ensembleDesBoutonsRadios ;
    
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
        JPanel panelCentre = new JPanel(new GridLayout(3,5));
        mainPanel.add(panelCentre, BorderLayout.CENTER);
        panelCentre.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        for (int i = 1; i <= 4; i++) {
            panelCentre.add(new JLabel());
        }
        
        
        panelCentre.add(new JLabel("Taille du plateau :")) ;
        
        for (int i = 1; i <= 2; i++) {
            panelCentre.add(new JLabel());
        }

        ButtonGroup groupeEspeces = new ButtonGroup();
        ensembleDesBoutonsRadios = new HashMap<>();
        
        JRadioButton boutonRadio = new JRadioButton("3 X 3");
        panelCentre.add(boutonRadio);
        groupeEspeces.add(boutonRadio);
        ensembleDesBoutonsRadios.put(ensembleDesBoutonsRadios.size(), boutonRadio);
        
        for (int i = 1; i <= 2; i++) {
            panelCentre.add(new JLabel());
        }

        boutonRadio = new JRadioButton("4 X 4");
        panelCentre.add(boutonRadio);
        groupeEspeces.add(boutonRadio);
        ensembleDesBoutonsRadios.put(ensembleDesBoutonsRadios.size(), boutonRadio);
        
        for (int i = 1; i <= 2; i++) {
            panelCentre.add(new JLabel());
        }

        boutonRadio = new JRadioButton("5 X 5");
        panelCentre.add(boutonRadio);
        groupeEspeces.add(boutonRadio);
        ensembleDesBoutonsRadios.put(ensembleDesBoutonsRadios.size(), boutonRadio);
        
        for (int i = 1; i <= 4; i++) {
            panelCentre.add(new JLabel());
        }

    
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
    
    public void afficher() {
        this.window.setVisible(true);
    }
    
    public static void main(String [] args) {
        VueParamPlateau exemple1 = new VueParamPlateau();
        exemple1.afficher();
   }
}
