package varivaltaus.varivaltaus.pelilogiikka;

import varivaltaus.varivaltaus.kayttoliittyma.teksti.Tekstikayttoliittyma;

/**
 *
 * @author juma
 */
public class Kaynnistys {

    public static void main(String[] args) {
        Pelinalustaja pa = new Pelinalustaja(4, 3, 5); //valitse pelilaudan koko
        Tekstikayttoliittyma ui = new Tekstikayttoliittyma();
        Pelinpyorittaja pp = new Pelinpyorittaja(pa.getRuudukko(), pa.getPelaajat(), ui);
        
        pp.aloitaPeli();
    }
}
