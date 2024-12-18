package WsbZad2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KosciTest {
    static Kosci kosci = new Kosci();


    @Test
    public void czyKoscNapewnoJestKoscia() {
        int[] rzut = kosci.rzucWszystkie();
        for(int i = 0; i < rzut.length; i++) {
            assertTrue(rzut[i] < 7);
        }
    }

    @Test
    public void czyJestPiecKosci() {
        int[] rzut = kosci.rzucWszystkie();
        assertEquals(5, rzut.length);
    }

    @Test
    public void tabToArray() {
        int[] tab = {0,4,5,6,7};
        for(int x = 0; x < tab.length; x++) {
            assertEquals(tab[x], kosci.tabToArray(tab).get(x));
        }
        assertEquals(tab.length, kosci.tabToArray(tab).size());
    }

    @Test
    public void nieSaTakieSame() {
        int[] tab = {0,0,0,0,7};
        assertFalse(kosci.allEquals(tab));
    }

    @Test
    public void saTakieSame() {
        int[] tab = {1,1,1,1,1};
        assertTrue(kosci.allEquals(tab));
    }

    @Test
    public void wszystkieRozne() {
        int[] tab = {1,2,3,4,5};
        assertTrue(kosci.allDifferent(tab));
    }

    @Test
    public void prawieWszystkieRozne() {
        int[] tab = {2,2,2,2,5};
        assertFalse(kosci.allDifferent(tab));
    }

    @Test
    public void punktyTakieSame() {
        int[] tab = {3,3,3,3,3};
        assertEquals(50, kosci.podliczPunkty(tab));
    }

    @Test
    public void punktyZadneTakieSame() {
        int[] tab = {2,1,4,5,6};
        assertEquals(5, kosci.podliczPunkty(tab));
    }

    @Test
    public void punktyPara() {
        int[] tab = {2,1,2,5,6};
        assertEquals(16, kosci.podliczPunkty(tab));
    }

    @Test
    public void wygrywaGracz() {
        kosci.computerPoints = 2;
        kosci.playerPoints = 12;
        assertEquals("gracz", kosci.winner());
    }

    @Test
    public void wygrywaKomputer() {
        kosci.computerPoints = 50;
        kosci.playerPoints = 24;
        assertEquals("komputer", kosci.winner());
    }

}