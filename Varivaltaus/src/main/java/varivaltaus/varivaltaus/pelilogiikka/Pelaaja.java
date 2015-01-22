package varivaltaus.varivaltaus.pelilogiikka;

import java.util.ArrayList;

/**
 *
 * @author juma
 */
public class Pelaaja {

    private int nykyinenVari;
    private final ArrayList<Ruutu> alue;
    private final int pelaajaNro;

    public Pelaaja(int pelaajaNro, int aloitusVari) {
        this.alue = new ArrayList<>();
        this.nykyinenVari = aloitusVari;
        this.pelaajaNro = pelaajaNro;
    }

    public int getNykyinenVari() {
        return nykyinenVari;
    }

    public ArrayList<Ruutu> getAlue() {
        return alue;
    }

    public int getPelaajaNro() {
        return pelaajaNro;
    }

    @Override
    public String toString() {
        return "[" + pelaajaNro + "," + nykyinenVari + "]";
    }
    
    

}
