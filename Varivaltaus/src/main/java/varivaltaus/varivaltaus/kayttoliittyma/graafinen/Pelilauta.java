/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varivaltaus.varivaltaus.kayttoliittyma.graafinen;

import javax.swing.JPanel;
import java.awt.GridLayout;
import varivaltaus.varivaltaus.pelilogiikka.Ruudukko;

/**
 *
 * @author juma
 */
public class Pelilauta extends JPanel {

    private final Variruutu[] variruudut;

    public Pelilauta(Ruudukko r, Varit v) {

        setLayout(new GridLayout(r.getKorkeus(), r.getLeveys()));

        this.variruudut = new Variruutu[r.getRuutujenMaara()];

        int n = 0;

        for (int i = 0; i < r.getKorkeus(); i++) {
            for (int j = 0; j < r.getLeveys(); j++) {
                variruudut[i] = new Variruutu(r.getRuutu(j, i), v);

                add(variruudut[i]);
                n++;
            }
        }
    }

    //super.paintcomonent juttuja tai jotain`tarvii?
    void paivita() {
        for(Variruutu v: this.variruudut) {
            v.revalidate();
            v.repaint();
        }
      }
}
