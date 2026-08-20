package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.ConfirmacionScreen;
import edu.pe.cibertec.ciberbank.userinterface.TransferenciaScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * Tras pulsar Continuar en el formulario de transferencia, la app navega primero a una
 * pantalla de resumen (btn_confirmar) y solo después de confirmarla aparece el diálogo
 * nativo de Android (android:id/button1). Este Task cubre ambos pasos.
 */
public class AceptarConfirmacion implements Task {

    public static AceptarConfirmacion delDialogo() {
        return new AceptarConfirmacion();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TransferenciaScreen.BOTON_CONFIRMAR, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(TransferenciaScreen.BOTON_CONFIRMAR),
                WaitUntil.the(ConfirmacionScreen.BOTON_ACEPTAR, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(ConfirmacionScreen.BOTON_ACEPTAR)
        );
    }
}
