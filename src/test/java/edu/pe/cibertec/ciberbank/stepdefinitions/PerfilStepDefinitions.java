package edu.pe.cibertec.ciberbank.stepdefinitions;

import edu.pe.cibertec.ciberbank.questions.EstaVisible;
import edu.pe.cibertec.ciberbank.tasks.CerrarSesion;
import edu.pe.cibertec.ciberbank.tasks.PresionarBotonAtras;
import edu.pe.cibertec.ciberbank.userinterface.DashboardScreen;
import edu.pe.cibertec.ciberbank.userinterface.LoginScreen;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PerfilStepDefinitions {

    @Before
    public void preparaEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void cierraEscenario() {
        OnStage.drawTheCurtain();
    }

    @Cuando("cierra sesión")
    public void cierra_sesion() {
        theActorInTheSpotlight().attemptsTo(
                CerrarSesion.desdeElMenu()
        );
    }

    @Entonces("debería ver la pantalla de login")
    public void deberia_ver_la_pantalla_de_login() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(EstaVisible.el(LoginScreen.CAMPO_USUARIO)).isTrue()
        );
    }

    @Cuando("presiona el botón atrás del sistema")
    public void presiona_el_boton_atras_del_sistema() {
        theActorInTheSpotlight().attemptsTo(
                PresionarBotonAtras.delSistema()
        );
    }

    @Entonces("no debería reingresar al dashboard")
    public void no_deberia_reingresar_al_dashboard() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(EstaVisible.el(DashboardScreen.SALUDO)).isFalse()
        );
    }
}
