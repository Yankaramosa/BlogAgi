import Paginas.InicioPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PesquisarNoticiaInesistente {


    private WebDriver navegador;

    @BeforeEach
    public void setup() {
        // Abrir navegador
        System.setProperty("webdriver.chorme.driver", "C:\\drivers\\chromedriver\\chromedriver.exe");
        //ChromeDriver driver = new ChromeDriver();
        this.navegador = new ChromeDriver();

        // Maximizar tela
        this.navegador.manage().window().maximize();

        // Temporizador de espera padrão (5s)
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Acessar portal SST-Gerid
        this.navegador.get("https://blogdoagi.com.br");

    }

    @AfterEach
    public void rolartela() throws InterruptedException  {
        new InicioPage(navegador)
                .rolarAteDestaque();

    }


    @Test
    @DisplayName("Pesquisar Noticia inesistente")
    public void testPesquisarNoticiaInesistente() {
        String resultado = new InicioPage(navegador)
                .clicarBotaoLupaPesquisa()
                .preencherPesquisa("Yanka Ramos")
                .clicarBotaoPesquisar()
                .obterResultadoNaoEncontrado();
        Assertions.assertEquals("Nenhum resultado", resultado);
    }
}