package varivaltaus.varivaltaus.kayttoliittyma.graafinen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;
import javax.swing.*;
import varivaltaus.varivaltaus.kayttoliittyma.Kayttoliittyma;
import varivaltaus.varivaltaus.pelilogiikka.Pelaaja;
import varivaltaus.varivaltaus.pelilogiikka.Pelinalustaja;
import varivaltaus.varivaltaus.pelilogiikka.Ruudukko;

/**
 * Graafinen käyttöliittymä pelille.
 */
public class GraafinenKayttoliittyma implements Kayttoliittyma, Runnable {

    private final Ruudukko ruudukko;
    private final LinkedList<Pelaaja> pelaajat;
    private Varit varit;
    private JFrame frame;
    private Pelilauta pelilauta;
    private Painikepaneeli painikepaneeli;

    private Statuspaneeli statuspaneeli;

    public GraafinenKayttoliittyma(Pelinalustaja pa) {
        this.ruudukko = pa.getRuudukko();
        this.pelaajat = pa.getPelaajat();
        luoVarit();
    }

    private void luoVarit() {
        this.varit = new Varit();
    }

    @Override
    public void run() {
        frame = new JFrame("Värivaltaus");

        frame.setPreferredSize(new Dimension(this.ruudukko.getLeveys() * 100, this.ruudukko.getKorkeus() * 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container contentPane) {
        contentPane.setLayout(new BorderLayout());

        this.pelilauta = new Pelilauta(this.ruudukko, this.varit);
        contentPane.add(this.pelilauta);

        JPanel paneelit = luoAlapaneelit();
        contentPane.add(paneelit, BorderLayout.SOUTH);
    }

    private JPanel luoAlapaneelit() {
        JPanel paneelit = new JPanel(new GridLayout(2, 1));
        
        //määritä paneelien/painikkeiden koot? framen koosta riippuvainen leveys?
        
        this.statuspaneeli = new Statuspaneeli(this.pelaajat, this.varit);
        paneelit.add(this.statuspaneeli);
        
        this.painikepaneeli = new Painikepaneeli(this.ruudukko, this.varit);
        paneelit.add(this.painikepaneeli);

        return paneelit;
    }

    /**
     * Kertoo, onko käyttöliittymän komponenttien luonti valmista, jotta kaikki
     * toimii oikein kun pelilogiikka alkaa kutsua käyttöliittymän metodeja.
     *
     * @return True jos valmis, false jos ei.
     */
    public boolean onkoValmisPelinAloitukseen() {
        return this.pelilauta != null && this.painikepaneeli != null && this.statuspaneeli != null;
    }

    @Override
    public int kysyVari(List<Integer> varivaihtoehdot, Pelaaja keneltaKysytaan) {
        this.statuspaneeli.asetaTeksti(keneltaKysytaan, "valitse uusi väri alueellesi");

        int vari = this.painikepaneeli.kysyVari(varivaihtoehdot);

        this.statuspaneeli.asetaTeksti(keneltaKysytaan, "");

        return vari;
    }

    @Override
    public void paivitaPelilauta() {
        this.statuspaneeli.paivita();
        this.frame.revalidate();
        this.frame.repaint();
    }

    @Override
    public void julistaVoittaja(Pelaaja voittaja) {
        this.statuspaneeli.asetaTeksti(voittaja, "voitit!");
    }

}
