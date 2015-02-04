package varivaltaus.varivaltaus.pelilogiikka;

/**
 * Peliruutu.
 */
public class Ruutu {

    private int vari;
    private boolean vallattu;
    private Pelaaja valtaaja;
    private final int x;
    private final int y;

    /**
     * Luo uuden ruudun.
     *
     * @param vari Mikä väriarvo ruudulle halutaan aluksi.
     * @param x X-koordinaatti, johon ruutu asetetaan aluksi.
     * @param y Y-koordinaatti, johon ruutu asetetaan aluksi.
     */
    public Ruutu(int vari, int x, int y) {
        this.vari = vari;
        this.vallattu = false;
        this.valtaaja = null;
        this.x = x;
        this.y = y;
    }

    /**
     * Merkitsee ruudun vallatuksi halutulle pelaajalle, jos sitä ei ole vielä
     * vallattu.
     *
     * @param p Pelaaja, joka valtaa ruudun.
     * @return True jos ruutu oli vapaa, false jos ruutu oli jo vallattu.
     */
    public boolean merkitseVallatuksi(Pelaaja p) {
        if (this.vallattu) {
            return false;
        }

        this.valtaaja = p;
        this.vallattu = true;

        return true;
    }

    /**
     * @return Ruudun nykyinen väriarvo.
     */
    public int getVari() {
        return this.vari;
    }

    /**
     * @param vari Ruudulle asetettava uusi väriarvo.
     */
    public void setVari(int vari) {
        this.vari = vari;
    }

    /**
     * @return True jos ruutu on vallattu, false jos ei ole vielä vallattu.
     */
    public boolean isVallattu() {
        return this.vallattu;
    }

    /**
     * @return Kenen pelaajan valtaama ruutu on, null jos ei vielä vallattu.
     */
    public Pelaaja getValtaaja() {
        return this.valtaaja;
    }

    /**
     * @return Missä x-koordinaatissa ruutu, tietääkseen, sijaitsee.
     */
    public int getX() {
        return this.x;
    }

    /**
     * @return Missä y-koordinaatissa ruutu, tietääkseen, sijaitsee.
     */
    public int getY() {
        return this.y;
    }

    /**
     * Vaihtoehto toStringille, yksinkertaisempi ulkoasu, sopii
     * tekstikäyttöliittymään.
     *
     * @return [värin numero], tai [*värin numero*] jos ruutu on vallattu
     */
    public String yksinkertainenString() {
        if (this.isVallattu()) {
            return "[*" + this.vari + "*]";
        }

        return "[ " + this.vari + " ]";
    }

    @Override
    public String toString() {
        return "[" + this.vari + "," + this.vallattu + "," + this.valtaaja + "]";
    }

}
