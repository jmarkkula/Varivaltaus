package varivaltaus.varivaltaus.pelilogiikka;

import java.util.ArrayList;

/**
 *
 * @author juma
 */
public class Ruudukko {

    private final Ruutu[][] ruudut;
    private final int variLkm;
    private Satunnaistaja s;

    public Ruudukko(int leveys, int korkeus, int variLkm) {
        this.variLkm = variLkm;
        this.ruudut = new Ruutu[korkeus][leveys];
        this.s = new Satunnaistaja();
        luoRuudut();
    }

    private void luoRuudut() {
        for (int y = 0; y < this.ruudut.length; y++) {
            for (int x = 0; x < this.ruudut[0].length; x++) {
                Ruutu r = new Ruutu(this.s.satunnaisLuku(variLkm), x, y);
                this.setRuutu(x, y, r);
            }
        }

        if (this.ruudut[0][0].getVari() == this.ruudut[this.getKorkeus() - 1][this.getLeveys() - 1].getVari()) {
            int uusiVari = this.ruudut[0][0].getVari() + 1;
            if (uusiVari > variLkm) {
                uusiVari = 1;
            }
            this.ruudut[0][0].setVari(uusiVari);
        }
    }

    public Ruutu getRuutu(int x, int y) {
        return this.ruudut[y][x];
    }

    public ArrayList<Ruutu> getViereisetRuudut(int x, int y) {
        ArrayList<Ruutu> viereiset = new ArrayList<>();

        if (x > 0) {
            viereiset.add(this.getRuutu(x - 1, y));
        }

        if (x < this.getLeveys() - 1) {
            viereiset.add(this.getRuutu(x + 1, y));
        }

        if (y > 0) {
            viereiset.add(this.getRuutu(x, y - 1));
        }

        if (y < this.getKorkeus() - 1) {
            viereiset.add(this.getRuutu(x, y + 1));
        }

        return viereiset;
    }

    public boolean setRuutu(int x, int y, Ruutu r) {
        if (this.ruudut[y][x] != null) {
            return false;
        }
        this.ruudut[y][x] = r;
        return true;
    }

    public int getLeveys() {
        return this.ruudut[0].length;
    }

    public int getKorkeus() {
        return this.ruudut.length;
    }

    public int getRuutujenMaara() {
        return this.ruudut.length * this.ruudut[0].length;
    }

    public int getVariLkm() {
        return this.variLkm;
    }

    public String yksinkertainenString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < this.ruudut.length; y++) {
            for (int x = 0; x < this.ruudut[0].length; x++) {
                sb.append(this.ruudut[y][x].yksinkertainenString());
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < this.ruudut.length; y++) {
            for (int x = 0; x < this.ruudut[0].length; x++) {
                sb.append(this.ruudut[y][x]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
