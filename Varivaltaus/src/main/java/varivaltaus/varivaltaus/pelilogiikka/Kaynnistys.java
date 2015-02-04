package varivaltaus.varivaltaus.pelilogiikka;

import javax.swing.SwingUtilities;
import varivaltaus.varivaltaus.kayttoliittyma.graafinen.GraafinenKayttoliittyma;
import varivaltaus.varivaltaus.kayttoliittyma.teksti.Tekstikayttoliittyma;

/**
 *
 * @author juma
 */
public class Kaynnistys {

    public static void main(String[] args) {
        // kaynnistaTekstiversio();
        kaynnistaGraafinen();
    }

    private static void kaynnistaGraafinen() {
        Pelinalustaja pa = new Pelinalustaja(10, 5, 5); //valitse pelilaudan koko 
        GraafinenKayttoliittyma gui = new GraafinenKayttoliittyma(pa.getRuudukko());
        SwingUtilities.invokeLater(gui);

        Tekstikayttoliittyma ui = new Tekstikayttoliittyma();
        Pelinpyorittaja pp = new Pelinpyorittaja(pa.getRuudukko(), pa.getPelaajat(), ui);

        pp.aloitaPeli();

    }

    private static void kaynnistaTekstiversio() {
        Pelinalustaja pa = new Pelinalustaja(4, 3, 5); //valitse pelilaudan koko
        Tekstikayttoliittyma ui = new Tekstikayttoliittyma();
        Pelinpyorittaja pp = new Pelinpyorittaja(pa.getRuudukko(), pa.getPelaajat(), ui);

        pp.aloitaPeli();
    }
}
