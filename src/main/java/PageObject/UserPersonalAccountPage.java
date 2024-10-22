package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserPersonalAccountPage {
    private WebDriver driver;
    private WebDriverWait wait;
    // локатор кнопки выйти
    private final By Button = By.xpath(".//a[text()='Войти']");
    //локатор логотипа бургеров
    //локтаор конструктора
    public UserPersonalAccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }
}
