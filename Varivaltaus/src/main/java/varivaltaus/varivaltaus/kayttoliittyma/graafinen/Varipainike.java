package varivaltaus.varivaltaus.kayttoliittyma.graafinen;

import javax.swing.JButton;

/**
 * Painikepaneelissa käytettävät värinapit.
 */
public class Varipainike extends JButton {

    private final int vari;
    private final Varit varit;

    public Varipainike(int vari, Varit varit) {
        this.vari = vari;
        this.varit = varit;
        this.setBackground(this.varit.getVari(vari));
    }

    public int getVari() {
        return this.vari;
    }
}
