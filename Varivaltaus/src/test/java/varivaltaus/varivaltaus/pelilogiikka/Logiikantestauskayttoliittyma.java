package varivaltaus.varivaltaus.pelilogiikka;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import varivaltaus.varivaltaus.kayttoliittyma.Kayttoliittyma;

/**
 *
 * @author juma
 */
public class Logiikantestauskayttoliittyma implements Kayttoliittyma {

    public LinkedList<Integer> vuorot;
    public Pelaaja voittaja;
    private final Satunnaistaja s;

    public Logiikantestauskayttoliittyma() {
        s = new Satunnaistaja();
        this.vuorot = new LinkedList<>();
    }

    @Override
    public int kysyVari(List<Integer> varivaihtoehdot, Pelaaja keneltaKysytaan) {
        this.vuorot.addLast(keneltaKysytaan.getPelaajaNro());
        return s.satunnainenListasta((ArrayList) varivaihtoehdot);
    }

    @Override
    public void paivitaPelilauta() {
    }

    @Override
    public void julistaVoittaja(Pelaaja voittaja) {
        this.voittaja = voittaja;
    }
}
