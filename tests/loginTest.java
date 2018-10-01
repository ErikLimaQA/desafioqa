package tests;

import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.ScreenShot;

import static org.junit.Assert.assertEquals;

public class loginTest {
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

    }

    @Test
    public void loginInvalidoUser() {
        navegador.findElement(By.name("username")).sendKeys("adminxxx");
        navegador.findElement(By.name("password")).sendKeys("admin");
        navegador.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        // Verificar se o login ocorreu corretamente
        WebElement pagina = navegador.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/section[1]/font/label"));
        String mensagem = pagina.getText();
        assertEquals("Credenciais inválidas", mensagem);

        //Capturar Screenshot
        String screenshotArquivo = "/Users/erikl/Evd_teste/" + test.getMethodName() + Generator.DataHoraParaArquivo() +".png";
        ScreenShot.tirar(navegador, screenshotArquivo);
    }


    @Test
    public void loginInvalidoPass() {
        navegador.findElement(By.name("username")).sendKeys("admin");
        navegador.findElement(By.name("password")).sendKeys("adminxxx");
        navegador.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        // Verificar se o login ocorreu corretamente
        WebElement pagina = navegador.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/section[1]/font/label"));
        String mensagem = pagina.getText();
        assertEquals("Credenciais inválidas", mensagem);

        //Capturar Screenshot
        String screenshotArquivo = "/Users/erikl/Evd_teste/" + test.getMethodName() + Generator.DataHoraParaArquivo() +".png";
        ScreenShot.tirar(navegador, screenshotArquivo);
    }

    @Test
    public void loginValido() {
        navegador.findElement(By.name("username")).sendKeys("admin");
        navegador.findElement(By.name("password")).sendKeys("admin");
        navegador.findElement(By.xpath("//button[@type=\"submit\"]")).click();

       // Verificar se o login ocorreu corretamente
        WebElement pagina = navegador.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h1"));
        String mensagem = pagina.getText();
        assertEquals("Bem vindo ao Desafio", mensagem);

        //Capturar Screenshot
        String screenshotArquivo = "/Users/erikl/Evd_teste/" + test.getMethodName() + Generator.DataHoraParaArquivo() +".png";
        ScreenShot.tirar(navegador, screenshotArquivo);
    }

    @After
    public void fecharNavegador() {
        // Fechar o navegador
        navegador.quit();
    }
}
