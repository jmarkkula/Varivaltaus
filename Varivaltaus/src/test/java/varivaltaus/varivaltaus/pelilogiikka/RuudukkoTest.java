package varivaltaus.varivaltaus.pelilogiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
        ruutu = new Ruutu(1);
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
        assertEquals(true, taytetty);
    }
    
    //TEE VALMIIKSI :))
//    @Test
//    public void ruudukkoTaytetaanOikeanVariskaalanRuuduilla() {
//        Ruudukko r = new Ruudukko(30, 20, 5);
//        boolean[] varit = new boolean[5];
//
//        for (int i = 0; i < r.getKorkeus(); i++) {
//            for (int j = 0; j < r.getLeveys(); j++) {
//                varit[r.getRuutu(j, i).getVari()]=true;
//            }
//        }
//        assertEquals(true, taytetty);
//    }

    @Test
    public void setRuutuAsettaaOikein1() {
        Ruudukko r = new Ruudukko(30, 20, 5);
        r.setRuutu(1, 2, ruutu);
        assertEquals(ruutu, r.getRuutu(1, 2));
    }

    @Test
    public void setRuutuAsettaaOikein2() {
        Ruudukko r = new Ruudukko(30, 20, 5);
        r.setRuutu(2, 1, ruutu);
        assertEquals(ruutu, r.getRuutu(2, 1));
    }

}
