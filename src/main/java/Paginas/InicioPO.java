package Paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InicioPO {

    public WebDriver navegador;

    public InicioPO(WebDriver navegador){
        this.navegador = navegador;
    }

    public void rolarAteDestaque () throws InterruptedException{

        //WebElement interation = navegador.findElement(By.cssSelector("h3[class=front-section-title]"));

//        Actions act = new Actions(navegador);

  //      act.moveToElement(interation).click().build().perform();
    //    Thread.sleep(1000);

        JavascriptExecutor jse = (JavascriptExecutor) navegador;
        jse.executeScript("window.scrollBy(0,300)");
        Thread.sleep(1000);
    }

    public void clicarBotaoLupaPesquisa () {
        navegador.findElement(By.cssSelector("button[id='search-open']")).click();
    }

    public void preencherPesquisa (String preencherPesquisa){
        navegador.findElement(By.cssSelector("input[placeholder='Pesquisar …']")).click();
        navegador.findElement(By.cssSelector("input[placeholder='Pesquisar …']")).sendKeys(preencherPesquisa);
    }

    public void clicarBotaoPesquisar () {
        navegador.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
    }

    //TODO - Criar metodo obter resultado
}