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

    @Before
    public void setUp() {
        p1 = new Pelaaja(1, 1);
        p2 = new Pelaaja(2, 2);
    }

    @Test
    public void konstruktoriAsettaaTiedotOikein1() {
        Ruutu r = new Ruutu(1, 0, 0);

        assertEquals("[1,false,null]", r.toString());
    }

    @Test
    public void konstruktoriAsettaaTiedotOikein5() {
        Ruutu r = new Ruutu(5, 0, 0);

        assertEquals("[5,false,null]", r.toString());
    }

    @Test
    public void valtaamatonVallataanPalauttaaTrue() {
        Ruutu r = new Ruutu(1, 0, 0);

        assertEquals(true, r.merkitseVallatuksi(p1));
    }

    @Test
    public void valtaamatonVallataanMuuttaaArvotOikein() {
        Ruutu r = new Ruutu(1, 0, 0);
        r.merkitseVallatuksi(p1);

        assertEquals("[1,true,[1,1]]", r.toString());
    }

    @Test
    public void vallattunValtausPalauttaaFalse() {
        Ruutu r = new Ruutu(1, 0, 0);
        r.merkitseVallatuksi(p1);

        assertEquals(false, r.merkitseVallatuksi(p2));
    }

    @Test
    public void vallattunValtausEiMuutaArvoja() {
        Ruutu r = new Ruutu(1, 0, 0);
        r.merkitseVallatuksi(p1);
        r.merkitseVallatuksi(p2);

        assertEquals("[1,true,[1,1]]", r.toString());
    }

}
