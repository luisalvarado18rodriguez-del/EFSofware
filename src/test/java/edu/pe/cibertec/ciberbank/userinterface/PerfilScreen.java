package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/** Locators del menú de perfil / cierre de sesión, accesible desde el menú lateral del dashboard. */
public class PerfilScreen {

    private static final String PAQUETE = "edu.pe.cibertec.ciberbank:id/";

    private PerfilScreen() {
    }

    public static final Target BOTON_CERRAR_SESION =
            Target.the("botón Cerrar sesión").located(By.id(PAQUETE + "btn_cerrar_sesion"));
}
