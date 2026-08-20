package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.DashboardScreen;
import edu.pe.cibertec.ciberbank.userinterface.MovimientosScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AbrirMovimientos implements Task {

    public static AbrirMovimientos desdeElDashboard() {
        return new AbrirMovimientos();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DashboardScreen.BOTON_MOVIMIENTOS),
                WaitUntil.the(MovimientosScreen.LISTA, isVisible()).forNoMoreThan(30).seconds()
        );
    }
}
