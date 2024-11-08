package liste;

public class ListeSimple {
    private long size;
    Noeud tete;

/**
 * Returns the current size of the list.
 *
 * @return the number of elements in the list.
 */
    public long getSize() {
        return size;
    }

    /**
     * Ajoute un l ment  la liste, en t te.
     * @param element l l ment  ajouter.
     */
    public void ajout(int element) {
        tete = new Noeud(element, tete);
        size++;
    }


    /**
     * Modifie le premier  l ment de la liste qui a comme valeur
     * <code>element</code> en mettant  jour sa valeur avec
     * <code>nouvelleValeur</code>. Si aucun  l ment ne correspond,
     * la liste n'est pas modifi e.
     *
     * @param element la valeur de l' l ment  modifier
     * @param nouvelleValeur la nouvelle valeur de l' l ment
     */

    public void modifiePremier(Object element, Object nouvelleValeur) {
        Noeud courant = tete;
        while (courant != null && courant.getElement() != element)
            courant = courant.getSuivant();
        if (courant != null)
            courant.setElement(nouvelleValeur);
    }

    
    /**
     * Modifie tous les  l ments de la liste qui ont comme valeur
     * l'objet <code>element</code> et remplace cette valeur par
     * l'objet <code>nouvelleValeur</code>.
     * @param nouvelleValeur l'objet qui remplace <code>element</code>.
     */

    public void modifieTous(Object element, Object nouvelleValeur) {
        Noeud courant = tete;
        while (courant != null) {
            if (courant.getElement() == element)
                courant.setElement(nouvelleValeur);
            courant = courant.getSuivant();
        }
    }

    /**
     * Renvoie une chaîne de caractères qui représente la liste sous la forme
     * "ListeSimple(Noeud1, Noeud2, ...)".
     * @return une cha ne de caractères qui représente la liste.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("ListeSimple(");
        Noeud n = tete;
        while (n != null) {
            sb.append(n);
            n = n.getSuivant();
            if (n != null)
                sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }

/**
 * Supprime le premier nœud de la liste ayant la valeur spécifiée par
 * <code>element</code>. Si un tel nœud est trouvé, il est retiré de 
 * la liste et la taille de la liste est décrémentée. Si aucun nœud 
 * correspondant n'est trouvé, la liste reste inchangée.
 *
 * @param element la valeur de l'élément à supprimer.
 */
    public void supprimePremier(Object element) {
        if (tete != null) {
            if (tete.getElement() == element) {
                tete = tete.getSuivant();
                size--;
                return;
            }
            Noeud precedent = tete;
            Noeud courant = tete.getSuivant();
            while (courant != null && courant.getElement() != element) {
                precedent = precedent.getSuivant();
                courant = courant.getSuivant();
            }
            if (courant != null) {
                precedent.setSuivant(courant.getSuivant());
                size--;
            }
        }
    }

/**
 * Supprime tous les nœuds de la liste ayant la valeur spécifiée par
 * <code>element</code>. Tous les nœuds correspondants sont retirés de 
 * la liste et la taille de la liste est ajustée en conséquence.
 *
 * @param element la valeur de l'élément à supprimer.
 */
    public void supprimeTous(int element) {
       tete = supprimeTousRecurs(element, tete);
    }

    public Noeud supprimeTousRecurs(Object element, Noeud tete) {
        if (tete != null) {
            Noeud suiteListe = supprimeTousRecurs(element, tete.getSuivant());
            if (tete.getElement() == element) {
                size--;
                return suiteListe;
            } else {
                tete.setSuivant(suiteListe);
                return tete;
            }
        } else return null;
    }

    /**
     * Renvoie le nœud qui précède le dernier nœud de la liste.
     * Si la liste est vide ou n'a qu'un seul élément, renvoie <code>null</code>.
     * @return le nœud qui précède le dernier nœud de la liste.
     */
    public Noeud getAvantDernier() {
        if (tete == null || tete.getSuivant() == null)
            return null;
        else {
            Noeud courant = tete;
            Noeud suivant = courant.getSuivant();
            while (suivant.getSuivant() != null) {
                courant = suivant;
                suivant = suivant.getSuivant();
            }
            return courant;
        }
    }

    /**
     * Inverse l'ordre des éléments de la liste en place.
     */
    public void inverser() {
        Noeud precedent = null;
        Noeud courant = tete;
        while (courant != null) {
            Noeud next = courant.getSuivant();
            courant.setSuivant(precedent);
            precedent = courant;
            courant = next;
        }
        tete = precedent;
    }

    public Noeud getPrecedent(Noeud r) {
    // la liste n'est pas vide puisqu'on transmet un Node de la liste et le Node existe obligatoirement
        Noeud precedent = tete;
        Noeud courant = precedent.getSuivant();
        while (courant != r) {
            precedent = courant;
            courant = courant.getSuivant();
        }
        return precedent;
    }

    public void echanger(Noeud r1, Noeud r2) {
        if (r1 == r2)
            return;
        Noeud precedentR1;
        Noeud precedentR2;
        if (r1 != tete && r2 != tete) {
            precedentR1 = getPrecedent(r1);
            precedentR2 = getPrecedent(r2);
            precedentR1.setSuivant(r2);
            precedentR2.setSuivant(r1);
        } else if (r1 == tete) {
            precedentR2 = getPrecedent(r2);
            precedentR2.setSuivant(tete);
            tete = r2;
        }
        else {
            precedentR1 = getPrecedent(r1);
            precedentR1.setSuivant(tete);
            tete = r1;
        }
        Noeud temp = r2.getSuivant();
        r2.setSuivant(r1.getSuivant());
        r1.setSuivant(temp);
    }

}