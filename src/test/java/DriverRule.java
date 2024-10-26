import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;


public class DriverRule extends ExternalResource {
    private WebDriver driver;

    @Override
    protected void before() throws Throwable {
        initDriver();
    }

    @Override
    protected void after() {
        driver.quit();
    }

    public void initDriver() {
        if ("firefox".equals(System.getProperty("browser"))) {
            startFirefox();
        } else if ("yandex".equals(System.getProperty("browser"))) {
            startYandex();
        }
        else {
            startChrome();
        }
    }

    public void startFirefox() {
        WebDriverManager.firefoxdriver().driverVersion("0.34.0").setup();
        var opts = new FirefoxOptions()
                .configureFromEnv();
        driver = new FirefoxDriver(opts);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }


    public void startChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    private void startYandex() {
        WebDriverManager.chromedriver().driverVersion(System.getProperty("driver.version")).setup();

        var options = new ChromeOptions();
        options.setBinary(System.getProperty("webdriver.yandex.bin"));

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public WebDriver getDriver() {
        return driver;
    }
}
