import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class VuePlateau extends JPanel {
    
    private Plateau plateau;
    private int hauteur;
    private int largeur;
	private VueTuile[][] vues;

    public VuePlateau(int ha, int la, Plateau p, MouseListener controleur) {
        hauteur = ha;
        largeur = la;
        plateau = p;
        
        setLayout(new GridLayout(p.getHauteur(), p.getLargeur()));

        for (int i = 0; i < p.getHauteur(); i++) {
            for (int j = 0; j < p.getLargeur(); j++) {
                VueTuile vue = new VueTuile(p.getTuile(i+1, j+1), i+1, j+1, false, controleur);
                add(vue);
            }
        }
    }
}
