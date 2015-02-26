package varivaltaus.varivaltaus.kayttoliittyma.graafinen;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import varivaltaus.varivaltaus.pelilogiikka.Pelaaja;
import varivaltaus.varivaltaus.pelilogiikka.Ruudukko;

public class Pelaajapaneeli extends JPanel {

    private final Pelaaja pelaaja;
    private final Varit varit;
    private final JLabel teksti;

    protected Pelaajapaneeli(Pelaaja p, Varit v) {
        this.pelaaja = p;
        this.varit = v;

        this.setLayout(new BorderLayout());
        this.setBackground(this.varit.getVari(this.pelaaja.getNykyinenVari()));

        this.teksti = new JLabel("");
        this.teksti.setHorizontalAlignment(SwingConstants.CENTER);
        this.teksti.setForeground(Color.GRAY);
        this.add(this.teksti);
    }

    protected void paivita() {
        this.setBackground(this.varit.getVari(this.pelaaja.getNykyinenVari()));
    }

    protected void asetaTeksti(String teksti) {
        this.teksti.setText(teksti);
        this.revalidate();
        this.repaint();
    }
}
