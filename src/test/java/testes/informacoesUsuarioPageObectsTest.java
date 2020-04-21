package testes;

import Suporte.Web;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginFormPage;

public class informacoesUsuarioPageObectsTest {
    private WebDriver navegador;
    @Before
    public  void  setUp(){
        navegador = Web.createChrome();
    }
    @Test
    public  void testAdicionarUmaInformacaoAdicionalDoUsuario(){
        new LoginFormPage(navegador)
                .click //Verificar aula 22


    }
    @After
    public  void  tearDown(){
        navegador.quit();
    }
}
