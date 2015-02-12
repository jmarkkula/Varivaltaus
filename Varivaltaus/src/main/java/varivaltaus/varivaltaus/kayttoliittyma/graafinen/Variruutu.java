/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varivaltaus.varivaltaus.kayttoliittyma.graafinen;

import java.awt.Graphics;
import javax.swing.JPanel;
import varivaltaus.varivaltaus.pelilogiikka.Ruutu;

/**
 *
 * @author juma
 */
public class Variruutu extends JPanel {

    private final Varit varit;
    private final Ruutu ruutu;

    public Variruutu(Ruutu r, Varit v) {
        this.varit = v;
        this.ruutu = r;
    }
   
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int leveys = this.getWidth();
        int korkeus = this.getHeight();

        g.drawLine(0, 0, 0, korkeus);
        g.drawLine(0, 0, leveys, 0);
        g.drawLine(leveys, 0, leveys, korkeus);
        g.drawLine(0, korkeus, leveys, korkeus);

        g.setColor(this.varit.getVari(this.ruutu.getVari()));
        g.fillRect(0, 0, leveys, korkeus);
    }
}
