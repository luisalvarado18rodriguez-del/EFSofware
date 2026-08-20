package edu.pe.cibertec.ciberbank.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;

/**
 * driver.navigate().back() en Appium/UiAutomator2 dispara el botón atrás físico de
 * Android, no el historial del navegador. Sirve para comprobar que, tras cerrar
 * sesión, el back stack no deja reingresar a pantallas protegidas.
 */
public class PresionarBotonAtras implements Task {

    public static PresionarBotonAtras delSistema() {
        return new PresionarBotonAtras();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        if (driver instanceof WebDriverFacade) {
            driver = ((WebDriverFacade) driver).getProxiedDriver();
        }
        driver.navigate().back();
    }
}
