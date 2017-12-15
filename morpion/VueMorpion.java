package morpion;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import static java.awt.SystemColor.window;
import java.awt.Toolkit;
import java.util.Observable;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VueMorpion extends Observable{
    private final JFrame window ;
    
    public VueMorpion(){
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
        mainPanel.add(panelHaut, BorderLayout.NORTH);
        panelHaut.add(new JLabel("Joueur 1 VS Joueur 2")) ;
        
        // =================================================================================
        // OUEST 
        JPanel panelOuest = new JPanel(new GridLayout(3,1));
        mainPanel.add(panelOuest, BorderLayout.WEST);
        panelOuest.add(new JLabel("Joueur 1"));
        panelOuest.add(new JLabel("\n X"));
        
        // =================================================================================
        // EST
        JPanel panelEst = new JPanel(new GridLayout(3,1));
        mainPanel.add(panelEst, BorderLayout.EAST);
        panelEst.add(new JLabel("Joueur 2"));
        panelEst.add(new JLabel("\n O"));
        
        // =================================================================================
        // CENTRE
        JPanel panelCentre = new JPanel(new GridLayout(3,3));
        mainPanel.add(panelCentre, BorderLayout.CENTER);
        
        for (int i=1; i<=9; i++) {
            JLabel label = new JLabel("Cellule n°" + i, SwingConstants.CENTER) ;
            label.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 2));
            panelCentre.add(label);
        }
        
        // =================================================================================
        // SUD
        JPanel panelBas = new JPanel() ;
        mainPanel.add(panelBas, BorderLayout.SOUTH);
        panelBas.add(new JLabel("Bon match")) ;
        
        
    }
    
    public void afficher() {
        this.window.setVisible(true);
    }
    
    public static void main(String [] args) {
        VueMorpion exemple1 = new VueMorpion();
        exemple1.afficher();
   }
}
