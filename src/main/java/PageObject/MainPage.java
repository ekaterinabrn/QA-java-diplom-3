package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;
    //локатор раздела булки
    private final By breadSection = By.xpath(".//span[contains(text(),'Булки')]");
    //локатор раздела соусы
    private final By saucesSection =By.xpath(".//span[contains(text(),'Соусы')]");
    //локатор раздела начинки
    private final By  fillingSection =By.xpath(".//span[contains(text(),'Начинки')]");
    //локатор кнопки личный кабинет
    private final By  personalAccountButton =By.xpath(".//*[text() = 'Личный Кабинет']");
    //локатор кнопки войти в аккаунт
    private final By  loginYourAccountButton = By.xpath("");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Увеличенное время ожидания
    }
    public void open() {
        driver.get(URL.BASE_URL);
    }
}
