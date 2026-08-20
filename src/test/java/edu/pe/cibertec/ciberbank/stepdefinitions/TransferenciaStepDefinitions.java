package edu.pe.cibertec.ciberbank.stepdefinitions;

import edu.pe.cibertec.ciberbank.questions.TextoDe;
import edu.pe.cibertec.ciberbank.tasks.AceptarConfirmacion;
import edu.pe.cibertec.ciberbank.tasks.EsperarLaPantallaDeLogin;
import edu.pe.cibertec.ciberbank.tasks.IniciarSesion;
import edu.pe.cibertec.ciberbank.tasks.Transferir;
import edu.pe.cibertec.ciberbank.userinterface.TransferenciaScreen;
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

import java.math.BigDecimal;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TransferenciaStepDefinitions {

    /** Todos los usuarios de prueba comparten la misma contraseña (ver README.md). */
    private static final String CLAVE = "Cibertec123";

    @Before
    public void preparaEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void cierraEscenario() {
        OnStage.drawTheCurtain();
    }

    @Dado("que {word} inició sesión con el usuario {string}")
    public void que_inicio_sesion_con_el_usuario(String actor, String usuario) {
        theActorCalled(actor).attemptsTo(
                EsperarLaPantallaDeLogin.queSeMuestre(),
                IniciarSesion.con(usuario, CLAVE)
        );
    }

    @Cuando("transfiere {bigdecimal} al beneficiario {string}")
    public void transfiere_al_beneficiario(BigDecimal monto, String beneficiario) {
        theActorInTheSpotlight().attemptsTo(
                Transferir.deMonto(monto, beneficiario)
        );
    }

    @Cuando("intenta transferir {bigdecimal} al beneficiario {string}")
    public void intenta_transferir_al_beneficiario(BigDecimal monto, String beneficiario) {
        theActorInTheSpotlight().attemptsTo(
                Transferir.deMonto(monto, beneficiario)
        );
    }

    @Y("acepta el diálogo de confirmación")
    public void acepta_el_dialogo_de_confirmacion() {
        theActorInTheSpotlight().attemptsTo(
                AceptarConfirmacion.delDialogo()
        );
    }

    @Entonces("debería ver un número de operación generado")
    public void deberia_ver_un_numero_de_operacion_generado() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(TransferenciaScreen.NUMERO_OPERACION, isVisible()).forNoMoreThan(10).seconds(),
                Ensure.that(TextoDe.el(TransferenciaScreen.NUMERO_OPERACION)).isNotBlank()
        );
    }

    @Y("el saldo debería quedar en {string}")
    public void el_saldo_deberia_quedar_en(String saldo) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(TransferenciaScreen.SALDO_ACTUALIZADO, isVisible()).forNoMoreThan(10).seconds(),
                Ensure.that(TextoDe.el(TransferenciaScreen.SALDO_ACTUALIZADO)).isEqualTo(saldo)
        );
    }

    @Entonces("debería ver el mensaje de error de la transferencia {string}")
    public void deberia_ver_el_mensaje_de_error_de_la_transferencia(String mensaje) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(TransferenciaScreen.ERROR_TRANSFERENCIA, isVisible()).forNoMoreThan(10).seconds(),
                Ensure.that(TextoDe.el(TransferenciaScreen.ERROR_TRANSFERENCIA)).isEqualTo(mensaje)
        );
    }
}
