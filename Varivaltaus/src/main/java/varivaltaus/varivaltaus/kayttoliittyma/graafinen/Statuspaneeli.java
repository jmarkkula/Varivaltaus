package varivaltaus.varivaltaus.kayttoliittyma.graafinen;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.JPanel;
import varivaltaus.varivaltaus.pelilogiikka.Pelaaja;
import varivaltaus.varivaltaus.pelilogiikka.Ruudukko;

/**
 * Sisältää pelaajapaneelit, jotka näyttävät käyttäjälle ilmoituksia
 * pelitilanteesta.
 */
public class Statuspaneeli extends JPanel {

    private final HashMap<Pelaaja, Pelaajapaneeli> pelaajapaneelit;

    protected Statuspaneeli(LinkedList<Pelaaja> p, Varit v, Ruudukko r) {
        this.setLayout(new GridLayout(1, p.size()));

        this.pelaajapaneelit = new HashMap<>();

        for (Pelaaja pelaaja : p) {
            Pelaajapaneeli uusi = new Pelaajapaneeli(pelaaja, v, r);
            this.pelaajapaneelit.put(pelaaja, uusi);
            this.add(uusi);
        }
    }

    protected void paivita() {
        for (Pelaajapaneeli p : this.pelaajapaneelit.values()) {
            p.paivita();
        }
    }

    protected void asetaTeksti(Pelaaja kenelleAsetetaan, String teksti) {
        this.pelaajapaneelit.get(kenelleAsetetaan).asetaTeksti(teksti);
    }
}
