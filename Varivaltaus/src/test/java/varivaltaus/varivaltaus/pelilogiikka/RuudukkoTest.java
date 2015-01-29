package varivaltaus.varivaltaus.pelilogiikka;

import java.util.Arrays;
import org.junit.After;
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

    public RuudukkoTest() {
    }

    @Before
    public void setUp() {
        ruutu = new Ruutu(1,1,1);
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
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
    public void ruutujaEiVoiSetataUudelleenRuudukonLuomisenJälkeen() {
        Ruudukko r = new Ruudukko(30, 20, 5);

        assertFalse(r.setRuutu(1, 2, ruutu));
    }

}
