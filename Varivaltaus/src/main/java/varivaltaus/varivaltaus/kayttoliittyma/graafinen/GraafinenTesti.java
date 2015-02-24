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
import java.awt.Toolkit;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import varivaltaus.varivaltaus.kayttoliittyma.Kayttoliittyma;
import varivaltaus.varivaltaus.kayttoliittyma.graafinen.Painikepaneeli;
import varivaltaus.varivaltaus.kayttoliittyma.graafinen.Pelilauta;
import varivaltaus.varivaltaus.kayttoliittyma.graafinen.Varit;
import varivaltaus.varivaltaus.pelilogiikka.Pelaaja;
import varivaltaus.varivaltaus.pelilogiikka.Ruudukko;

/**
 *
 * @author juma
 */
public class GraafinenTesti implements Kayttoliittyma, Runnable {

    private final Ruudukko ruudukko;
    private final Varit varit;
    private JFrame frame;
    private Pelilauta pelilauta;
    private Painikepaneeli painikepaneeli;
    private final LinkedList<Pelaaja> pelaajat;

    public GraafinenTesti(Ruudukko r, LinkedList<Pelaaja> p) {
        System.out.println("GUI: gui-olion luontia kutsuttu");
        this.ruudukko = r;
        this.varit = new Varit();
        this.pelaajat = p;
    }

    @Override
    public void run() {
        System.out.println("GUI: run() kutsuttu");
        frame = new JFrame("Värivaltaus");
        frame.setPreferredSize(new Dimension(this.ruudukko.getLeveys() * 100, this.ruudukko.getKorkeus() * 100));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container contentPane) {
        System.out.println("GUI: luoKomponentit kutsuttu");
        contentPane.setLayout(new BorderLayout());

        this.pelilauta = new Pelilauta(this.ruudukko, this.varit);
        contentPane.add(this.pelilauta);

        JPanel paneelit = new JPanel(new GridLayout(1, 1)); //2,1 sit ku tietopaneeli mukana
        
        this.painikepaneeli = new Painikepaneeli(this.ruudukko, this.varit);
        paneelit.add(this.painikepaneeli);
        
        contentPane.add(paneelit, BorderLayout.SOUTH);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getPelilauta() {
        return this.pelilauta;
    }

    @Override
    public int kysyVari(List<Integer> varivaihtoehdot, Pelaaja keneltaKysytaan) {
        System.out.println("GUI: kysyVari kutsuttu");

        return this.painikepaneeli.kysyVari(varivaihtoehdot);
    }

    @Override
    public void paivitaPelilauta() {
        System.out.println("GUI: paivitaPelilauta() kutsuttu");
        //Teksti
        System.out.println("Pelilauta:");
        System.out.println(ruudukko.yksinkertainenString());

        System.out.println();

        for (Pelaaja p : pelaajat) {
            System.out.println("Pelaajan " + p.getPelaajaNro() + ". väri: " + p.getNykyinenVari() + ", alueen koko: " + p.getAlueenKoko() + "/" + ruudukko.getRuutujenMaara());
        }

        System.out.println();

        //Graafinen
        frame.revalidate();
        frame.repaint();
    }
    
    public boolean onkoValmisPelinAloitukseen() {
        return this.pelilauta!=null && this.painikepaneeli!=null;
    }

    @Override
    public void julistaVoittaja(Pelaaja voittaja) {
        System.out.println("GUI: julistaVoittaja(voittaja) kutsuttu");
        //Teksti
        System.out.println("Pelaaja " + voittaja.getPelaajaNro() + ". on voittanut!");
    }

}
