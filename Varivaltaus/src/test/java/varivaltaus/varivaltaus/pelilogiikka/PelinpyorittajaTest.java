/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varivaltaus.varivaltaus.pelilogiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juma
 */
public class PelinpyorittajaTest {

    private Pelinalustaja pa;
    private Logiikantestauskayttoliittyma testiUI;

    @Before
    public void setUp() {
        pa = new Pelinalustaja(5, 5, 5);
        testiUI = new Logiikantestauskayttoliittyma();
    }

    /*
    Nää junnaa koska testauskäyttöliittymä ei oikein skulaa vielä :(
    
    
    @Test
    public void pelinVoittaaOikeaVoittaja() {
        Pelinpyorittaja pp = new Pelinpyorittaja(pa.getRuudukko(), pa.getPelaajat(), testiUI);
        pp.aloitaPeli();

        Pelaaja kenenPitaisiVoittaa = pa.getPelaajat().getFirst();

        if (pa.getPelaajat().getLast().getAlueenKoko() > kenenPitaisiVoittaa.getAlueenKoko()) {
            kenenPitaisiVoittaa = pa.getPelaajat().getLast();
        }

        assertEquals(testiUI.voittaja, kenenPitaisiVoittaa);

    } 


    @Test
    public void vuorotJaetaanOikein() {
        Pelinpyorittaja pp = new Pelinpyorittaja(pa.getRuudukko(), pa.getPelaajat(), testiUI);
        pp.aloitaPeli();

        Pelaaja edellinen = testiUI.vuorohistoria.get(0);
        
        for (int i = 1; i < testiUI.vuorohistoria.size(); i++) {
            assertTrue(!testiUI.vuorohistoria.get(i).equals(edellinen));
            edellinen = testiUI.vuorohistoria.get(i);
        }
    }

*/


}
