import java.awt.*;
import javax.swing.border.Border;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class VueTuile extends JPanel {
    
    private static Border bordureSelection = BorderFactory.createLineBorder(Color.YELLOW,5);
    private static Border bordureBrillance = BorderFactory.createLineBorder(Color.BLACK,3);

    private Tuile tuile;
	private int posX;
	private int posY;
	private int orientation;
	private boolean brillance;
	private boolean selectionnee;
	private boolean mouvable;


    public VueTuile(Tuile t, int x, int y, boolean m, MouseListener controleur) {
		setPreferredSize(getPreferredSize());
		tuile = t;
		orientation = -1;
		posX = x;
		posY = y;
		brillance = false;
		selectionnee = false;
		mouvable = m;
		addMouseListener(controleur);
    }

	public Tuile getTuile() {
		return tuile;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public int getOrientation() {
		return orientation;
	}

	public boolean getMouvable() {
		return mouvable;
	}

	public boolean estVide() {
		return tuile == null;
	}

	public boolean setTuile(Tuile t) {
		if (tuile != null && t != null)
			return false;

		if (t == null) {
			selectionnee = false;
			setBorder(null);
		}
		else{
			orientation = t.getOrientation();
		}
		tuile = t;
		updateVue();
        repaint();
		return true;
	}

	public void setOrientation(int i) {
		orientation = i;
	}

	public boolean setBrillance(boolean b) {
		if (selectionnee)
			return false;

		brillance = b;

        if (brillance)
            setBorder(bordureBrillance);
        else
            setBorder(null);
		return true;
	}

	public boolean estSelectionnable(Joueur courant) {
		return (mouvable && tuile != null && tuile.getJoueur() == courant);
	}

	public void setSelectionnee(boolean s) {
		selectionnee = s;
		if (s)
			setBorder(bordureSelection);
		else
			setBorder(null);
	}

	public boolean doitUpdate() {
		return tuile != null && orientation != tuile.getOrientation();
	}

	public void updateVue() { }

    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(doitUpdate()){
			updateVue();
		}
    }

	public Dimension getPreferredSize() {
		return new Dimension(80,80);
	}
}
