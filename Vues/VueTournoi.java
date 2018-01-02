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
import javax.swing.JTextField;

/**
 *
 * @author damien
 */
public class VueTournoi extends Observable{
    private final JFrame window ;
    private JButton boutonValider;
    private JButton boutonRetour;
    private JLabel titre;
    private JPanel panelList;
    private JPanel panelJoueurs;
    private JComboBox listeDeroulante;
    
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
        titre = new JLabel("Tournoi", JLabel.CENTER);
        panelHaut.add(titre);
        titre.setFont(f);
        
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
        JPanel panelCentre = new JPanel(new GridLayout(3,1));
        mainPanel.add(panelCentre, BorderLayout.CENTER);
         // selection du nombre de joueur
        panelCentre.add(panelList = new JPanel(new GridLayout(1,2)));
        panelList.add(new JLabel("nombre de joueur : ", JLabel.RIGHT));
        listeDeroulante = new JComboBox();
        listeDeroulante.addItem(3);
        listeDeroulante.addItem(4);
        listeDeroulante.addItem(5);
        panelList.add(listeDeroulante);
        listeDeroulante.setSelectedIndex(0);
        
        // titre selection des pseudos
        panelCentre.add(new JLabel("SELECTION DES PSEUDOS", JLabel.CENTER));
        
        //Choix des pseudos
        panelCentre.add(panelJoueurs = new JPanel(new GridLayout(5,2)));
        
        for (int i = 1; i < 6; i++) {
            panelJoueurs.add(new JLabel("NOM JOUEUR " + i + " :", JLabel.RIGHT));
            panelJoueurs.add(new JTextField());
        }
        
        
        // =================================================================================
        // SUD
        JPanel panelBas = new JPanel(new GridLayout(1,3)) ;
        mainPanel.add(panelBas, BorderLayout.SOUTH);
        boutonRetour = new JButton("Retour");        
        
        boutonRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setChanged();
                String message = "Taille Plateau";                   
                notifyObservers(message);
                clearChanged();}
        });
        
        panelBas.add(boutonRetour);
        panelBas.add(new JLabel()) ;
        
        boutonValider = new JButton("Valider");
        
        boutonValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setChanged();
                String message = "Grille";                   
                notifyObservers(message);
                clearChanged();}
        });
        
        panelBas.add(boutonValider);
        
        listeDeroulante.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateNbr();
            }
        });
        updateNbr();
    }
    
    private void updateNbr(){
        for (int i = 0; i < 10; i+=2) {
            if(i < (listeDeroulante.getSelectedIndex() + 3) * 2){
                panelJoueurs.getComponent(i).setVisible(true);
                panelJoueurs.getComponent(i+1).setVisible(true);
            }
            else{
                panelJoueurs.getComponent(i).setVisible(false);
                panelJoueurs.getComponent(i+1).setVisible(false);
            }
            
        }
    }
    
    public void afficher() {
        this.window.setVisible(true);
    }
    
    public void fermer() {
        this.window.setVisible(false);
    }
    
    public static void main(String [] args) {
        VueTournoi exemple1 = new VueTournoi();
        exemple1.afficher();
   }
    
}
