package varivaltaus.varivaltaus.pelilogiikka;

import java.util.LinkedList;

/**
 *
 * @author juma
 */
public class Pelinalustaja {

    private final int variLkm;
    private final Ruudukko ruudukko;
    private final int leveys;
    private final int korkeus;
    private LinkedList<Pelaaja> pelaajat;

    public Pelinalustaja(int leveys, int korkeus, int variLkm) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.variLkm = variLkm;
        this.ruudukko = new Ruudukko(leveys, korkeus, variLkm);
        this.luoPelaajat();
    }

    public Ruudukko getRuudukko() {
        return ruudukko;
    }

    public int getVariLkm() {
        return variLkm;
    }

    private void luoPelaajat() {
        this.pelaajat = new LinkedList<>();

        Pelaaja p1 = luoPelaaja(1, this.ruudukko.getRuutu(0, 0));
        Pelaaja p2 = luoPelaaja(2, this.ruudukko.getRuutu(this.leveys - 1, this.korkeus - 1));

        this.pelaajat.add(p1);
        this.pelaajat.add(p2);
    }

    private Pelaaja luoPelaaja(int pelaajaNro, Ruutu aloitusruutu) {

        Pelaaja p = new Pelaaja(pelaajaNro, aloitusruutu.getVari());
        p.valtaaRuutu(aloitusruutu);

        return p;
    }

}
