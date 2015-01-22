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

    public boolean valtaaRuutu(Ruutu r) {
        boolean onnistui = r.valtaa(this, this.nykyinenVari);
        
        if(onnistui) {
            this.alue.add(r);
        }
        
        return onnistui;
    }
    
    public int getNykyinenVari() {
        return nykyinenVari;
    }

// ehkä parempi jos ei pääse muualta sotkemaan?    
//    public ArrayList<Ruutu> getAlue() {
//        return alue;
//    }

    public int getPelaajaNro() {
        return pelaajaNro;
    }
    
    

    @Override
    public String toString() {
        return "[" + pelaajaNro + "," + nykyinenVari + "]";
    }
    
    

}
