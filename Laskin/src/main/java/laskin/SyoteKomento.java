/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import java.util.Stack;

/**
 *
 * @author Vertti
 */
public abstract class SyoteKomento extends Komento{
    Stack<Integer> arvot = new Stack<>();
    
    protected int saaArvo(){
        int arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        arvot.push(arvo);
        return arvo;
    }
    
    protected int saaPeruttuArvo(){
        return arvot.pop();
    }
}
