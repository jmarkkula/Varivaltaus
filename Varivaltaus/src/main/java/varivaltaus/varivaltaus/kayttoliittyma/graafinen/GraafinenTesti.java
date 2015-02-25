
package varivaltaus.varivaltaus.kayttoliittyma.graafinen;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;
import javax.swing.*;
import varivaltaus.varivaltaus.kayttoliittyma.Kayttoliittyma;
import varivaltaus.varivaltaus.pelilogiikka.Pelaaja;
import varivaltaus.varivaltaus.pelilogiikka.Ruudukko;

/**
 *
 * @author juma
 */
public class GraafinenTesti implements Kayttoliittyma, Runnable {

    private final Ruudukko ruudukko;
    private final Varit varit;
    private JFrame frame;
    private Pelilauta pelilauta;
    private Painikepaneeli painikepaneeli;
    private final LinkedList<Pelaaja> pelaajat;
    private Statuspaneeli statuspaneeli;

    public GraafinenTesti(Ruudukko r, LinkedList<Pelaaja> p) {
        System.out.println("GUI: GraafinenTesti-olion luonti kutsuttu");
        
        this.ruudukko = r;
        this.varit = new Varit();
        this.pelaajat = p;
    }

    @Override
    public void run() {
        System.out.println("GUI: run kutsuttu");
        
        frame = new JFrame("Värivaltaus");
        frame.setPreferredSize(new Dimension(this.ruudukko.getLeveys() * 100, this.ruudukko.getKorkeus() * 100));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container contentPane) {
        System.out.println("GUI: luoKomponentit kutsuttu");
        
        contentPane.setLayout(new BorderLayout());

        this.pelilauta = new Pelilauta(this.ruudukko, this.varit);
        contentPane.add(this.pelilauta);

        JPanel paneelit = new JPanel(new GridLayout(2, 1));
        
        this.painikepaneeli = new Painikepaneeli(this.ruudukko, this.varit);
        paneelit.add(this.painikepaneeli);
        
        this.statuspaneeli = new Statuspaneeli(this.ruudukko, this.pelaajat, this.varit);
        paneelit.add(this.statuspaneeli);
        
        contentPane.add(paneelit, BorderLayout.SOUTH);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getPelilauta() {
        return this.pelilauta;
    }

    @Override
    public int kysyVari(List<Integer> varivaihtoehdot, Pelaaja keneltaKysytaan) {
        System.out.println("GUI: kysyVari kutsuttu");

        //Graafinen
        this.statuspaneeli.kysyVari(keneltaKysytaan);
        int vari = this.painikepaneeli.kysyVari(varivaihtoehdot);
        System.out.println("GUI: valittiin väri nro " + vari);
        this.statuspaneeli.nollaaTeksti(keneltaKysytaan);
        
        return vari;
    }

    @Override
    public void paivitaPelilauta() {
        System.out.println("GUI: paivitaPelilauta kutsuttu");
        
        //Teksti
        System.out.println("Pelilauta:");
        System.out.println(ruudukko.yksinkertainenString());

        System.out.println();

        for (Pelaaja p : pelaajat) {
            System.out.println("Pelaajan " + p.getPelaajaNro() + ". väri: " + p.getNykyinenVari() + ", alueen koko: " + p.getAlueenKoko() + "/" + ruudukko.getRuutujenMaara());
        }

        System.out.println();

        //Graafinen
        frame.revalidate();
        frame.repaint();
    }
    
    public boolean onkoValmisPelinAloitukseen() {
        return this.pelilauta!=null && this.painikepaneeli!=null && this.statuspaneeli!=null;
    }

    @Override
    public void julistaVoittaja(Pelaaja voittaja) {
        System.out.println("GUI: julistaVoittaja kutsuttu");
        
        //Teksti
        System.out.println("Pelaaja " + voittaja.getPelaajaNro() + ". on voittanut!");
    }

}
