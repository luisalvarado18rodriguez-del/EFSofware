package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/** Locators de la pantalla de transferencia a beneficiarios. */
public class TransferenciaScreen {

    private static final String PAQUETE = "edu.pe.cibertec.ciberbank:id/";

    private TransferenciaScreen() {
    }

    public static final Target SPINNER_BENEFICIARIO =
            Target.the("desplegable de beneficiario").located(By.id(PAQUETE + "spn_beneficiario"));

    public static final Target CAMPO_MONTO =
            Target.the("campo Monto").located(By.id(PAQUETE + "inp_monto"));

    public static final Target BOTON_CONTINUAR =
            Target.the("botón Continuar").located(By.id(PAQUETE + "btn_continuar"));

    /** Botón de la pantalla de resumen (pantalla_confirmacion), previo al diálogo nativo. */
    public static final Target BOTON_CONFIRMAR =
            Target.the("botón Confirmar del resumen").located(By.id(PAQUETE + "btn_confirmar"));

    public static final Target ERROR_TRANSFERENCIA =
            Target.the("mensaje de error de la transferencia").located(By.id(PAQUETE + "err_transferencia"));

    public static final Target NUMERO_OPERACION =
            Target.the("número de operación generado").located(By.id(PAQUETE + "lbl_numero_operacion"));

    public static final Target SALDO_ACTUALIZADO =
            Target.the("saldo actualizado tras la transferencia").located(By.id(PAQUETE + "lbl_saldo_actualizado"));

    /**
     * Las opciones del spinner muestran "Nombre - Banco" (p.ej. "Luis Ramos - Interbank"),
     * no solo el nombre, por eso se usa contains() en vez de una igualdad exacta.
     */
    public static Target opcionDelDesplegable(String opcion) {
        return Target.the("opción: " + opcion)
                .located(By.xpath("//android.widget.TextView[@resource-id='" + PAQUETE + "lbl_spinner_opcion' and contains(@text,'" + opcion + "')]"));
    }
}
