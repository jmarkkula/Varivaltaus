package varivaltaus.varivaltaus.pelilogiikka;

import java.util.ArrayList;

/**
 * Pelaaja-luokka hallinnoi pelaajan vallattua aluetta ja pelaajalle uusien
 * ruutujen valtaamista.
 */
public class Pelaaja {

    private int nykyinenVari;
    private final ArrayList<Ruutu> alue;
    private final int pelaajaNro;

    /**
     * Luo uuden pelaajan.
     *
     * @param pelaajaNro Pelaajan pelaajanumero, ikäänkuin id.
     * @param aloitusVari Minkä värinen pelaajan alue on aluksi.
     */
    public Pelaaja(int pelaajaNro, int aloitusVari) {
        this.alue = new ArrayList<>();
        this.nykyinenVari = aloitusVari;
        this.pelaajaNro = pelaajaNro;
    }

    /**
     * Vaihtaa pelaajan alueen väriä.
     *
     * @param uusiVari
     */
    public void vaihdaVari(int uusiVari) {
        this.nykyinenVari = uusiVari;

        for (Ruutu r : this.alue) {
            r.setVari(uusiVari);
        }
    }

    /**
     * Valtaa pelaajalle annetun ruudun, ellei se ole jo vallattu kyseisen tai
     * jonkun muun pelaajan toimesta.
     *
     * @param r Ruutu, joka halutaan vallata.
     * @return True jos ruutu on nyt vallattu pelaajalle, false jos se oli jo
     * vallattu.
     */
    public boolean valtaaRuutu(Ruutu r) {
        boolean onnistui = r.merkitseVallatuksi(this);

        if (onnistui) {
            this.alue.add(r);
        }

        return onnistui;
    }

    /**
     * @return Pelaajan alueen nykyinen väri.
     */
    public int getNykyinenVari() {
        return nykyinenVari;
    }

    /**
     * Palauttaa listan pelaajan alueeseen kuuluvista ruuduista. Lista on kopio
     * pelaajan itse hallinnoimasta listasta, eikä sen muokkaaminen siis vaikuta
     * pelaajan omaan listaan. Listan sisältämien ruutujen muokkaaminen tosin
     * vaikuttaisi suoraan pelin ruutuihin.
     *
     * @return Pelaajan alueen ruudut
     */
    public ArrayList<Ruutu> getListaAlueesta() {
        return (ArrayList<Ruutu>) this.alue.clone();
    }

    /**
     * @return Pelaajan pelaajanumero.
     */
    public int getPelaajaNro() {
        return pelaajaNro;
    }

    /**
     * @return Montako ruutua pelaajan alueeseen kuuluu.
     */
    public int getAlueenKoko() {
        return this.alue.size();
    }

    @Override
    public String toString() {
        return "[" + pelaajaNro + "," + nykyinenVari + "]";
    }

}
