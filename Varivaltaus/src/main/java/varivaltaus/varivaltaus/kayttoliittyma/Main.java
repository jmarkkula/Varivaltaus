package varivaltaus.varivaltaus.kayttoliittyma;


import varivaltaus.varivaltaus.pelilogiikka.Pelinalustaja;


/**
 *
 * @author juma
 */


public class Main {

    public static void main(String[] args) {
        Pelinalustaja pa = new Pelinalustaja(30, 20, 5);
        
        System.out.println("Peliruudukko: ['väri', onko vallattu, kuka vallannut]");
        System.out.println(pa.getRuudukko());
       
    }
}
