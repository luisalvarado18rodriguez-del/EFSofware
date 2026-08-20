package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Diálogo nativo de Android (AlertDialog) que confirma operaciones sensibles, como una
 * transferencia. Sus botones no tienen resource-id de la app: Android los expone con los
 * ids estándar del sistema (android:id/button1 y android:id/button2).
 */
public class ConfirmacionScreen {

    private ConfirmacionScreen() {
    }

    public static final Target BOTON_ACEPTAR =
            Target.the("botón Aceptar del diálogo").located(By.id("android:id/button1"));

    public static final Target BOTON_CANCELAR =
            Target.the("botón Cancelar del diálogo").located(By.id("android:id/button2"));
}
