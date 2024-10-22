package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EnterPage {
    private WebDriver driver;
    private WebDriverWait wait;
    //локатор поля емейл
    private final By emailField = By.xpath(".//label[text() = 'Email']/../input[contains(@name, 'name')]");
    //локатор поля пароль
    private final By passwordField =By.xpath(".//label[text()='Пароль']/../input");
    //локатор кнопки  войти
    private final By  enterButton =By.xpath(".//button[text() = 'Войти']");
    //локатор кнопки зарегестрироваться
    private final By  registerButton =By.xpath(".//a[(@class = 'Auth_link__1fOlj' and text()= 'Зарегистрироваться')]");
    //локатор кнопки восстановить пароль
    private final By  recoverPasswordButton = By.xpath(".//a[(@class = 'Auth_link__1fOlj' and text()= 'Восстановить пароль')]");

    public EnterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
}
    @Step("Set email in the field")
    // Метод для ввода email
    public EnterPage setEmail(String email) {
        WebElement emailFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailFieldElement.sendKeys(email);
    return this;
    }
    @Step("Set password in the field")
    // Метод для ввода пароля
    public EnterPage setPassword(String password) {
        WebElement passwordFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordFieldElement.sendKeys(password);
        return this;
    }
    @Step("Click on the enter button")
    // Метод для клика по кнопке входа
    public EnterPage clickEnterButton() {
        WebElement   enterButtonElement = wait.until(ExpectedConditions.elementToBeClickable(enterButton));
        enterButtonElement.click();
        return this;

    }
    @Step("Click on the Register button")
    // Метод для клика по кнопке регистрации
    public EnterPage clickRegisterButton() {
        this.driver.findElement(this.registerButton).click();
  return this;
    }
    @Step("Click on the forgot password button")
    // Метод для клика по кнопке восстановления пароля
        public EnterPage clickForgotPassword() {
            this.driver.findElement(this.recoverPasswordButton).click();
            return this;
        }
    @Step("Set user data")
    // Метод ввода информации о пользователе
    public EnterPage setUserData(String email, String password) {
        setEmail(email);
       setPassword(password);
    return this;
    }
    }

