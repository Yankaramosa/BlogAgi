import Paginas.InicioPO;
import Paginas.InicioPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PesquisarNotificiaComDadosEspecificos {

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
        new InicioPO(navegador)
                .rolarAteDestaque();

    }


    @Test
    @DisplayName("Pesquisar Noticia com dados especificos")
    public void testPesquisarComDadosEspecificos() {
        String resultado = new InicioPage(navegador)
                .clicarBotaoLupaPesquisa()
                .preencherPesquisa("Volume de transações via Pix cresceu mais de 30 vezes em dois anos no Agibank")
                .clicarBotaoPesquisar()
                .clicarNaNoticia()
                .obterResultado();
      Assertions.assertEquals("Volume de transações via Pix cresceu mais de 30 vezes em dois anos no Agibank", resultado);
    }
    }