package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage{

    public LoginFormPage(WebDriver navegador) {
        super(navegador);
    }

    public LoginFormPage digitarLogin(String login){
        navegador.findElement(By.name("username")).findElement(By.name("username")).sendKeys(login);

        return this;
    }


    public LoginFormPage digitarSenha(String password){
        navegador.findElement(By.name("password")).findElement(By.name("password")).sendKeys(password);

        return this;
    }

    public SecretaPage ClicarSignIn(){
        navegador.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        return new SecretaPage(navegador);
    }

    public SecretaPage fazerLogin(String login, String senha){
        digitarLogin(login);
        digitarSenha(senha);
        ClicarSignIn();

        return new SecretaPage(navegador);
    }
}
