package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private WebDriver driver;
    private WebDriverWait wait;
    //локатор поля имя
    private final By nameField = By.cssSelector("input.text.input__textfield.text_type_main-default[name='name']");
    //локатор поля емейл
    private final By emailField = By.xpath(".//label[text() = 'Email']/../input[contains(@name, 'name')]");
    //локатор поля пароль
    private final By passwordField =By.xpath(".//label[text() = 'Пароль']");
    //локатор кнопки  войти
    private final By  enterButton =By.xpath(".//a[text()='Войти']");
    //локатор кнопки зарегестрироваться
    private final By  registerButton =By.xpath("//button[text()='Зарегистрироваться']");
    //локатор надписи при вводе некоректного пароля
    private final By wrongPassword = By.xpath(".//*[text()='Некорректный пароль']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
}

}
