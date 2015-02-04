
package varivaltaus.varivaltaus.pelilogiikka;

import java.util.ArrayList;
import java.util.List;
import varivaltaus.varivaltaus.kayttoliittyma.Kayttoliittyma;

/**
 *
 * @author juma
 */

//Tämä luokka ei oikein toimi tällä hetkellä 

public class Logiikantestauskayttoliittyma implements Kayttoliittyma {

    public Pelaaja voittaja;
    private final Satunnaistaja s;

    public Logiikantestauskayttoliittyma() {
        s = new Satunnaistaja();
    }

    @Override
    public int kysyVari(List<Integer> varivaihtoehdot, Pelaaja keneltaKysytaan) {
        return s.satunnainenListasta((ArrayList)varivaihtoehdot);
    }

    @Override
    public void paivitaPelilauta(Ruudukko ruudukko, List<Pelaaja> pelaajat) {
        //ei ehkä tarvii mitään
    }

    @Override
    public void julistaVoittaja(Pelaaja voittaja) {
        this.voittaja = voittaja;
    }
}
