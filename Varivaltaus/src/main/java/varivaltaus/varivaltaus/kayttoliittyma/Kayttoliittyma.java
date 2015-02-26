/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varivaltaus.varivaltaus.kayttoliittyma;

import java.util.List;
import varivaltaus.varivaltaus.pelilogiikka.Pelaaja;

/**
 * Pelinpyörittäjä-luokan hyväksymä käyttöliittymä-rajapinta.
 *
 */
public interface Kayttoliittyma {

    /**
     * Pyytää käyttäjää valitsemaan yhden annetuista väreistä.
     *
     * @param varivaihtoehdot Värejä edustavat kokonaisluvut, joista käyttäjä
     * saa valita yhden.
     * @param keneltaKysytaan Pelaaja, jonka vuoro on valita väri.
     * @return Kokonaisluku joka edustaa väriä, jonka käyttäjä valtsi.
     */
    int kysyVari(List<Integer> varivaihtoehdot, Pelaaja keneltaKysytaan);

    /**
     * Pyytää käyttöliittymää päivittämään käyttäjälle näkyvän pelilautanäkymän.
     */
    void paivitaPelilauta();

    /**
     * Pyytää käyttöliittymää julistamaan pelin voittajan.
     *
     * @param voittaja Pelaaja, joka julistetaan voittajaksi
     */
    void julistaVoittaja(Pelaaja voittaja);
}
