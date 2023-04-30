package Paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InicioPage {
    private WebDriver navegador;

    public InicioPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public void rolarAteDestaque () throws InterruptedException{
        JavascriptExecutor jse = (JavascriptExecutor) navegador;
        jse.executeScript("window.scrollBy(0,300)");
        Thread.sleep(1000);
    }

    public InicioPage clicarBotaoLupaPesquisa() {
        navegador.findElement(By.cssSelector("button[id='search-open']")).click();

        return this;
    }

    public InicioPage preencherPesquisa(String preencherPesquisa){
        //navegador.findElement(By.cssSelector("input[placeholder='Pesquisar …']")).click();
        navegador.findElement(By.cssSelector("input[placeholder='Pesquisar …']")).sendKeys(preencherPesquisa);

        return this;
    }

    public InicioPage clicarBotaoPesquisar () {
        navegador.findElement(By.xpath("(//input[@type='submit'])[1]")).click();

        return this;
    }
    public InicioPage clicarNaNoticia (){
        navegador.findElement(By.xpath("(//a[@href='https://blogdoagi.com.br/2023/02/27/volume-de-transacoes-via-pix-no-agibank-cresceu-mais-de-30-vezes-em-dois-anos/'])[3]")).click();

        return this;
    }

    public String obterResultado () {
        return navegador.findElement(By.xpath("//h1[@class='entry-title']")).getText();
    }

    public String obterResultadoNaoEncontrado () {
        return navegador.findElement(By.xpath("//h1[@class='entry-title']")).getText();
    }
}
