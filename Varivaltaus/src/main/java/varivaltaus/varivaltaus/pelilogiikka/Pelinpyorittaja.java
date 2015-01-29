package varivaltaus.varivaltaus.pelilogiikka;

import java.util.ArrayList;
import java.util.LinkedList;
import varivaltaus.varivaltaus.kayttoliittyma.*;

/**
 *
 * @author juma
 */
public class Pelinpyorittaja {

    private final Ruudukko ruudukko;
    private final LinkedList<Pelaaja> pelaajat;
    private final Kayttoliittyma ui;
    private final int variLkm;

    public Pelinpyorittaja(Ruudukko ruudukko, LinkedList<Pelaaja> pelaajat, Kayttoliittyma ui) {
        this.ruudukko = ruudukko;
        this.variLkm = ruudukko.getVariLkm();
        this.pelaajat = pelaajat;
        this.ui = ui;
    }

    public void aloitaPeli() {
        valtaaPelaajilleAloitusAlueet();

        Pelaaja voittaja = null;

        while (voittaja == null) {
            this.ui.paivitaPelilauta(this.ruudukko, this.pelaajat);

            annaSeuraavaVuoro();

            if (this.voittaako(this.pelaajat.peekLast())) {
                voittaja = this.pelaajat.getLast();
            }
        }

        this.ui.paivitaPelilauta(this.ruudukko, this.pelaajat);
        this.ui.julistaVoittaja(voittaja);
    }

    private void annaSeuraavaVuoro() {
        Pelaaja seuraava = this.pelaajat.removeFirst();
        this.pelaajat.addLast(seuraava);
        pelaaVuoro(seuraava);
    }

    private void valtaaPelaajilleAloitusAlueet() {
        for (Pelaaja p : this.pelaajat) {
            this.valtaaUudetRuudut(p);
        }
    }

    private boolean voittaako(Pelaaja p) {
        return p.getAlueenKoko() >= (this.ruudukko.getRuutujenMaara() + 1) / 2; //tarkista meneekö puolellajakohommeli oikein
    }

    private void pelaaVuoro(Pelaaja p) {
        int vari = kysyVaria(vapaatVarit(), p);
        p.vaihdaVari(vari);
        this.valtaaUudetRuudut(p);
    }

    private int kysyVaria(ArrayList<Integer> vapaatVarit, Pelaaja p) {
        return this.ui.kysyVari(vapaatVarit, p);
    }

    private ArrayList<Integer> vapaatVarit() {
        ArrayList<Integer> varit = new ArrayList();

        for (int i = 1; i <= variLkm; i++) {
            if (onkoVapaaVari(i)) {
                varit.add(i);
            }
        }

        return varit;
    }

    private boolean onkoVapaaVari(int i) {
        for (Pelaaja p : this.pelaajat) {
            if (p.getNykyinenVari() == i) {
                return false;
            }
        }

        return true;
    }

    private void valtaaUudetRuudut(Pelaaja p) {
        ArrayList<Ruutu> alue = p.getListaAlueesta();

        for (Ruutu r : alue) {
            valtaaYmparoivatRuudut(r, p);
        }

    }

    private void valtaaYmparoivatRuudut(Ruutu r, Pelaaja p) {

        ArrayList<Ruutu> viereiset = this.ruudukko.getViereisetRuudut(r.getX(), r.getY());

        for (Ruutu v : viereiset) {
            if (!v.isVallattu() && v.getVari() == p.getNykyinenVari()) {
                p.valtaaRuutu(v);
                valtaaYmparoivatRuudut(v, p);
            }
        }

    }

}
