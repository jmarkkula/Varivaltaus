package varivaltaus.varivaltaus.kayttoliittyma.graafinen;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.JPanel;
import varivaltaus.varivaltaus.pelilogiikka.Pelaaja;
import varivaltaus.varivaltaus.pelilogiikka.Ruudukko;

public class Statuspaneeli extends JPanel {

    private final HashMap<Pelaaja, Pelaajapaneeli> pelaajapaneelit;

    public Statuspaneeli(Ruudukko r, LinkedList<Pelaaja> p, Varit v) {
        this.setLayout(new GridLayout(1, p.size()));

        pelaajapaneelit = new HashMap<>();

        for (Pelaaja pelaaja : p) {
            Pelaajapaneeli uusi = new Pelaajapaneeli(pelaaja, r, v);
            this.pelaajapaneelit.put(pelaaja, uusi);
            this.add(uusi);
        }
    }

    public void kysyVari(Pelaaja p) {
        this.pelaajapaneelit.get(p).kysyVari();
    }

    public void nollaaTeksti(Pelaaja p) {
        this.pelaajapaneelit.get(p).nollaaTeksti();
    }
}
