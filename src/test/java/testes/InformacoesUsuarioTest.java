package testes;

import static org.junit.Assert.*;
import Suporte.Generator;
import Suporte.Screenshot;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths="InformacoesUsuarioTest.csv")
public class InformacoesUsuarioTest {
    private WebDriver navegador;

    @Rule
    public TestName test = new TestName();


    @Before
    public void setUp(){
        //Abrindo o navegador
        System.setProperty("webdriver.chrome.driver","C:\\util\\drivers\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Navegando para a página do taskit!
        navegador.get("http://www.juliodelima.com.br/taskit");

        //clicar no link que possui o texto "Sign in"
        navegador.findElement(By.linkText("Sign in")).click();

        //Identificar o formulário de login id"signinbox"
        WebElement formularioSignInbox = navegador.findElement(By.id("signinbox"));

        //digitar no campo com o name "login" que esta dentro do formulário de id"signinbox" o texto "julio0001"
        formularioSignInbox.findElement(By.name("login")).sendKeys("julio0001");

        //digitar no campo com o name "password" que esta dentro do formulário de id"signinbox" o texto "123456"
        formularioSignInbox.findElement(By.name("password")).sendKeys("123456");

        // clicar no link com o texto "SIGN IN"
        navegador.findElement(By.linkText("SIGN IN")).click();

        //clicar em um link que possui a class "me"
        navegador.findElement(By.className("me")).click();

        // clicar em um link que possui o texto "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();


    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(@Param(name="tipo") String tipo, @Param(name="contato") String contato, @Param(name="mensagem") String mensagemEsperada) {


        // clicar no botão através do seu xpath //button[@data-target="addmoredata"]
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        // Identificar a popup onde está o formulario de id addmoredata
        WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));

        // Na combo de name "type" escolher a opção "phone"
        WebElement CampoType = popupAddMoreData.findElement(By.name("type"));
        new Select(CampoType).selectByVisibleText(tipo);

        // No campo de name "contact" digitar "+5511999999999"
        popupAddMoreData.findElement(By.name("contact")).sendKeys(contato);
        //No link de text "SAVE" que está na popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();

        // na mensagem de id "toast-container" validar o que texto é "your contact has been added!"
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        assertEquals(mensagemEsperada, mensagem);
    }
    @Test
    public void removerUmContatoDeUmUsuario() {

        //Clicar no elemento pelo seu xpath //span[text()="+551146690123"]/following-sibling::a
        navegador.findElement(By.xpath(" //span[text()=\"+551146690123\"]/following-sibling::a")).click();

        // confirmar a janela javascript
        navegador.switchTo().alert().accept();

        //validar que a mensagem apresentada foi Rest in peace, dear phone!
            WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
            String mensagem = mensagemPop.getText();
            assertEquals("Rest in peace, dear phone!", mensagem);

            String ScreenshotArquivo = "C:\\test-report\\taskit\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
            Screenshot.tirar(navegador, ScreenshotArquivo);

        //aguardar até 10 segundos para que a janela desapareca
            WebDriverWait aguardar = new WebDriverWait(navegador,10 );
            aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));

        // clicar no link com o text "Logout"
        navegador.findElement(By.linkText("Logout")).click();


    }
    @After
    public void  tearDown(){
        //fechar o navegador
        //navegador.quit();


    }
}
