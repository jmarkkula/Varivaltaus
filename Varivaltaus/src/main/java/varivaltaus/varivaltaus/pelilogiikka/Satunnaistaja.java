package varivaltaus.varivaltaus.pelilogiikka;

import java.util.ArrayList;
import java.util.Random;

/**
 * Satunnaistaja auttaa valitsemaan lukuja satunnaisesti.
 *
 * @author juma
 */
public class Satunnaistaja {

    private final Random random;

    /**
     * Luo uuden Satunnaistajan.
     */
    public Satunnaistaja() {
        this.random = new Random();
    }

    /**
     * Palauttaa satunnaisluvun joka on vähintään 1 ja enintään annettu
     * parametri.
     *
     * @param suurinMahd Satunnaisluvun maksimiarvo.
     * @return Satunnaisluku.
     */
    public int satunnaisLuku(int suurinMahd) {
        return this.random.nextInt(suurinMahd) + 1;
    }

    /**
     * Palauttaa satunnaisesti valitun luvun annetusta kokonaislukuja
     * sisältävästä listasta.
     *
     * @param luvut Lista luvuista.
     * @return Satunnaisesti valittu luku.
     */
    public int satunnainenListasta(ArrayList<Integer> luvut) {
        return luvut.get(this.random.nextInt(luvut.size()));
    }
}
