package morpion;

import static java.lang.Math.pow;
import java.util.List;

public class Plateau {
    private int cote;
    private int nbCase;
    private int grille [][] ;
    
    public Plateau(int n){
        setCote(n);
        setNbCase(n);
        grille = new int[n][n];
    }
    

    /**
     * @return the cote
     */
    public int getCote() {
        return cote;
    }

    /**
     * @param cote the cote to set
     */
    public void setCote(int cote) {
        this.cote = cote;
    }

    /**
     * @return the nbCase
     */
    public int getNbCase() {
        return nbCase;
    }

    /**
     * @param nbCase the nbCase to set
     */
    public void setNbCase(int nbCase) {
        this.nbCase = (int) pow(nbCase,2.0);
    }

    /**
     * @return the Grille
     */
    public int[][] getGrille() {
        return grille;
    }
}
