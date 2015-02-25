package varivaltaus.varivaltaus.kayttoliittyma.graafinen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import varivaltaus.varivaltaus.pelilogiikka.Pelaaja;
import varivaltaus.varivaltaus.pelilogiikka.Ruudukko;

public class Pelaajapaneeli extends JPanel {
    private final int lkm;
    private final Pelaaja pelaaja;
    private final Varit varit;
    private JLabel teksti;

    public Pelaajapaneeli(Pelaaja p, Ruudukko r, Varit v) {
        this.pelaaja=p;
        this.lkm = r.getRuutujenMaara()/2;
        this.varit=v;
        
        this.setLayout(new GridLayout(1, lkm));
        
        this.teksti = new JLabel("");
        this.add(teksti);
        
        this.repaint();
    }

    protected void paintComponent() {
        this.removeAll();
        
        for (int i = 1; i <= this.pelaaja.getAlueenKoko(); i++) {
            JPanel ruutu = new JPanel();
            ruutu.setBackground(this.varit.getVari(this.pelaaja.getNykyinenVari()));
            this.add(ruutu);
        }
        
        for (int i = this.pelaaja.getAlueenKoko()+1; i <= this.lkm; i++) {
            JPanel ruutu = new JPanel();
            ruutu.setBackground(Color.lightGray);
            this.add(ruutu);
        }
        
        this.revalidate();
        this.repaint();
    }

    protected void kysyVari() {
        this.teksti = new JLabel("Pelaaja " + this.pelaaja.getPelaajaNro() + "., valitse väri");
        this.revalidate();
        this.repaint();
    }

    protected void nollaaTeksti() {
        this.teksti = new JLabel("");
        this.revalidate();
        this.repaint();
    }
}
