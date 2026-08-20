package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.MovimientosScreen;
import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;

/**
 * La lista de movimientos carga 15 registros más cada vez que el scroll llega al final
 * de lo YA cargado (paginación infinita). Se usa UiScrollable.scrollForward() — un solo
 * swipe de página — en vez de scrollToEnd(), que sigue haciendo swipe hasta el final
 * físico real de la lista y dispara varias cargas seguidas (15→30→32 de un tirón),
 * saltándose el estado intermedio que valida el escenario.
 */
public class DesplazarLista implements Task {

    public static DesplazarLista hastaElFinal() {
        return new DesplazarLista();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        if (driver instanceof WebDriverFacade) {
            driver = ((WebDriverFacade) driver).getProxiedDriver();
        }
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"" + MovimientosScreen.ID_LISTA + "\"))"
                        + ".scrollForward()"
        ));
    }
}
