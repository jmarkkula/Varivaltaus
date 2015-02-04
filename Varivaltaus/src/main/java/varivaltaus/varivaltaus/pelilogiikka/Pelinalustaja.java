package varivaltaus.varivaltaus.pelilogiikka;

import java.util.LinkedList;

/**
 * Luokka alustaa ja säilyttää pelissä käytettävän peliruudukon ja pelaajat.
 *
 */
public class Pelinalustaja {

    private final Ruudukko ruudukko;
    private LinkedList<Pelaaja> pelaajat;

    /**
     * Konstruktori generoi ruudukon, luo pelaajat ja asettaa pelaajat
     * aloitusalueilleen.
     *
     * @param leveys Ruudukon leveys.
     * @param korkeus Ruudukon korkeus.
     * @param variLkm Peliin haluttu eri värien määrä.
     */
    public Pelinalustaja(int leveys, int korkeus, int variLkm) {
        this.ruudukko = new Ruudukko(leveys, korkeus, variLkm);
        this.luoPelaajat();
    }

    /**
     * Palauttaa viitteen pelin ruudukkoon.
     *
     * @return Viite Ruudukkoon.
     */
    public Ruudukko getRuudukko() {
        return this.ruudukko;
    }

    /**
     * Palauttaa listan pelin pelaaja-olioista.
     *
     * @return Pelaajat LinkedListissä.
     */
    public LinkedList<Pelaaja> getPelaajat() {
        return this.pelaajat;
    }

    private void luoPelaajat() {
        this.pelaajat = new LinkedList<>();

        Pelaaja p1 = luoPelaaja(1, this.ruudukko.getRuutu(0, 0));
        Pelaaja p2 = luoPelaaja(2, this.ruudukko.getRuutu(this.ruudukko.getLeveys() - 1, this.ruudukko.getKorkeus() - 1));

        this.pelaajat.add(p1);
        this.pelaajat.add(p2);
    }

    private Pelaaja luoPelaaja(int pelaajaNro, Ruutu aloitusruutu) {

        Pelaaja p = new Pelaaja(pelaajaNro, aloitusruutu.getVari());
        p.valtaaRuutu(aloitusruutu);

        return p;
    }

}
