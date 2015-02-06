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

        int edellinen = testiUI.vuorot.pollFirst();
        
        int nykyinen;
        
        for (int i = 0; i < testiUI.vuorot.size(); i++) {
            nykyinen=testiUI.vuorot.pollFirst();
            assertTrue(edellinen!=nykyinen);
            edellinen=nykyinen;
        }
    }




}
