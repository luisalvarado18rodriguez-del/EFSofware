package edu.pe.cibertec.ciberbank.stepdefinitions;

import edu.pe.cibertec.ciberbank.questions.TextoDe;
import edu.pe.cibertec.ciberbank.tasks.EsperarLaPantallaDeLogin;
import edu.pe.cibertec.ciberbank.tasks.IniciarSesion;
import edu.pe.cibertec.ciberbank.userinterface.DashboardScreen;
import edu.pe.cibertec.ciberbank.userinterface.LoginScreen;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginStepDefinitions {

    @Before
    public void preparaEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void cierraEscenario() {
        OnStage.drawTheCurtain();
    }

    @Dado("que {word} está en la pantalla de login")
    public void que_esta_en_la_pantalla_de_login(String actor) {
        theActorCalled(actor).attemptsTo(
                EsperarLaPantallaDeLogin.queSeMuestre()
        );
    }

    @Cuando("ingresa el usuario {string} y la contraseña {string}")
    public void ingresa_el_usuario_y_la_contrasena(String usuario, String clave) {
        theActorInTheSpotlight().attemptsTo(
                IniciarSesion.con(usuario, clave)
        );
    }

    @Entonces("debería ver el saludo {string}")
    public void deberia_ver_el_saludo(String saludo) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(DashboardScreen.SALUDO, isVisible()).forNoMoreThan(10).seconds(),
                Ensure.that(TextoDe.el(DashboardScreen.SALUDO)).isEqualTo(saludo)
        );
    }

    @Y("el saldo mostrado debería ser {string}")
    public void el_saldo_mostrado_deberia_ser(String saldo) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(DashboardScreen.SALDO_PRINCIPAL, isVisible()).forNoMoreThan(10).seconds(),
                Ensure.that(TextoDe.el(DashboardScreen.SALDO_PRINCIPAL)).isEqualTo(saldo)
        );
    }

    @Entonces("debería ver el mensaje de error {string}")
    public void deberia_ver_el_mensaje_de_error(String mensaje) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(LoginScreen.ERROR_LOGIN, isVisible()).forNoMoreThan(10).seconds(),
                Ensure.that(TextoDe.el(LoginScreen.ERROR_LOGIN)).isEqualTo(mensaje)
        );
    }

    @Entonces("debería ver el error de campo usuario {string}")
    public void deberia_ver_el_error_de_campo_usuario(String mensaje) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(LoginScreen.ERROR_USUARIO, isVisible()).forNoMoreThan(10).seconds(),
                Ensure.that(TextoDe.el(LoginScreen.ERROR_USUARIO)).isEqualTo(mensaje)
        );
    }
}
