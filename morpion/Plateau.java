package morpion;

import static java.lang.Math.pow;
import java.util.ArrayList;
import java.util.List;

public class Plateau {
    private int cote;
    private int nbCase;
    private ArrayList<Case> cases;
    
    public Plateau(int n){
        setCote(n);
        setNbCase(n^2);
        
        for (int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                cases.add(new Case(i+1, j+1, null));
            }
        }
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
     * @return the cases
     */
    public ArrayList<Case> getCases() {
        return cases;
    }

    /**
     * @param cases the cases to set
     */
    public void setCases(ArrayList<Case> cases) {
        this.cases = cases;
    }
}
