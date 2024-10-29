package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasswordRecoveryPage {
    private WebDriver driver;
    private WebDriverWait wait;
    // локатор кнопки войти на странице восстановления пароля
    private final By enterButton = By.xpath(".//a[text()='Войти']");
    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }
    @Step("Click on the enter button on password recovery page")
    public PasswordRecoveryPage clickEnterButton() {
        WebElement enterButtonElement = wait.until(ExpectedConditions.elementToBeClickable(enterButton));
        enterButtonElement.click();
        return this;

    }

}
