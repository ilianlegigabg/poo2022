import java.util.LinkedList;

public class Sac {
    
    private LinkedList<Tuile> contenu;
    
    public Sac(LinkedList<Tuile> c) {
        contenu = c;
    }
    
    public boolean estVide() {
        return contenu.isEmpty();
    }

    public Tuile pioche() {
        if (contenu.isEmpty())
            return null;
        return contenu.pop();
    }
}