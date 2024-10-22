package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    private final By  loginYourAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Увеличенное время ожидания
    }
    @Step("Open main page")
    public void open() {
        driver.get(URL.BASE_URL);
    }
    @Step("click on the Login your Account button")
    // Метод для клика по кнопке "Войти в аккаунт"
    public MainPage clickLoginButton() {
        WebElement yourAccountButtonElement = wait.until(ExpectedConditions.elementToBeClickable(loginYourAccountButton));
        yourAccountButtonElement.click();
        return this;
    }
    @Step("click on the Personal account button")
    // Метод для клика по кнопке "Личный кабинет"
    public MainPage clickPersonalAccountButton() {
        WebElement personalAccountButtonElement = wait.until(ExpectedConditions.elementToBeClickable(personalAccountButton));
        personalAccountButtonElement.click();
        return this;
    }
    //клик для перехода в раздел булки
    @Step("Click on the bread section")
    public MainPage clickBreadButton() {
        this.driver.findElement(this.breadSection).click();
        return this;

    }
    //клик для перехода в раздел соусы
    @Step("Click on the sauces section")
    public MainPage clickSaucesSectionButton() {
        this.driver.findElement(this.saucesSection).click();
        return this;
    }
    //клик для перехода в раздел начинки
    @Step("Click on the fillings section")
    public MainPage clickFillingsSectionButton() {
        this.driver.findElement(this.fillingSection).click();
        return this;
    }


}
