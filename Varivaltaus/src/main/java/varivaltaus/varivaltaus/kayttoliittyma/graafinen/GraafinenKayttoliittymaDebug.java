
package varivaltaus.varivaltaus.kayttoliittyma.graafinen;

import java.util.LinkedList;
import java.util.List;
import varivaltaus.varivaltaus.kayttoliittyma.Kayttoliittyma;
import varivaltaus.varivaltaus.pelilogiikka.Pelaaja;
import varivaltaus.varivaltaus.pelilogiikka.Pelinalustaja;
import varivaltaus.varivaltaus.pelilogiikka.Ruudukko;

/**
 *
 * @author juma
 */
public class GraafinenKayttoliittymaDebug implements Kayttoliittyma, Runnable {

    private final GraafinenKayttoliittyma gui;
    private final Ruudukko ruudukko;
    private final LinkedList<Pelaaja> pelaajat;

    public GraafinenKayttoliittymaDebug(Pelinalustaja pa) {
        System.out.println("GUI: GraafinenKayttoliittyma-olion luonti kutsuttu");
        
        this.ruudukko = pa.getRuudukko();
        this.pelaajat=pa.getPelaajat();
        this.gui = new GraafinenKayttoliittyma(pa);
    }

    @Override
    public void run() {
        System.out.println("GUI: run kutsuttu");
        
        this.gui.run();
    }

    @Override
    public int kysyVari(List<Integer> varivaihtoehdot, Pelaaja keneltaKysytaan) {
        System.out.println("GUI: kysyVari kutsuttu");

        int vari = this.gui.kysyVari(varivaihtoehdot, keneltaKysytaan);
        System.out.println("GUI: GraafinenKayttoliittyma palautti värin nro: " + vari);
        
        return vari;
    }

    @Override
    public void paivitaPelilauta() {
        System.out.println("GUI: paivitaPelilauta kutsuttu");
        
        //Teksti
        System.out.println();
        
        System.out.println("Pelilauta:");
        System.out.println(ruudukko.yksinkertainenString());

        System.out.println();

        for (Pelaaja p : pelaajat) {
            System.out.println("Pelaajan " + p.getPelaajaNro() + ". väri: " + p.getNykyinenVari() + ", alueen koko: " + p.getAlueenKoko() + "/" + ruudukko.getRuutujenMaara());
        }

        System.out.println();

        //Graafinen
        this.gui.paivitaPelilauta();
    }
    
    public boolean onkoValmisPelinAloitukseen() {
        System.out.println("GUI: onkoValmisPelinAloitukseen kutsuttu");
        return this.gui.onkoValmisPelinAloitukseen();
    }

    @Override
    public void julistaVoittaja(Pelaaja voittaja) {
        System.out.println("GUI: julistaVoittaja kutsuttu, pelaaja " + voittaja.getPelaajaNro() + " voitti");
    }

}
