package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.ScreenShot;

import static org.junit.Assert.assertEquals;

public class listarClienteTest {
    private WebDriver navegador;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp() {
        //Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\erikl\\drivers\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(navegador, 10);


        //Acessando Site
        navegador.get("http://provaqa.marketpay.com.br:9089/desafioqa/login");
        navegador.findElement(By.name("username")).sendKeys("admin");
        navegador.findElement(By.name("password")).sendKeys("admin");
        navegador.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        // Verificar se o login ocorreu corretamente
        WebElement pagina = navegador.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h1"));
        String mensagem = pagina.getText();
        assertEquals("Bem vindo ao Desafio", mensagem);
    }

    @Test
    public void listarClienteNome() {

        //Acessando o Menu de Inclusão
        navegador.findElement(By.linkText("QA")).click();
        navegador.findElement(By.linkText("Clientes")).click();
        navegador.findElement(By.linkText("Listar")).click();

        // Verificar carregamento da tela
        navegador.findElement(By.cssSelector("input.btn-primary:nth-child(2)")).click();
        WebElement pagina = navegador.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h1"));
        String mensagem = pagina.getText();
        assertEquals("Listar Clientes", mensagem);


        // Pesquisando o cliente - Campo Nome
        navegador.findElement(By.name("j_idt17")).clear();
        navegador.findElement(By.name("j_idt17")).sendKeys("Cliente QA");
        navegador.findElement(By.name("j_idt20")).click();
        assertEquals("http://provaqa.marketpay.com.br:9089/desafioqa/listarCliente", navegador.getCurrentUrl());

        //Capturar Screenshot
        String screenshotArquivo = "/Users/erikl/Evd_teste/" + test.getMethodName() + Generator.DataHoraParaArquivo() + ".png";
        ScreenShot.tirar(navegador, screenshotArquivo);

    }

    @Test
    public void listarClienteData() {

        //Acessando o Menu de Inclusão
        navegador.findElement(By.linkText("QA")).click();
        navegador.findElement(By.linkText("Clientes")).click();
        navegador.findElement(By.linkText("Listar")).click();

        // Verificar carregamento da tela
        navegador.findElement(By.cssSelector("input.btn-primary:nth-child(2)")).click();
        WebElement pagina = navegador.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h1"));
        String mensagem = pagina.getText();
        assertEquals("Listar Clientes", mensagem);


        // Pesquisando o cliente - Campo Data Validade
        navegador.findElement(By.name("calendario_input")).clear();
        navegador.findElement(By.name("calendario_input")).sendKeys("01/2018");
        navegador.findElement(By.name("j_idt20")).click();
        assertEquals("http://provaqa.marketpay.com.br:9089/desafioqa/listarCliente", navegador.getCurrentUrl());

        //Capturar Screenshot
        String screenshotArquivo = "/Users/erikl/Evd_teste/" + test.getMethodName() + Generator.DataHoraParaArquivo() + ".png";
        ScreenShot.tirar(navegador, screenshotArquivo);

    }

    @Test
    public void listarClienteLimpaBase() {

        //Acessando o Menu de Inclusão
        navegador.findElement(By.linkText("QA")).click();
        navegador.findElement(By.linkText("Clientes")).click();
        navegador.findElement(By.linkText("Listar")).click();

        // Verificar carregamento da tela
        navegador.findElement(By.cssSelector("input.btn-primary:nth-child(2)")).click();
        WebElement pagina = navegador.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h1"));
        String mensagem = pagina.getText();
        assertEquals("Listar Clientes", mensagem);


        // Limpando a base
        navegador.findElement(By.xpath("//*[@id=\"formListarCliente\"]/div/fieldset/div/div/div[4]/input")).click();
        assertEquals("http://provaqa.marketpay.com.br:9089/desafioqa/listarCliente", navegador.getCurrentUrl());

        navegador.findElement(By.xpath("//*[@id=\"formListarCliente\"]/div/fieldset/div/div/div[3]/input")).click();

        //Capturar Screenshot
        String screenshotArquivo = "/Users/erikl/Evd_teste/" + test.getMethodName() + Generator.DataHoraParaArquivo() + ".png";
        ScreenShot.tirar(navegador, screenshotArquivo);

    }

    @After
    public void fecharNavegador() {
        // Fechar o navegador
        navegador.quit();
    }
}
