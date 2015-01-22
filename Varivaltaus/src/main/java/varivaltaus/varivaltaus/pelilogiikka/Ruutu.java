package varivaltaus.varivaltaus.pelilogiikka;


/**
 *
 * @author juma
 */
public class Ruutu {

    private int vari;
    private boolean vallattu;
    private Pelaaja valtaaja;

    public Ruutu(int vari) {
        this.vari = vari;
        this.vallattu = false;
        this.valtaaja = null;
    }

    public boolean valtaa(Pelaaja p, int vari) {
        if (this.vallattu) {
            return false;
        }

        this.vari = vari;
        this.valtaaja = p;
        this.vallattu = true;

        return true;
    }

    public int getVari() {
        return vari;
    }

    public boolean isVallattu() {
        return vallattu;
    }

    public Pelaaja getValtaaja() {
        return valtaaja;
    }

    @Override
    public String toString() {
        return "[" + vari + "," + vallattu + "," + valtaaja + "]";
    }

}
