package varivaltaus.varivaltaus.kayttoliittyma.graafinen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author juma
 */
public class VaripainikeKuuntelija implements ActionListener {

    private boolean nappiaPainettu;
    private int painettuVari;

    public VaripainikeKuuntelija() {
        this.nappiaPainettu=false;
        this.painettuVari=-666;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Varipainike painettu = (Varipainike) e.getSource();

        this.painettuVari = painettu.getVari();
        this.nappiaPainettu = true;
    }

    public int kasittelePainanta() throws Exception {
        if (this.nappiaPainettu) {
            this.nappiaPainettu = false;
            return this.painettuVari;
        } else {
            throw new Exception("Kutsuttiin kasittelePainanta() kun nappia ei oltu painettu.");
        }
    }

    public boolean onkoPainettu() {
        return this.nappiaPainettu;
    }
}
