package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EnterPage {
    private WebDriver driver;
    private WebDriverWait wait;
    //локатор поля емейл
    private final By emailField = By.xpath(".//label[text() = 'Email']/../input[contains(@name, 'name')]");
    //локатор поля пароль
    private final By passwordField =By.xpath(".//label[text() = 'Пароль']");
    //локатор кнопки  войти
    private final By  enterButton =By.xpath(".//button[text() = 'Войти']");
    //локатор кнопки зарегестрироваться
    private final By  registerButton =By.xpath(".//a[(@class = 'Auth_link__1fOlj' and text()= 'Зарегистрироваться')]");
    //локатор кнопки восстановить пароль
    private final By  recoverPasswordButton = By.xpath(".//a[(@class = 'Auth_link__1fOlj' and text()= 'Восстановить пароль')]");

    public EnterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
}}
