/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varivaltaus.varivaltaus.pelilogiikka;

import java.util.ArrayList;
import java.util.Collections;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juma
 */
public class SatunnaistajaTest {

    public Satunnaistaja s;

    public SatunnaistajaTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.s = new Satunnaistaja();
    }

    @Test
    public void satunnainenListastaPalauttaaKaikkiaListanLukujaEikaMuuta() {
        ArrayList<Integer> lista = new ArrayList<>();

        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);

        ArrayList<Integer> palautetut = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            int l = s.satunnainenListasta(lista);
            if (!palautetut.contains(l)) {
                palautetut.add(l);
            }
        }

        Collections.sort(palautetut);

        assertEquals(lista, palautetut);
    }
   
}
