/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vertti
 */
public class Querybuilder {

    List<Matcher> matchers;

    public Querybuilder(){
        this.matchers = new ArrayList<>();
    }
    
    public Querybuilder playsIn(String team){
        matchers.add(new PlaysIn(team));
        return this;
    }
    
    public Querybuilder hasAtLeast(int amount, String category){
        matchers.add(new HasAtLeast(amount, category));
        return this;
    }
    
    public Querybuilder not(Matcher matcher){
        matchers.add(new Not(matcher));
        return this;
    }
    
    public Querybuilder hasFewerThan(int amount, String category){
        matchers.add(new HasFewerThan(amount, category));
        return this;
    }
    
    public Querybuilder oneOf(Matcher... matchers){
        this.matchers.add(new Or(matchers));
        return this;
    }
    
    public Matcher build() {
        matchers.add(new All());
        Matcher and = new And(matchers.toArray(new Matcher[matchers.size()]));
        matchers.clear();
        return and;
    }

}
