package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserPersonalAccountPage {
    private WebDriver driver;
    private WebDriverWait wait;
    // локатор кнопки выйти
    private final By exitButton = By.xpath(".//button[text() = 'Выход']");
    //локатор логотипа бургеров
    private final By stellarBurgerLogo = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    //локтор конструктора
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");


    public UserPersonalAccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    @Step("Click on the exit button on User Personal Account Page")
    public UserPersonalAccountPage clickExitButton() {
        WebElement exitButtonElement = wait.until(ExpectedConditions.elementToBeClickable(exitButton));
        exitButtonElement.click();
        return this;
    }

    @Step("Click on the Constructor button on User Personal Account Page")
    public UserPersonalAccountPage clickConstructorButton() {
        this.driver.findElement(this.constructorButton).click();
        return this;
    }

    @Step("Click on the stellar Burger Logo on User Personal Account Page")
    public UserPersonalAccountPage clickStellarBurgerLogo() {
        this.driver.findElement(this.stellarBurgerLogo).click();
        return this;
    }


}
