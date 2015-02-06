package varivaltaus.varivaltaus.pelilogiikka;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Assert;

/**
 *
 * @author juma
 */
public class RuudukkoTest {

    private Ruutu ruutu;

    @Before
    public void setUp() {
        ruutu = new Ruutu(1, 1, 1);
    }

    @Test
    public void konstruktoriLuoOikeanLevyisenRuudukon() {
        Ruudukko r = new Ruudukko(30, 20, 5);
        assertEquals(30, r.getLeveys());
    }

    @Test
    public void konstruktoriLuoOikeanKorkuisenRuudukon() {
        Ruudukko r = new Ruudukko(30, 20, 5);
        assertEquals(20, r.getKorkeus());
    }

    @Test
    public void ruudukkoTaytetaanRuuduilla() {
        Ruudukko r = new Ruudukko(30, 20, 5);
        boolean taytetty = true;

        for (int i = 0; i < r.getKorkeus(); i++) {
            for (int j = 0; j < r.getLeveys(); j++) {
                if (r.getRuutu(j, i) == null) {
                    taytetty = false;
                }
            }
        }

        assertTrue(taytetty);
    }

    @Test
    public void konstruktoriGeneroiVaihteleviaRuudukoita() {
        Ruudukko r1 = new Ruudukko(30, 20, 5);
        Ruudukko r2 = new Ruudukko(30, 20, 5);

        assertThat(r1.toString(), not(equalTo(r2.toString())));
    }

    @Test
    public void ruudukkoTaytetaanOikeanValinVareilla() {
        Ruudukko r = new Ruudukko(30, 20, 5);

        for (int y = 0; y < r.getKorkeus(); y++) {
            for (int x = 0; x < r.getLeveys(); x++) {
                int ruudunVari = r.getRuutu(x, y).getVari();
                assertTrue(ruudunVari < 6);
                assertTrue(ruudunVari > 0);
            }
        }

    }

    @Test
    public void ruudukkoTaytetaanKaikillaVareilla() {
        Ruudukko r = new Ruudukko(30, 20, 5);
        boolean[] kohdatutVarit = {false, false, false, false, false};

        for (int i = 0; i < r.getKorkeus(); i++) {
            for (int j = 0; j < r.getLeveys(); j++) {
                int ruudunVari = r.getRuutu(j, i).getVari();
                kohdatutVarit[ruudunVari - 1] = true;
            }
        }

        boolean[] haluttu = {true, true, true, true, true};

        Assert.assertTrue(Arrays.equals(haluttu, kohdatutVarit));
    }

    @Test
    public void getViereisetPalauttaaOikeatRuudutNaapurilliselle() {
        Ruudukko r = new Ruudukko(3, 3, 5);
        int x = 1;
        int y = 1;

        ArrayList<Ruutu> naapurit = new ArrayList<>();

        naapurit.add(r.getRuutu(0, 1));
        naapurit.add(r.getRuutu(1, 0));
        naapurit.add(r.getRuutu(2, 1));
        naapurit.add(r.getRuutu(1, 2));

        ArrayList<Ruutu> viereiset = r.getViereisetRuudut(x, y);

        assertTrue(naapurit.containsAll(viereiset) && viereiset.containsAll(naapurit));
    }

    @Test
    public void getViereisetPalauttaaTyhjanNaapurittomalle() {
        Ruudukko r = new Ruudukko(1, 1, 5);
        ArrayList<Ruutu> viereiset = r.getViereisetRuudut(0, 0);

        assertTrue(viereiset.isEmpty());
    }

}
