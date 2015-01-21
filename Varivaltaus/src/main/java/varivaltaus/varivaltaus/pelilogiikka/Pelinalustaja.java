package varivaltaus.varivaltaus.pelilogiikka;

import java.util.Random;

/**
 *
 * @author juma
 */
public class Pelinalustaja {

    private final int variLkm;
    private final Random satunnaistaja;
    private Ruudukko ruudukko;
    private Vuoronantaja vuoronantaja;
    private Varinvaihtaja varinvaihtaja;

    public Pelinalustaja(int x, int y, int variLkm) {
        this.satunnaistaja = new Random();
        this.variLkm = variLkm;

        luoRuudukko(x, y);
    }

    private void luoRuudukko(int x, int y) {
        this.ruudukko = new Ruudukko(x, y);

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {

                Ruutu r = this.luoRuutu();
                this.ruudukko.setRuutu(i, j, r);

            }
        }
    }

    private Ruutu luoRuutu() {
        int vari = this.satunnaistaja.nextInt(variLkm - 1);
        return new Ruutu(vari);
    }

    public Ruudukko getRuudukko() {
        return ruudukko;
    }

    public Vuoronantaja getVuoronantaja() {
        return vuoronantaja;
    }

    public Varinvaihtaja getVarinvaihtaja() {
        return varinvaihtaja;
    }
}
