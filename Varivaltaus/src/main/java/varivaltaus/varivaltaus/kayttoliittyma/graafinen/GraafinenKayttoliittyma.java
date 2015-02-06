/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varivaltaus.varivaltaus.kayttoliittyma.graafinen;

import java.awt.Container;
import java.awt.Dimension;
import java.util.List;
import javax.swing.*;
import varivaltaus.varivaltaus.kayttoliittyma.Kayttoliittyma;
import varivaltaus.varivaltaus.pelilogiikka.Pelaaja;
import varivaltaus.varivaltaus.pelilogiikka.Ruudukko;

/**
 *
 * @author juma
 */
public class GraafinenKayttoliittyma implements Kayttoliittyma, Runnable {

    private JFrame frame;
    private Pelilauta pelilauta;
    private final Ruudukko ruudukko;

    public GraafinenKayttoliittyma(Ruudukko r) {
        this.ruudukko = r;
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
        Varit varit = new Varit();
        this.pelilauta = new Pelilauta(this.ruudukko, varit);
        contentPane.add(this.pelilauta);
    }

    public JFrame getFrame() {
        return frame;
    }
    
    public JPanel getPelilauta() {
        return this.pelilauta;
    }

    @Override
    public int kysyVari(List<Integer> varivaihtoehdot, Pelaaja keneltaKysytaan) {
        throw new UnsupportedOperationException("Ei ole tehty vielä."); 
    }

    //Tällä hetkellä pelilauta ei päivity, ellei ikkunaa vedä välillä hiirellä erikokoiseksi.
    @Override
    public void paivitaPelilauta() {
        this.pelilauta.paivita();
        frame.revalidate();
        frame.repaint();
    }

    @Override
    public void julistaVoittaja(Pelaaja voittaja) {
        throw new UnsupportedOperationException("Ei ole tehty vielä."); 
    }

}
