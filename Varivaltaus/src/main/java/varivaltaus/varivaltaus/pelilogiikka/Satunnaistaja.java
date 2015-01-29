package varivaltaus.varivaltaus.pelilogiikka;

import java.util.Random;

/**
 *
 * @author juma
 */
public class Satunnaistaja {

    private final Random random;

    public Satunnaistaja() {
        this.random = new Random();
    }

    public int satunnaisLuku(int suurinMahd) {
        return this.random.nextInt(suurinMahd) + 1;
    }
}
