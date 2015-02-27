package varivaltaus.varivaltaus.kayttoliittyma.teksti;

import java.util.LinkedList;
import java.util.List;
import varivaltaus.varivaltaus.kayttoliittyma.Kayttoliittyma;
import varivaltaus.varivaltaus.pelilogiikka.*;

/**
 * Simppeli tekstikäyttöliittymä.
 */
public class Tekstikayttoliittyma implements Kayttoliittyma {

    private final Lukija lukija;
    private final Ruudukko ruudukko;
    private final LinkedList<Pelaaja> pelaajat;

    public Tekstikayttoliittyma(Ruudukko r, LinkedList<Pelaaja> p) {
        this.lukija = new Lukija();
        this.ruudukko = r;
        this.pelaajat = p;
    }

    @Override
    public int kysyVari(List<Integer> varivaihtoehdot, Pelaaja pelaaja) {
        int luku;

        while (true) {
            System.out.println("Pelaaja " + pelaaja.getPelaajaNro() + ", valitse uusi värisi (vaihtoehdot: " + varivaihtoehdot + " ):");
            luku = this.lukija.lueIntSyote();

            if (varivaihtoehdot.contains(luku)) {
                System.out.println();
                return luku;
            }

            System.out.println("Et voi valita tuota väriä.");
        }

    }

    @Override
    public void paivitaPelilauta() {
        System.out.println("Pelilauta:");
        System.out.println(ruudukko.yksinkertainenString());

        System.out.println();

        for (Pelaaja p : pelaajat) {
            System.out.println("Pelaajan " + p.getPelaajaNro() + ". väri: " + p.getNykyinenVari() + ", alueen koko: " + p.getAlueenKoko() + "/" + ruudukko.getRuutujenMaara());
        }

        System.out.println();
    }

    @Override
    public void julistaVoittaja(Pelaaja voittaja) {
        System.out.println("Pelaaja " + voittaja.getPelaajaNro() + ". on voittanut!");
    }

}
