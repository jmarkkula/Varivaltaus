/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varivaltaus.varivaltaus.kayttoliittyma;

import java.util.List;
import varivaltaus.varivaltaus.pelilogiikka.Pelaaja;
import varivaltaus.varivaltaus.pelilogiikka.Ruudukko;


/**
 *
 * @author juma
 */
public interface Kayttoliittyma {
    int kysyVari(List<Integer> varivaihtoehdot, Pelaaja p);
    
    void paivitaPelilauta(Ruudukko ruudukko, List<Pelaaja> pelaajat);
    
    void julistaVoittaja(Pelaaja p);
}
