package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.ScreenShot;

import static org.junit.Assert.assertEquals;

public class cadastrarTransacaoTest {
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
    public void incluirClienteAtivoTransacao() throws InterruptedException {

        //Geração da Massa de Testes
        navegador.findElement(By.linkText("QA")).click();
        navegador.findElement(By.linkText("Clientes")).click();
        navegador.findElement(By.linkText("Incluir")).click();

        // Verificar carregamento da tela
        WebElement pagina = navegador.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h1/label"));
        String mensagem = pagina.getText();
        assertEquals("Incluir Cliente", mensagem);


        // Cadastrando um novo cliente - Nome
        navegador.findElement(By.id("nome")).clear();
        navegador.findElement(By.id("nome")).sendKeys("Test Name");

        // Cadastrando um novo cliente - CPF
        navegador.findElement(By.id("cpf")).clear();
        navegador.findElement(By.id("cpf")).sendKeys("98765432100");

        // Cadastrando um novo cliente - Status
        WebElement status = navegador.findElement(By.id("status"));
        Select combo = new Select(status);
        combo.selectByVisibleText("Ativo");

        // Cadastrando um novo cliente - Saldo
        navegador.findElement(By.id("saldoCliente")).clear();
        navegador.findElement(By.id("saldoCliente")).sendKeys("1000,00");

        //Salvar
        WebDriverWait aguardar = new WebDriverWait(navegador, 10);
        aguardar.until(ExpectedConditions.elementToBeClickable(By.id("botaoSalvar")));
        navegador.findElement(By.id("botaoSalvar")).click();


        //Acessando o Menu de Inclusão da Transação
        navegador.findElement(By.xpath("//*[@id=\"left-panel\"]/nav/ul[2]/li/a/span")).click();
        navegador.findElement(By.xpath("//*[@id=\"left-panel\"]/nav/ul[2]/li/ul/li[2]/a")).click();
        navegador.findElement(By.xpath("//*[@id=\"left-panel\"]/nav/ul[2]/li/ul/li[2]/ul/li[1]/a/span")).click();


        // Verificar carregamento da tela
        WebElement paginaTrans = navegador.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h1/label"));
        String mensagemTrans = paginaTrans.getText();
        assertEquals("Incluir Transacao", mensagemTrans);


        // Selecionado o cliente
        WebElement cliente = navegador.findElement(By.id("cliente"));
        Select comboCliente = new Select(status);
        comboCliente.selectByVisibleText("Test Name");

        // Valor Transação
        navegador.findElement(By.id("valorTransacao")).clear();
        navegador.findElement(By.id("valorTransacao")).sendKeys("100,00");
        Thread.sleep(1000);

         //Salvar
        WebDriverWait aguardarTrans = new WebDriverWait(navegador, 10);
        aguardarTrans.until(ExpectedConditions.elementToBeClickable(By.id("botaoSalvar")));

        navegador.findElement(By.id("botaoSalvar")).click();
        Thread.sleep(1000);
        navegador.findElement(By.id("botaoSalvar")).click();


        WebDriverWait aguardarSalvar = new WebDriverWait(navegador, 10);
        aguardarSalvar.until(ExpectedConditions.elementToBeClickable(By.id("botaoSalvar")));
        Thread.sleep(1000);

        WebElement mensagemPop = navegador.findElement(By.xpath("//*[@id=\"content\"]"));
        String confMsg = mensagemPop.getText();
        assertEquals("Visualizar Transacao", confMsg);

        //Capturar Screenshot
        String screenshotArquivo = "/Users/erikl/Evd_teste/" + test.getMethodName() + Generator.DataHoraParaArquivo() +".png";
        ScreenShot.tirar(navegador, screenshotArquivo);
    }


    @Test
    public void incluirTransacaoObrigatorios() throws InterruptedException {

        //Acessando o Menu de Inclusão da Transação
        navegador.findElement(By.xpath("//*[@id=\"left-panel\"]/nav/ul[2]/li/a/span")).click();
        navegador.findElement(By.xpath("//*[@id=\"left-panel\"]/nav/ul[2]/li/ul/li[2]/a")).click();
        navegador.findElement(By.xpath("//*[@id=\"left-panel\"]/nav/ul[2]/li/ul/li[2]/ul/li[1]/a/span")).click();


        // Verificar carregamento da tela
        WebElement paginaTrans = navegador.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h1/label"));
        String mensagemTrans = paginaTrans.getText();
        assertEquals("Incluir Transacao", mensagemTrans);


        // Selecionado o cliente
        WebElement cliente = navegador.findElement(By.id("cliente"));
        Select comboCliente = new Select(cliente);
        comboCliente.selectByVisibleText("Test Name");

        //Salvar
        WebDriverWait aguardar = new WebDriverWait(navegador, 10);
        aguardar.until(ExpectedConditions.elementToBeClickable(By.id("botaoSalvar")));
        navegador.findElement(By.id("botaoSalvar")).click();

        Thread.sleep(1000);
        navegador.findElement(By.id("botaoSalvar")).click();

        WebElement mensagemPop = navegador.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h1/label"));
        String confMsg = mensagemPop.getText();
        assertEquals("Campo Obrigatório", confMsg);


        //Capturar Screenshot
        String screenshotArquivo = "/Users/erikl/Evd_teste/" + test.getMethodName() + Generator.DataHoraParaArquivo() +".png";
        ScreenShot.tirar(navegador, screenshotArquivo);
    }



    public WebDriver getDriver(){
        if(navegador == null) {
            navegador = new ChromeDriver();
            navegador.manage().window().setSize(new Dimension(1200, 765));
        }
        return navegador;
    }

    @After
    public void fecharNavegador() {
        // Fechar o navegador
        navegador.quit();
    }
}
