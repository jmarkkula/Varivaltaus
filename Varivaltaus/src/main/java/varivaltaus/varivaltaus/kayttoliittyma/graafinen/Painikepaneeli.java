/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varivaltaus.varivaltaus.kayttoliittyma.graafinen;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import varivaltaus.varivaltaus.pelilogiikka.Ruudukko;

/**
 *
 * @author juma
 */
public class Painikepaneeli extends JPanel {

    private final HashMap<Integer, Varipainike> varipainikkeet;
    private final VaripainikeKuuntelija kuuntelija;

    public Painikepaneeli(Ruudukko r, Varit v) {
        setLayout(new GridLayout(1, r.getVariLkm() - 2));
        
        this.kuuntelija = new VaripainikeKuuntelija();
        
        this.varipainikkeet = new HashMap<>();

        for (int i = 1; i <= r.getVariLkm(); i++) {
            Varipainike uusi = new Varipainike(i, v);
            uusi.addActionListener(kuuntelija);
            
            this.varipainikkeet.put(i, uusi);
            this.add(uusi);
        }

    }

    public int kysyVari(List<Integer> varivaihtoehdot) {

        this.removeAll();

        for (int vari : varivaihtoehdot) {
            this.add(varipainikkeet.get(vari));
        }

        this.revalidate();
        this.repaint();
        
        while(!this.kuuntelija.onkoPainettu()) {
            
        }

        return 1; //VAIHDA LOPUKSI
    }

}
