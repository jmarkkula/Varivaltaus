package varivaltaus.varivaltaus.kayttoliittyma.graafinen;

import java.awt.Color;
import java.util.HashMap;

/**
 * Hallinnoi pelilogiikan värejä edustavien numeroiden mäppäystä varsinaisiksi
 * Color-olioiksi.
 */
public class Varit {

    HashMap<Integer, Color> varit;

    public Varit() {
        this.varit = new HashMap<>();
        this.luoVarit();
    }

    public Color getVari(int varinNumero) {
        if (!this.varit.containsKey(varinNumero)) {
            throw (new Error("Värejä ei ole luotu noin montaa Varit-luokassa"));
        }

        return this.varit.get(varinNumero);
    }

    private void luoVarit() {
        this.varit.put(1, new Color(175, 230, 173)); //v.vihreä
        this.varit.put(2, new Color(203, 147, 230)); //lila
        this.varit.put(3, new Color(230, 163, 167)); //v.pun.
        this.varit.put(4, new Color(232, 255, 154)); //v.kelt.
        this.varit.put(5, new Color(146, 171, 229)); //v.sin
        this.varit.put(6, Color.MAGENTA);
        this.varit.put(7, Color.blue);
        this.varit.put(8, Color.GREEN);

    }

}
