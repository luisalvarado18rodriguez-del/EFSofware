package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.DashboardScreen;
import edu.pe.cibertec.ciberbank.userinterface.LoginScreen;
import edu.pe.cibertec.ciberbank.userinterface.PerfilScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CerrarSesion implements Task {

    public static CerrarSesion desdeElMenu() {
        return new CerrarSesion();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DashboardScreen.BOTON_MENU),
                WaitUntil.the(DashboardScreen.BOTON_NAV_PERFIL, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(DashboardScreen.BOTON_NAV_PERFIL),
                WaitUntil.the(PerfilScreen.BOTON_CERRAR_SESION, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(PerfilScreen.BOTON_CERRAR_SESION),
                WaitUntil.the(LoginScreen.CAMPO_USUARIO, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}
