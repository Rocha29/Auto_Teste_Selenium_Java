package testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import Suporte.Web;

public class informacoesUsuarioPageObectsTest {
    private WebDriver navegador;
    @Before
    public  void  setUp(){
        navegador = Web.createChrome();
    }
    @Test
    public  void testAdicionarUmaInformacaoAdicionalDoUsuario(){
        new LoginPage(navegador)
                .clicarSignIn()
                .fazerLogin("julio0001","123456")
                .clicarMe()
                .clicarAbaMoreDataAboutYou()
                .clicarBotaoAddMoreDataAboutYou();


    }
    @After
    public  void  tearDown(){

        navegador.quit();
    }
}
