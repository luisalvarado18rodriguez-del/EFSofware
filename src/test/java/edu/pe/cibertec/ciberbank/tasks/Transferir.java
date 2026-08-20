package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.DashboardScreen;
import edu.pe.cibertec.ciberbank.userinterface.TransferenciaScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.math.BigDecimal;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * Abre la pantalla de transferencias desde el dashboard, elige al beneficiario del spinner,
 * ingresa el monto y pulsa Continuar. Si el monto es inválido la app queda en esta misma
 * pantalla mostrando err_transferencia; si es válido, navega a la pantalla de resumen
 * (pantalla_confirmacion), donde falta pulsar Confirmar para llegar al diálogo nativo.
 */
public class Transferir implements Task {

    private final BigDecimal monto;
    private final String beneficiario;

    public Transferir(BigDecimal monto, String beneficiario) {
        this.monto = monto;
        this.beneficiario = beneficiario;
    }

    public static Transferir deMonto(BigDecimal monto, String beneficiario) {
        return new Transferir(monto, beneficiario);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DashboardScreen.BOTON_TRANSFERENCIAS),
                WaitUntil.the(TransferenciaScreen.BOTON_CONTINUAR, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(TransferenciaScreen.SPINNER_BENEFICIARIO),
                WaitUntil.the(TransferenciaScreen.opcionDelDesplegable(beneficiario), isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(TransferenciaScreen.opcionDelDesplegable(beneficiario)),
                Clear.field(TransferenciaScreen.CAMPO_MONTO),
                Enter.theValue(monto.toPlainString()).into(TransferenciaScreen.CAMPO_MONTO),
                OcultarTeclado.siEstaAbierto(),
                Click.on(TransferenciaScreen.BOTON_CONTINUAR)
        );
    }
}
