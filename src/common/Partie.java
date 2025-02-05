public abstract class Partie {
    
    private Joueur[] joueurs;
	private Joueur joueurCourant;
	private int indiceJoueur;
    
    private Sac sac;
    private Plateau plateau;
    
	public Partie(Sac s, Plateau p, Joueur[] j) {
        sac = s;
        plateau = p;
		joueurs = j;
		indiceJoueur = 0;
		joueurCourant = j[0];
    }


	public abstract boolean estFinie();

	public int getjc(){
		return indiceJoueur;
	}

    public Sac getSac() {
        return sac;
    }

    public Plateau getPlateau() {
        return plateau;
    }

	public Joueur getJoueur(int i) {
		return joueurs[i];
	}

	public Joueur[] getJoueurs() {
		return joueurs;
	}

	public Joueur getJoueurCourant() {
		return joueurCourant;
	}

	public Tuile pioche() {
		return sac.pioche();
	}

	public void prochainTour() {
		indiceJoueur = (indiceJoueur+1) % joueurs.length;
		joueurCourant = joueurs[indiceJoueur];
	}

	public boolean estPosable(int x, int y, Tuile t) {
		return plateau.estPosable(x, y, t);
	}

	public void jouerTour(int x, int y, Tuile t) {
		plateau.setTuile(x, y, t);
		prochainTour();
	}



}

