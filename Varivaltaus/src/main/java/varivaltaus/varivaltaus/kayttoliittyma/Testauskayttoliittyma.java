/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varivaltaus.varivaltaus.kayttoliittyma;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import varivaltaus.varivaltaus.kayttoliittyma.Kayttoliittyma;
import varivaltaus.varivaltaus.pelilogiikka.Pelaaja;
import varivaltaus.varivaltaus.pelilogiikka.Ruudukko;
import varivaltaus.varivaltaus.pelilogiikka.Satunnaistaja;

/**
 *
 * @author juma
 */

//Tämä luokka ei oikein toimi tällä hetkellä 

public class Testauskayttoliittyma implements Kayttoliittyma {

    public Pelaaja voittaja;
    private final Satunnaistaja s;
    final LinkedList<Pelaaja> vuorohistoria;

    public Testauskayttoliittyma() {
        s = new Satunnaistaja();
        vuorohistoria = new LinkedList<>();
    }

    @Override
    public int kysyVari(List<Integer> varivaihtoehdot, Pelaaja keneltaKysytaan) {
        vuorohistoria.add(keneltaKysytaan);
        return s.satunnainenJoukosta((ArrayList)varivaihtoehdot);
    }

    @Override
    public void paivitaPelilauta(Ruudukko ruudukko, List<Pelaaja> pelaajat) {
        //hmm
    }

    @Override
    public void julistaVoittaja(Pelaaja voittaja) {
        this.voittaja = voittaja;
    }
}
