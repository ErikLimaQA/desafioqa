package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver navegador) {
        super(navegador);
    }
    public LoginFormPage clicarSignIn() {
    navegador.findElement(By.xpath("//button[@type=\"submit\"]")).click();

    return new LoginFormPage(navegador);
    }
}

