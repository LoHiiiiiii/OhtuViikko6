/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import java.util.Stack;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author Vertti
 */
public class Nollaa extends Komento {
    Stack<Integer> tulokset = new Stack<>();
    
    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Sovelluslogiikka sovellus){
        Init(tuloskentta, syotekentta, nollaa, sovellus);
    }
    
    @Override
    public void suorita() {
        int tulos = 0;
        try {
            tulos = sovellus.tulos();
        } catch (Exception e) {
        }
        tulokset.push(tulos);
        sovellus.nollaa();
        asetaTulos();
    }
    
    @Override
    public void peru() {
        sovellus.aseta(tulokset.pop());
        asetaTulos();
    }
}
