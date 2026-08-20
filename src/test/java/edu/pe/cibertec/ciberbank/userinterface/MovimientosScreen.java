package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/** Locators de la pantalla de movimientos. */
public class MovimientosScreen {

    private static final String PAQUETE = "edu.pe.cibertec.ciberbank:id/";

    private MovimientosScreen() {
    }

    /** Se expone como String (no solo como Target) porque UiScrollable necesita el resource-id crudo. */
    public static final String ID_LISTA = PAQUETE + "lst_movimientos";

    public static final Target LISTA =
            Target.the("lista de movimientos").located(By.id(ID_LISTA));

    public static final Target CONTADOR =
            Target.the("contador de movimientos mostrados").located(By.id(PAQUETE + "lbl_total_movimientos"));
}
