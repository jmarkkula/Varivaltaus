package varivaltaus.varivaltaus.kayttoliittyma.graafinen;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import varivaltaus.varivaltaus.pelilogiikka.Pelaaja;
import varivaltaus.varivaltaus.pelilogiikka.Ruudukko;

/**
 * Yksittäisen pelaajan pelitilanteen ja vuoro/voitto-ilmoituksien näyttämiseen
 * tarkoitettu paneeli, joita asetetaan Statuspaneeliin yksi jokaista pelaajaa
 * kohden.
 */
public class Pelaajapaneeli extends JPanel {

    private final Pelaaja pelaaja;
    private final Varit varit;
    private final JLabel teksti;
    private final Ruudukko ruudukko;

    protected Pelaajapaneeli(Pelaaja p, Varit v, Ruudukko r) {
        this.pelaaja = p;
        this.varit = v;
        this.ruudukko = r;

        this.setLayout(new BorderLayout());
        this.setBackground(this.varit.getVari(this.pelaaja.getNykyinenVari()));

        this.teksti = new JLabel("");
        this.teksti.setHorizontalAlignment(SwingConstants.CENTER);
        this.teksti.setForeground(Color.GRAY);
        this.add(this.teksti);
    }

    protected void paivita() {
        this.teksti.setText("Alueesi koko: " + this.pelaaja.getAlueenKoko() + "/" + this.ruudukko.getRuutujenMaara());
        this.setBackground(this.varit.getVari(this.pelaaja.getNykyinenVari()));
    }

    protected void asetaTeksti(String teksti) {
        this.teksti.setText(teksti + " " + this.teksti.getText());
        this.revalidate();
        this.repaint();
    }
}
