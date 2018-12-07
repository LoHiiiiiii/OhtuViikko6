package laskin;

import java.util.Map;
import java.util.HashMap;
import java.util.Stack;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Tapahtumankuuntelija implements EventHandler {

    private TextField tuloskentta;
    private TextField syotekentta;

    private Map<Button, Komento> komennot;
    Stack<Komento> suoritetut;

    private Button undo;
    private Sovelluslogiikka sovellus;

    public Tapahtumankuuntelija(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.undo = undo;
        this.sovellus = new Sovelluslogiikka();
        komennot = new HashMap<>();
        suoritetut = new Stack<>();
        komennot.put(plus, new Summa(tuloskentta, syotekentta,  nollaa, sovellus) );
        komennot.put(miinus, new Erotus(tuloskentta, syotekentta, nollaa, sovellus) );
        komennot.put(nollaa, new Nollaa(tuloskentta, syotekentta,  nollaa, sovellus) );
    }

    @Override
    public void handle(Event event) {
        if (event.getTarget() != undo) {
            Komento komento = komennot.get((Button) event.getTarget());
            komento.suorita();
            suoritetut.push(komento);
        } else {
            suoritetut.pop().peru();
        }
        if (suoritetut.isEmpty())
            undo.disableProperty().set(true);
        else
            undo.disableProperty().set(false);
    }

}
