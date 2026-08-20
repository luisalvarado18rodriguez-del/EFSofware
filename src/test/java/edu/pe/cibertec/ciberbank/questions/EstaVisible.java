package edu.pe.cibertec.ciberbank.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

/**
 * A diferencia de resolveFor(actor).isDisplayed(), isCurrentlyVisible() no lanza
 * excepción si el elemento no existe en el árbol: devuelve false. Es lo que se
 * necesita para verificar la AUSENCIA de una pantalla (p.ej. que el dashboard no
 * reaparezca tras el botón atrás) sin que la propia consulta falle primero.
 */
public class EstaVisible implements Question<Boolean> {

    private final Target elemento;

    public EstaVisible(Target elemento) {
        this.elemento = elemento;
    }

    public static EstaVisible el(Target elemento) {
        return new EstaVisible(elemento);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return elemento.resolveFor(actor).isCurrentlyVisible();
    }
}
