
package varivaltaus.varivaltaus.pelilogiikka;

import java.util.ArrayList;

/**
 *
 * @author juma
 */
public class Pelaaja {
    private int nykyinenVari;
    private ArrayList<Ruutu> alue;
    private int pelaajaNro;
    
    public Pelaaja(int pelaajaNro, int aloitusVari, ArrayList<Ruutu> alue) {
        this.alue=alue;
        this.nykyinenVari=aloitusVari;
        this.pelaajaNro=pelaajaNro;
    }
    
    
}
