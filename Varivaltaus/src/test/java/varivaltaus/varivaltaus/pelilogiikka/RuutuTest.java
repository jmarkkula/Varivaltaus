package varivaltaus.varivaltaus.pelilogiikka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juma
 */
public class RuutuTest {

    private Pelaaja p1;
    private Pelaaja p2;

    public RuutuTest() {
    }

    @Before
    public void setUp() {
        p1 = new Pelaaja(1, 1);
        p2 = new Pelaaja(2, 2);
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void konstruktoriAsettaaTiedotOikein1() {
        Ruutu r = new Ruutu(1);

        assertEquals("[1,false,null]", r.toString());
    }

    @Test
    public void konstruktoriAsettaaTiedotOikein5() {
        Ruutu r = new Ruutu(5);

        assertEquals("[5,false,null]", r.toString());
    }

    @Test
    public void valtaamatonVallataanPalauttaaTrue() {
        Ruutu r = new Ruutu(1);

        assertEquals(true, r.valtaa(p1, 1));
    }


    @Test
    public void valtaamatonVallataanMuuttaaArvotOikein() {
        Ruutu r = new Ruutu(1);
        r.valtaa(p1, 1);

        assertEquals("[1,true,[1,1]]", r.toString());
    }

    @Test
    public void vallattunValtausPalauttaaFalse() {
        Ruutu r = new Ruutu(1);
        r.valtaa(p1, 1);

        assertEquals(false, r.valtaa(p2, 2));
    }
    
        @Test
    public void vallattunValtausEiMuutaArvoja() {
        Ruutu r = new Ruutu(1);
        r.valtaa(p1, 1);
        r.valtaa(p2, 2);

        assertEquals("[1,true,[1,1]]", r.toString());
    }

}
