/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varivaltaus.varivaltaus.kayttoliittyma.graafinen;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.*;
import varivaltaus.varivaltaus.kayttoliittyma.Kayttoliittyma;
import varivaltaus.varivaltaus.pelilogiikka.Pelaaja;
import varivaltaus.varivaltaus.pelilogiikka.Pelinalustaja;
import varivaltaus.varivaltaus.pelilogiikka.Ruudukko;

/**
 *
 * @author juma
 */
public class GraafinenKayttoliittyma implements Kayttoliittyma, Runnable {

    private final Ruudukko ruudukko;
    private final Varit varit;
    private JFrame frame;
    private Pelilauta pelilauta;
    private Painikepaneeli painikepaneeli;

    public GraafinenKayttoliittyma(Pelinalustaja pa) {
        this.ruudukko = pa.getRuudukko();
        this.varit = new Varit();
    }

    @Override
    public void run() {
        frame = new JFrame("Värivaltaus");
        frame.setPreferredSize(new Dimension(this.ruudukko.getLeveys() * 100, this.ruudukko.getKorkeus() * 100));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
        JPanel paneelit = new JPanel(new GridLayout(1, 1));
        
        this.painikepaneeli = new Painikepaneeli(this.ruudukko, this.varit);
        paneelit.add(this.painikepaneeli);
        
        //luo statuspaneeli
        
        return paneelit;
    }

    public boolean onkoValmisPelinAloitukseen() {
        return this.pelilauta!=null && this.painikepaneeli!=null;
    }
    
    public JFrame getFrame() {
        return frame;
    }

    @Override
    public int kysyVari(List<Integer> varivaihtoehdot, Pelaaja keneltaKysytaan) {
        return this.painikepaneeli.kysyVari(varivaihtoehdot);
    }

    @Override
    public void paivitaPelilauta() {
        frame.revalidate();
        frame.repaint();
    }

    @Override
    public void julistaVoittaja(Pelaaja voittaja) {
        throw new UnsupportedOperationException("Ei ole tehty vielä.");
    }

}
