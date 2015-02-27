package varivaltaus.varivaltaus.kayttoliittyma.teksti;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Tekstikäyttöliittymän käyttämä syötteiden lukija.
 */
public class Lukija {

    private final Scanner l;

    public Lukija() {
        this.l = new Scanner(System.in);
    }

    public Lukija(String syote) {
        this.l = new Scanner(syote);
    }

    public int lueIntSyote() {
        int luku;

        while (true) {
            try {
                luku = l.nextInt();
                return luku;
            } catch (InputMismatchException e) {
                String virheellinen = l.next();
                System.out.println("Syöte " + virheellinen + " ei ole kokonaisluku. Kokeile uudestaan: ");
            }
        }
    }
}
