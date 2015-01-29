package varivaltaus.varivaltaus.pelilogiikka;

import varivaltaus.varivaltaus.kayttoliittyma.teksti.Tekstikayttoliittyma;
import varivaltaus.varivaltaus.kayttoliittyma.*;

/**
 *
 * @author juma
 */
public class Kaynnistys {

    public static void main(String[] args) {
        Pelinalustaja pa = new Pelinalustaja(5, 10, 5); //HUOMHUOM MUOKKAA SITTEN OIKEAN KOKOISEKSI LAUTA
        Tekstikayttoliittyma ui = new Tekstikayttoliittyma(pa.getRuudukko(), pa.getPelaajat());
        Pelinpyorittaja pp = new Pelinpyorittaja(pa.getRuudukko(), pa.getPelaajat(), ui);
        

    }
}
