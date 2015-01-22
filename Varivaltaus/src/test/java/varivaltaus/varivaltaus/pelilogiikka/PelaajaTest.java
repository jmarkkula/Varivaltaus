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
public class PelaajaTest {

    public PelaajaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void konstruktoriToimiiOikein1() {
        Pelaaja p = new Pelaaja(1, 2);
        assertEquals("[1,2]", p.toString());
    }
    
        @Test
    public void konstruktoriToimiiOikein2() {
        Pelaaja p = new Pelaaja(5, 1);
        assertEquals("[5,1]", p.toString());
    }
    
        @Test
    public void konstruktoriToimiiOikein3() {
        Pelaaja p = new Pelaaja(3, 3);
        assertEquals("[3,3]", p.toString());
    }
    
        @Test
    public void getVariToimii() {
        Pelaaja p = new Pelaaja(1, 2);
        assertEquals(2, p.getNykyinenVari());
    }
}
