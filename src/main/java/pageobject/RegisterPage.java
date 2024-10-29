package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    private final By passwordField =By.xpath(".//label[text() = 'Пароль']/../input[contains(@type, 'password')]");
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
    @Step("Set name in the field")
    // Метод для ввода имени
    public RegisterPage setName(String name) {

            WebElement nameFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
        nameFieldElement.sendKeys(name);
            return this;
        }

    @Step("Set email in the field")
    // Метод для ввода email
    public RegisterPage setEmail(String email) {
        WebElement emailFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailFieldElement.sendKeys(email);
        return this;
    }
    @Step("Set password in the field")
    // Метод для ввода пароля в поле
    public RegisterPage setPassword(String password) {
        WebElement passwordFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordFieldElement.sendKeys(password);
        return this;
    }

    @Step("Click on the Register button on register page")
    // Метод для клика по кнопке регистрации
    public RegisterPage clickRegisterButton() {
        this.driver.findElement(this.registerButton).click();
        return this;
    }
    @Step("Click on the enter button on register page")
    // Метод для клика по кнопке входа
    public RegisterPage clickEnterButton() {
        WebElement enterButtonElement = wait.until(ExpectedConditions.elementToBeClickable(enterButton));
        enterButtonElement.click();
        return this;

    }
@Step("Set new user data")
    // Метод для установки информации пользователя
    public RegisterPage setNewUserData(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        return this;
    }

    @Step("Get text when wrong password is entered")
    public boolean isWrongPassword() {
        return driver.findElement(wrongPassword).isDisplayed();
    }

}
