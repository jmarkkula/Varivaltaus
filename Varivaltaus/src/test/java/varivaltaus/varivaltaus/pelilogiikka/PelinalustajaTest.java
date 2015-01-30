package varivaltaus.varivaltaus.pelilogiikka;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juma
 */
public class PelinalustajaTest {

    @Test
    public void pelaajatSaavatEriVarit1() {
        Pelinalustaja pa = new Pelinalustaja(5, 5, 5);
        assertTrue(pa.getPelaajat().getFirst().getNykyinenVari() != pa.getPelaajat().getLast().getNykyinenVari());
    }

    @Test
    public void pelaajatSaavatEriVarit2() {
        Pelinalustaja pa = new Pelinalustaja(5, 5, 3);
        assertTrue(pa.getPelaajat().getFirst().getNykyinenVari() != pa.getPelaajat().getLast().getNykyinenVari());
    }

    @Test
    public void pelaajatSaavatEriVarit3() {
        Pelinalustaja pa = new Pelinalustaja(5, 5, 10);
        assertTrue(pa.getPelaajat().getFirst().getNykyinenVari() != pa.getPelaajat().getLast().getNykyinenVari());
    }

    @Test
    public void pelaajatValtaavatAloitusruutunsa() {
        Pelinalustaja pa = new Pelinalustaja(5, 5, 5);
        for (Pelaaja p : pa.getPelaajat()) {
            assertTrue(p.getAlueenKoko() > 0);
        }
    }

}
