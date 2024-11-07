package liste;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListeSimpleTest {

    ListeSimple listeATester;

    @BeforeEach
    void init() {
        listeATester = new ListeSimple();
    }

    @Test
    void listeConstruiteVide() {
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }

    @Test
    void ajoutAugmenteSize() {
        listeATester.ajout(1);
        assertEquals(1, listeATester.getSize());
    }

    @Test
    void ajoutChangeTete() {
        listeATester.ajout(1);
        Noeud teteApresPremierAjout = listeATester.tete;
        listeATester.ajout(1);
        assertNotNull(teteApresPremierAjout);
        assertNotSame(teteApresPremierAjout, listeATester.tete);
    }

    @Test
    void ajoutPlusieursFoisLeMeme() {
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.ajout(1);
        assertEquals(3, listeATester.getSize());
    }

    @Test
    void toStringDonneTousLesNoeuds() {
        System.out.println(listeATester);
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        System.out.println(listeATester);
        assertEquals("ListeSimple(Noeud(3), Noeud(2), Noeud(1))",listeATester.toString());
    }

    @Test
    void modifiePremier() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.modifiePremier(2, 4);
        assertEquals("ListeSimple(Noeud(3), Noeud(4), Noeud(1))",listeATester.toString());
        assertEquals(4, listeATester.tete.getSuivant().getElement());
    }

    @Test
    void modifieTous() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.modifieTous(1, 4);
        assertEquals("ListeSimple(Noeud(4), Noeud(4), Noeud(2), Noeud(4))",listeATester.toString());
        assertEquals(4,listeATester.tete.getSuivant().getElement());
    }

    @Test
    void supprimePremierListeVide() {
        listeATester.supprimePremier(1);
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }

    @Test
    void supprimePremierEnPremierePosition() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.supprimePremier(3);
        assertEquals("ListeSimple(Noeud(2), Noeud(1))",listeATester.toString());
        assertEquals(2, listeATester.getSize());
    }

    @Test
    void supprimePremierEnPositionQuelconque() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        listeATester.supprimePremier(2);
        assertEquals("ListeSimple(Noeud(4), Noeud(3), Noeud(1))",listeATester.toString());
        assertEquals(3, listeATester.getSize());
    }

    @Test
    void supprimePremierEnDernierePosition() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        listeATester.supprimePremier(1);
        assertEquals("ListeSimple(Noeud(4), Noeud(3), Noeud(2))",listeATester.toString());
        assertEquals(3, listeATester.getSize());
    }

    @Test
    void supprimeTousListeVide() {
        listeATester.supprimeTous(1);
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }

    @Test
    void supprimeTousUneSeuleFoisAuDebut() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.supprimeTous(3);
        assertEquals("ListeSimple(Noeud(2), Noeud(1))",listeATester.toString());
        assertEquals(2, listeATester.getSize());
    }

    @Test
    void supprimeTousUneSeuleFoisPositionQuelconque() {
        listeATester.ajout(1);
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.supprimeTous(3);
        assertEquals("ListeSimple(Noeud(2), Noeud(1))",listeATester.toString());
        assertEquals(2, listeATester.getSize());
    }

    @Test
    void supprimeTousPlusieursFois() {
        listeATester.ajout(2);
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.supprimeTous(1);
        assertEquals("ListeSimple(Noeud(2))",listeATester.toString());
        assertEquals(1, listeATester.getSize());
    }

    @Test
    void supprimeTousPlusieursFoisPositionQuelconque() {
        listeATester.ajout(3);
        listeATester.ajout(1);
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.supprimeTous(3);
        assertEquals("ListeSimple(Noeud(2), Noeud(1))",listeATester.toString());
        assertEquals(2, listeATester.getSize());
    }

    @Test
    void avantDernierListeVide() {
        assertNull(listeATester.getAvantDernier());
    }

    @Test
    void avantDernierListeAUnElement() {
        listeATester.ajout(1);
        assertNull(listeATester.getAvantDernier());
    }

    @Test
    void avantDernierListeADeuxElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        assertEquals(2, listeATester.getAvantDernier().getElement());
    }

    @Test
    void avantDernierListeAPlusieursElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        assertEquals(2, listeATester.getAvantDernier().getElement());
    }

    @Test
    void inverserListeVide() {
        listeATester.inverser();
        assertNull(listeATester.tete);
    }

    @Test
    void inverserListeNbPairDElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        listeATester.inverser();
        assertEquals("ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4))",listeATester.toString());
    }

    @Test
    void inverserListeNbImPairDElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.inverser();
        assertEquals("ListeSimple(Noeud(1), Noeud(2), Noeud(3))",listeATester.toString());
    }

    @Test
    void echanger2NoeudsQuelconques() {
        listeATester.ajout(5);
        listeATester.ajout(4);
        Noeud r1 = listeATester.tete;
        listeATester.ajout(3);
        listeATester.ajout(2);
        Noeud r2 = listeATester.tete;
        listeATester.ajout(1);
        assertEquals("ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4), Noeud(5))",listeATester.toString());
        listeATester.echanger(r1, r2);
        assertEquals("ListeSimple(Noeud(1), Noeud(4), Noeud(3), Noeud(2), Noeud(5))",listeATester.toString());
    }

    @Test
    void echangerLePremierNoeudAvecUnAutre() {
        listeATester.ajout(5);
        listeATester.ajout(4);
        Noeud r2 = listeATester.tete;
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.ajout(1);
        Noeud r1 = listeATester.tete;
        assertEquals("ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4), Noeud(5))",listeATester.toString());
        listeATester.echanger(r1, r2);
        System.out.println(listeATester);
        assertEquals("ListeSimple(Noeud(4), Noeud(2), Noeud(3), Noeud(1), Noeud(5))",listeATester.toString());
    }

    @Test
    void echangerLePremierEnSecondArgumentNoeudAvecUnAutre() {
        listeATester.ajout(5);
        listeATester.ajout(4);
        Noeud r1 = listeATester.tete;
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.ajout(1);
        Noeud r2 = listeATester.tete;
        assertEquals("ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4), Noeud(5))",listeATester.toString());
        listeATester.echanger(r1, r2);
        System.out.println(listeATester);
        assertEquals("ListeSimple(Noeud(4), Noeud(2), Noeud(3), Noeud(1), Noeud(5))",listeATester.toString());
    }

    @Test
    void echangerDeuxNoeudsIdentiques() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        Noeud r1 = listeATester.tete;  
        Noeud r2 = listeATester.tete; 
        assertEquals("ListeSimple(Noeud(3), Noeud(2), Noeud(1))", listeATester.toString());
        listeATester.echanger(r1, r2);
        assertEquals("ListeSimple(Noeud(3), Noeud(2), Noeud(1))", listeATester.toString());
    }
    
    @Test
