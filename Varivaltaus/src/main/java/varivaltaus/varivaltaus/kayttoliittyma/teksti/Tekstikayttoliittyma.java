package varivaltaus.varivaltaus.kayttoliittyma.teksti;

import java.util.List;
import varivaltaus.varivaltaus.kayttoliittyma.Kayttoliittyma;
import varivaltaus.varivaltaus.pelilogiikka.*;

/**
 *
 * @author juma
 */
public class Tekstikayttoliittyma implements Kayttoliittyma {

    private final Lukija lukija;

    public Tekstikayttoliittyma(Ruudukko r, List<Pelaaja> p) {
        this.lukija = new Lukija();
    }

    @Override
    public int kysyVari(List<Integer> varivaihtoehdot, Pelaaja p) {
        int luku;

        while (true) {
            System.out.println("Pelaaja " + p.getPelaajaNro() + ", valitse uusi värisi (vaihtoehdot: " + varivaihtoehdot + " ):");
            luku = this.lukija.lueIntSyote();

            if (varivaihtoehdot.contains(luku)) {
                System.out.println();
                return luku;
            }

            System.out.println("Et voi valita tuota väriä.");
        }

    }

    @Override
    public void paivitaPelilauta(Ruudukko ruudukko, List<Pelaaja> pelaajat) {
        System.out.println("Pelilauta:");
        System.out.println(ruudukko.yksinkertainenString());

        System.out.println();

        for (Pelaaja p : pelaajat) {
            System.out.println("Pelaajan " + p.getPelaajaNro() + ". väri: " + p.getNykyinenVari() + ", alueen koko: " + p.getAlueenKoko() + "/" + ruudukko.getRuutujenMaara());
        }

        System.out.println();
    }

    @Override
    public void julistaVoittaja(Pelaaja p) {
        System.out.println("Pelaaja " + p.getPelaajaNro() + ". on voittanut!");
    }

}
