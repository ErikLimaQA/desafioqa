package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class mePage extends BasePage {

    public mePage(WebDriver navegador) {
        super(navegador);
    }

    public mePage clicarAbaMoreDataAboutYou() {
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        return this;
    }

    public AddContactPage clicarBotaoAddMoreDataAboutYou(){
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

    return new AddContactPage(navegador);
    }
}
