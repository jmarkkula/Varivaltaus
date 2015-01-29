package varivaltaus.varivaltaus.kayttoliittyma.teksti;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import varivaltaus.varivaltaus.kayttoliittyma.Kayttoliittyma;
import varivaltaus.varivaltaus.pelilogiikka.*;

/**
 *
 * @author juma
 */
public class Tekstikayttoliittyma implements Kayttoliittyma {

    private final Ruudukko ruudukko;
    private final LinkedList<Pelaaja> pelaajat;
    private final Lukija lukija;

    public Tekstikayttoliittyma(Ruudukko r, LinkedList<Pelaaja> p) {
        this.ruudukko = r;
        this.pelaajat = p;
        this.lukija=new Lukija();
    }

    @Override
    public int kysyVari(List<Integer> varivaihtoehdot, Pelaaja p) {
        System.out.println("Valitse uusi värisi (vaihtoehdot: " + varivaihtoehdot + " ):");
        int luku = this.lukija.lueIntSyote();
        return luku;
    }

    @Override
    public void paivitaPelilauta() {
        System.out.println("Pelilauta:");
        System.out.println(this.ruudukko.toString());
        System.out.println();
        for(Pelaaja p: this.pelaajat) {
            System.out.println("Pelaajan " + p.getPelaajaNro() + " väri:" + p.getNykyinenVari());
        }
    }
}
