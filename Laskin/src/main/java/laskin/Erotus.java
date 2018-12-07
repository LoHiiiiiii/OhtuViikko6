/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author Vertti
 */
public class Erotus extends SyoteKomento {

    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Sovelluslogiikka sovellus){
        Init(tuloskentta, syotekentta, nollaa, sovellus);
    }
    
    @Override
    public void suorita() {
        sovellus.miinus(saaArvo());
        asetaTulos();
    }
    
    @Override
    public void peru() {
        sovellus.plus(saaPeruttuArvo());
        asetaTulos();
    }
}
