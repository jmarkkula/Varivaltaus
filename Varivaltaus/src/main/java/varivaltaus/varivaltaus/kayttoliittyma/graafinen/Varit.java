/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varivaltaus.varivaltaus.kayttoliittyma.graafinen;

import java.awt.Color;
import java.util.HashMap;

/**
 *
 * @author juma
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
        this.varit.put(1, Color.WHITE);
        this.varit.put(2, Color.LIGHT_GRAY);
        this.varit.put(3, Color.GRAY);
        this.varit.put(4, Color.DARK_GRAY);
        this.varit.put(5, Color.BLACK);
        this.varit.put(6, Color.MAGENTA);
        this.varit.put(7, Color.blue);
        this.varit.put(8, Color.GREEN);

    }

}
