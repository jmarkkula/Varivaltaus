package varivaltaus.varivaltaus.pelilogiikka;

import java.util.LinkedList;
import varivaltaus.varivaltaus.kayttoliittyma.*;

/**
 *
 * @author juma
 */
public class Pelinpyorittaja {

    private final Ruudukko ruudukko;
    private final LinkedList<Pelaaja> pelaajat;
    private final Kayttoliittyma ui;
    private final int variLkm;

    public Pelinpyorittaja(Ruudukko ruudukko, LinkedList<Pelaaja> pelaajat, Kayttoliittyma ui) {
        this.ruudukko = ruudukko;
        this.variLkm = ruudukko.getVariLkm();
        this.pelaajat = pelaajat;
        this.ui=ui;
        //this.PELI();
    }

    private void PELI() { //kuvaava nimi
        Pelaaja voittaja = null;
        
        while (true) {
            Pelaaja seuraava = this.pelaajat.removeFirst();
            
            annaVuoro(seuraava);
            
            if(this.voittaako(seuraava)) {
                voittaja=seuraava;
                break;
            }
            
            this.pelaajat.addLast(seuraava);
        }
        
        System.out.println("Pelaaja " + voittaja.getPelaajaNro() + " voitti!");
    }

    private boolean voittaako(Pelaaja p) {
        return p.getAlueenKoko() >= this.ruudukko.getRuutujenMaara() / 2; //tarkista meneekö puolellajakohommeli oikein
    }

    private void annaVuoro(Pelaaja seuraava) {
        int vari = kysyVaria();
        vaihdaVari(vari);
        valtaaRuudut();
    }

    private int kysyVaria() {
        int[] varit = vapaatVarit();
        return this.ui.kysyVari(varit);
    }

    private void vaihdaVari(int vari) {
        /*
        pelaajan väri, pelaajan alueen ruutujen värit
        */
    }

    private void valtaaRuudut() {
        /*
        etsi pelaajan alueen ruutujen viereisiä, pelaajan värin värisiä valtaamattomia ruutuja ja valtaa ne
        */
    }

    private int[] vapaatVarit() {
        //todo, harkitse eri palautusmuotoa myös
        
        return new int[]{666};
    }
}
