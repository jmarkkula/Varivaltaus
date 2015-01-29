/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varivaltaus.varivaltaus.kayttoliittyma.teksti;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author juma
 */
public class Lukija {

    private final Scanner l;

    public Lukija() {
        this.l = new Scanner(System.in);
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
