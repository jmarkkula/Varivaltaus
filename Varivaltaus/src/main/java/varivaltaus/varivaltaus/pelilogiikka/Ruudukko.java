package varivaltaus.varivaltaus.pelilogiikka;

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
                Ruutu r = new Ruutu(this.s.satunnaisLuku(variLkm));
                this.setRuutu(x, y, r);
            }
        }
    }

    public Ruutu getRuutu(int x, int y) {
        return this.ruudut[y][x];
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
