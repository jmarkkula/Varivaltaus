package varivaltaus.varivaltaus.pelilogiikka;

/**
 *
 * @author juma
 */
public class Pelinalustaja {

    private final int variLkm;
    private final Ruudukko ruudukko;
    private Vuoronantaja vuoronantaja;
    private Varinvaihtaja varinvaihtaja;

    public Pelinalustaja(int leveys, int korkeus, int variLkm) {
        this.variLkm = variLkm;
        this.ruudukko = new Ruudukko(leveys, korkeus, variLkm);
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
