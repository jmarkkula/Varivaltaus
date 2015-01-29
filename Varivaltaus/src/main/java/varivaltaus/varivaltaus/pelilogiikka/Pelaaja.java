package varivaltaus.varivaltaus.pelilogiikka;

import java.util.ArrayList;

/**
 *
 * @author juma
 */
public class Pelaaja{

    private int nykyinenVari;
    private final ArrayList<Ruutu> alue;
    private final int pelaajaNro;

    public Pelaaja(int pelaajaNro, int aloitusVari) {
        this.alue = new ArrayList<>();
        this.nykyinenVari = aloitusVari;
        this.pelaajaNro = pelaajaNro;
    }

    public void vaihdaVari(int uusiVari) {
        this.nykyinenVari = uusiVari;

        for (Ruutu r : this.alue) {
            r.setVari(uusiVari);
        }
    }

    public boolean valtaaRuutu(Ruutu r) {
        boolean onnistui = r.merkitseVallatuksi(this);

        if (onnistui) {
            this.alue.add(r);
        }

        return onnistui;
    }

    public int getNykyinenVari() {
        return nykyinenVari;
    }
  
    public ArrayList<Ruutu> getListaAlueesta() {
        return (ArrayList<Ruutu>) this.alue.clone();
    }
    
    public int getPelaajaNro() {
        return pelaajaNro;
    }

    public int getAlueenKoko() {
        return this.alue.size();
    }

    @Override
    public String toString() {
        return "[" + pelaajaNro + "," + nykyinenVari + "]";
    }


}
