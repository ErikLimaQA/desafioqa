package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecretaPage extends BasePage {

    public SecretaPage(WebDriver navegador) {
        super(navegador);
    }
    public mePage clicarME(){
        navegador.findElement(By.className("me")).click();

        return new mePage(navegador);
    }
}
