package varivaltaus.varivaltaus.pelilogiikka;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

        this.aloitaPeli();
    }

    private void aloitaPeli() {
        Pelaaja voittaja = null;

        while (true) {
            Pelaaja seuraava = this.pelaajat.removeFirst();

            annaVuoro(seuraava);

            if (this.voittaako(seuraava)) {
                voittaja = seuraava;
                break;
            }

            this.pelaajat.addLast(seuraava);
        }

        System.out.println("Pelaaja " + voittaja.getPelaajaNro() + " voitti!");
    }

    private boolean voittaako(Pelaaja p) {
        return p.getAlueenKoko() >= this.ruudukko.getRuutujenMaara() / 2; //tarkista meneekö puolellajakohommeli oikein
    }

    private void annaVuoro(Pelaaja p) {
        int vari = kysyVaria(vapaatVarit(), p);
//        vaihdaVari(vari, p);
//        valtaaRuudut();
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

    private void vaihdaVari(int vari, Pelaaja p) {
        /*
         pelaajan väri, pelaajan alueen ruutujen värit
         */
    }

    private void valtaaRuudut() {
        /*
         etsi pelaajan alueen ruutujen viereisiä, pelaajan värin värisiä valtaamattomia ruutuja ja valtaa ne
         */
    }

}
