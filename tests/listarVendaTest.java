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

public class listarVendaTest {
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
    public void listarTransacaoTodos() {

        //Acessando o Menu de Inclusão
        navegador.findElement(By.linkText("QA")).click();
        navegador.findElement(By.linkText("Transações")).click();
        navegador.findElement(By.linkText("Listar")).click();

        // Verificar carregamento da tela
        navegador.findElement(By.cssSelector("input.btn-primary:nth-child(2)")).click();
        WebElement pagina = navegador.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h1"));
        String mensagem = pagina.getText();
        assertEquals("Listar Transações", mensagem);


        // Selecionado o cliente
        WebElement cliente = navegador.findElement(By.id("cliente"));
        Select comboCliente = new Select(cliente);
        comboCliente.selectByVisibleText("TODOS");

        navegador.findElement(By.name("j_idt20")).click();
        assertEquals("http://provaqa.marketpay.com.br:9089/desafioqa/listarVenda", navegador.getCurrentUrl());

        //Capturar Screenshot
        String screenshotArquivo = "/Users/erikl/Evd_teste/" + test.getMethodName() + Generator.DataHoraParaArquivo() + ".png";
        ScreenShot.tirar(navegador, screenshotArquivo);

    }

    @Test
    public void listarTransacaoCliente() {

        //Acessando o Menu de Inclusão
        navegador.findElement(By.linkText("QA")).click();
        navegador.findElement(By.linkText("Transações")).click();
        navegador.findElement(By.linkText("Listar")).click();

        // Verificar carregamento da tela
        navegador.findElement(By.cssSelector("input.btn-primary:nth-child(2)")).click();
        WebElement pagina = navegador.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h1"));
        String mensagem = pagina.getText();
        assertEquals("Listar Transações", mensagem);


        // Selecionado o cliente
        WebElement cliente = navegador.findElement(By.id("cliente"));
        Select comboCliente = new Select(cliente);
        comboCliente.selectByVisibleText("Test Name");

        navegador.findElement(By.name("j_idt20")).click();
        assertEquals("http://provaqa.marketpay.com.br:9089/desafioqa/listarVenda", navegador.getCurrentUrl());

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
