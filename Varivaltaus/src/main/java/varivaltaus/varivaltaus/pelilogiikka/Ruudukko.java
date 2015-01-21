
package varivaltaus.varivaltaus.pelilogiikka;

/**
 *
 * @author juma
 */
public class Ruudukko {
    private Ruutu[][] ruudut;
    
    public Ruudukko(int x, int y) {
        this.ruudut = new Ruutu[x][y];
    }

    public Ruutu getRuutu(int x, int y) {
        return ruudut[x][y];
    }
    
    public boolean setRuutu(int x, int y, Ruutu r) {
        ruudut[x][y] = r;
        return true;
    }
}
