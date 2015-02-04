package varivaltaus.varivaltaus.pelilogiikka;

import javax.swing.SwingUtilities;
import varivaltaus.varivaltaus.kayttoliittyma.graafinen.GraafinenKayttoliittyma;
import varivaltaus.varivaltaus.kayttoliittyma.teksti.Tekstikayttoliittyma;

/**
 * Main-luokka, käynnistää ohjelman suorituksen.
 *
 * @author juma
 */
public class Kaynnistys {

    public static void main(String[] args) {
        kaynnistaGraafinenJaTeksti(30, 20, 5);
    }

    /**
     * Käynnistää pelin niin, että sekä graafinen että tekstikäyttöliittymä
     * pyörivät samanaikaisesti.
     *
     * @param leveys Peliruudukon leveys.
     * @param korkeus Peliruudukon korkeus.
     * @param variLkm Montako eri väriä peliin halutaan.
     */
    private static void kaynnistaGraafinenJaTeksti(int leveys, int korkeus, int variLkm) {
        Pelinalustaja pa = new Pelinalustaja(leveys, korkeus, variLkm);
        GraafinenKayttoliittyma gui = new GraafinenKayttoliittyma(pa.getRuudukko());
        Tekstikayttoliittyma ui = new Tekstikayttoliittyma();

        Pelinpyorittaja pp = new Pelinpyorittaja(pa.getRuudukko(), pa.getPelaajat(), ui);

        SwingUtilities.invokeLater(gui);
        pp.aloitaPeli();

    }

    /**
     * Käynnistää pelin tekstikäyttöliittymän kanssa. "Värejä" edustavat
     * kokonaisluvut.
     *
     * @param leveys Peliruudukon leveys.
     * @param korkeus Peliruudukon korkeus.
     * @param variLkm Montako eri väriä peliin halutaan.
     */
    private static void kaynnistaTekstiversio(int leveys, int korkeus, int variLkm) {
        Pelinalustaja pa = new Pelinalustaja(leveys, korkeus, variLkm);
        Tekstikayttoliittyma ui = new Tekstikayttoliittyma();
        Pelinpyorittaja pp = new Pelinpyorittaja(pa.getRuudukko(), pa.getPelaajat(), ui);

        pp.aloitaPeli();
    }
}
