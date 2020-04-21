package Suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {
    public  static WebDriver createChrome(){
        //Abrindo o navegador
        System.setProperty("webdriver.chrome.driver","C:\\util\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Navegando para a página do taskit!
        navegador.get("http://www.juliodelima.com.br/taskit");

        return navegador;
    }
}
