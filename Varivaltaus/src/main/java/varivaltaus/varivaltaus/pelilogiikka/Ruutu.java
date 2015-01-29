package varivaltaus.varivaltaus.pelilogiikka;


/**
 *
 * @author juma
 */
public class Ruutu {

    private int vari;
    private boolean vallattu;
    private Pelaaja valtaaja;
    private final int x;
    private final int y;

    public Ruutu(int vari, int x, int y) {
        this.vari = vari;
        this.vallattu = false;
        this.valtaaja = null;
        this.x=x;
        this.y=y;
    }

    public boolean merkitseVallatuksi(Pelaaja p) {
        if (this.vallattu) {
            return false;
        }

        this.valtaaja = p;
        this.vallattu = true;

        return true;
    }

    public int getVari() {
        return this.vari;
    }
    
    public void setVari(int vari) {
        this.vari=vari;
    }

    public boolean isVallattu() {
        return this.vallattu;
    }

    public Pelaaja getValtaaja() {
        return this.valtaaja;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public String yksinkertainenString() {
        if(this.isVallattu()) {
            return "[*" + this.vari + "*]";
        }
        
        return "[ " + this.vari + " ]";
    }

    @Override
    public String toString() {
        return "[" + this.vari + "," + this.vallattu + "," + this.valtaaja + "]";
    }

}
