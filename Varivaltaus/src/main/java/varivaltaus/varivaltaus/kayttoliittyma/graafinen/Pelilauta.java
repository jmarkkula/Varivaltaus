
package varivaltaus.varivaltaus.kayttoliittyma.graafinen;

import javax.swing.JPanel;
import java.awt.GridLayout;
import varivaltaus.varivaltaus.pelilogiikka.Ruudukko;

/**
 * Varsinainen pelialue, sisältää väriruudut.
 */
public class Pelilauta extends JPanel {

    private final Variruutu[] variruudut;

    protected Pelilauta(Ruudukko r, Varit v) {
        setLayout(new GridLayout(r.getKorkeus(), r.getLeveys()));

        this.variruudut = new Variruutu[r.getRuutujenMaara()];

        int n = 0;

        for (int y = 0; y < r.getKorkeus(); y++) {
            for (int x = 0; x < r.getLeveys(); x++, n++) {
                Variruutu uusi = new Variruutu(r.getRuutu(x, y), v);
                
                variruudut[n] = uusi;

                add(uusi);
            }
        }
    }
}
