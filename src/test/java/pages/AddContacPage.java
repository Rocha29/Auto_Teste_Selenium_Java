package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddContacPage  extends BasePage{
    public AddContacPage(WebDriver navegador) {
        super(navegador);
    }
public AddContacPage escolherTipoDeContato(String tipo){
    WebElement CampoType = navegador.findElement(By.id("addmoredata")).findElement(By.name("type"));
    new Select(CampoType).selectByVisibleText(tipo);
        return this;
}
public AddContacPage digitarContato(String contato){
    navegador.findElement(By.id("addmoredata")).findElement(By.name("contact")).sendKeys(contato);
        return this;
}
public MePage clicarSalvar(){
    navegador.findElement(By.id("addmoredata")).findElement(By.linkText("SAVE")).click();
        return new MePage(navegador);
}
public MePage adicinarContatos(String tipo, String contato){
        escolherTipoDeContato(tipo);
        digitarContato(contato);
        clicarSalvar();
        return new MePage(navegador);
}
}
