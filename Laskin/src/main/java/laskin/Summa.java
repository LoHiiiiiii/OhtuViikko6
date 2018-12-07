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
public class Summa extends SyoteKomento {

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Sovelluslogiikka sovellus){
        Init(tuloskentta, syotekentta, nollaa, sovellus);
    }
    
    @Override
    public void suorita() {
        sovellus.plus(saaArvo());
        asetaTulos();
    }
    
    public Summa(){
        
    }
    
    @Override
    public void peru() {
        sovellus.miinus(saaPeruttuArvo());
        asetaTulos();
    }
}
