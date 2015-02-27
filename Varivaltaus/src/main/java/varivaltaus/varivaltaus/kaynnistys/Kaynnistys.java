package varivaltaus.varivaltaus.kaynnistys;

import javax.swing.SwingUtilities;
import varivaltaus.varivaltaus.kayttoliittyma.graafinen.GraafinenKayttoliittyma;
import varivaltaus.varivaltaus.kayttoliittyma.graafinen.GraafinenKayttoliittymaDebug;
import varivaltaus.varivaltaus.kayttoliittyma.teksti.Tekstikayttoliittyma;
import varivaltaus.varivaltaus.pelilogiikka.Pelinalustaja;
import varivaltaus.varivaltaus.pelilogiikka.Pelinpyorittaja;

/**
 * Main-luokka, käynnistää pelin.
 */
public class Kaynnistys {

    public static void main(String[] args) {
        kaynnistaGraafinen(30, 15, 5);
         kaynnistaGraafinen(6, 4, 5);
    }

    /**
     * Käynnistää pelin graafisen käyttöliittymän kanssa.
     *
     * @param leveys Peliruudukon leveys.
     * @param korkeus Peliruudukon korkeus.
     * @param variLkm Montako eri väriä peliin halutaan.
     */
    private static void kaynnistaGraafinen(int leveys, int korkeus, int variLkm) {
        Pelinalustaja pa = new Pelinalustaja(leveys, korkeus, variLkm);
        GraafinenKayttoliittyma gui = new GraafinenKayttoliittyma(pa);
        Pelinpyorittaja pp = new Pelinpyorittaja(pa.getRuudukko(), pa.getPelaajat(), gui);

        SwingUtilities.invokeLater(gui);

        while (!gui.onkoValmisPelinAloitukseen()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Käyttöliittymä ei ole vielä valmis.");
            }
        }

        pp.aloitaPeli();
    }

    /**
     * Käynnistää pelin tekstikäyttöliittymän kanssa. Värejä edustavat
     * kokonaisluvut.
     *
     * @param leveys Peliruudukon leveys.
     * @param korkeus Peliruudukon korkeus.
     * @param variLkm Montako eri väriä peliin halutaan.
     */
    private static void kaynnistaTeksti(int leveys, int korkeus, int variLkm) {
        Pelinalustaja pa = new Pelinalustaja(leveys, korkeus, variLkm);
        Tekstikayttoliittyma ui = new Tekstikayttoliittyma(pa.getRuudukko(), pa.getPelaajat());
        Pelinpyorittaja pp = new Pelinpyorittaja(pa.getRuudukko(), pa.getPelaajat(), ui);

        pp.aloitaPeli();
    }

    /**
     * Käynnistää pelin graafisen käyttöliittymän debuggausversion kanssa.
     *
     * @param leveys Peliruudukon leveys.
     * @param korkeus Peliruudukon korkeus.
     * @param variLkm Montako eri väriä peliin halutaan.
     */
    private static void kaynnistaGraafinenDebug(int leveys, int korkeus, int variLkm) {
        Pelinalustaja pa = new Pelinalustaja(leveys, korkeus, variLkm);
        GraafinenKayttoliittymaDebug gui = new GraafinenKayttoliittymaDebug(pa);

        Pelinpyorittaja pp = new Pelinpyorittaja(pa.getRuudukko(), pa.getPelaajat(), gui);

        SwingUtilities.invokeLater(gui);

        while (!gui.onkoValmisPelinAloitukseen()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Käyttöliittymä ei ole vielä valmis.");
            }
        }

        pp.aloitaPeli();
    }
}