void modifierPremierTest() {
    listeATester.ajout(1);  
    listeATester.ajout(2);  
    listeATester.ajout(3);  

    listeATester.modifiePremier(2, 5);  
    assertEquals("ListeSimple(Noeud(3), Noeud(5), Noeud(1))", listeATester.toString());

    listeATester.modifiePremier(10, 15);  
    assertEquals("ListeSimple(Noeud(3), Noeud(5), Noeud(1))", listeATester.toString()); 

    listeATester.modifiePremier(3, 7);  
    assertEquals("ListeSimple(Noeud(7), Noeud(5), Noeud(1))", listeATester.toString());

    ListeSimple listeSingle = new ListeSimple();
    listeSingle.ajout(4); 
    listeSingle.modifiePremier(4, 8);  
    assertEquals("ListeSimple(Noeud(8))", listeSingle.toString());
}


@Test
void supprimePremierTest() {
    listeATester.ajout(1);
    listeATester.ajout(2);
    listeATester.ajout(3);

    listeATester.supprimePremier(3);
    assertEquals("ListeSimple(Noeud(2), Noeud(1))", listeATester.toString());
    assertEquals(2, listeATester.size);

    listeATester.supprimePremier(2);
    assertEquals("ListeSimple(Noeud(1))", listeATester.toString());
    assertEquals(1, listeATester.size);

    listeATester.supprimePremier(1);
    assertEquals("ListeSimple()", listeATester.toString());
    assertEquals(0, listeATester.size);

    listeATester.ajout(4);
    listeATester.ajout(5);
    listeATester.supprimePremier(10);
    assertEquals("ListeSimple(Noeud(5), Noeud(4))", listeATester.toString());
    assertEquals(2, listeATester.size);

    ListeSimple listeSingle = new ListeSimple();
    listeSingle.ajout(6);
    listeSingle.supprimePremier(6);
    assertEquals("ListeSimple()", listeSingle.toString());
    assertEquals(0, listeSingle.size);
}



}