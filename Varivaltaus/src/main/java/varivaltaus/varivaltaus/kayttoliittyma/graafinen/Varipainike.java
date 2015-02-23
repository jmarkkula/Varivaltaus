/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varivaltaus.varivaltaus.kayttoliittyma.graafinen;

import javax.swing.JButton;

/**
 *
 * @author juma
 */
public class Varipainike extends JButton{
    private final int vari;
    private final Varit varit;
    
    public Varipainike(int vari, Varit varit) {
        this.vari=vari;
        this.varit=varit;
        this.setBackground(this.varit.getVari(vari));
        
        //nappien koon määritys tässä vai paneelissa
    }
    
    public int getVari() {
        return this.vari;
    }
}
