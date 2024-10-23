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
    private final By breadSection = By.cssSelector(".tab_tab__1SPyG:nth-child(1)");
    //локатор раздела соусы
    private final By saucesSection =By.cssSelector(".tab_tab__1SPyG:nth-child(2)");
    //локатор раздела начинки
    private final By  fillingSection = By.cssSelector(".tab_tab__1SPyG:nth-child(3)");
    //локатор кнопки личный кабинет
    private final By  personalAccountButton =By.xpath(".//*[text() = 'Личный Кабинет']");
    //локатор кнопки войти в аккаунт
    private final By  loginYourAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
//локатор кнопки оформить заказ доступной после авторизации
private final By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");
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
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeContains(driver.findElement(breadSection), "class", "current"));
        return this;

    }
    @Step("clicking on the button leads to the appearance of the bread section")
    public boolean isCurrentClassBreadSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        clickBreadButton();
        // Получаем текущий класс элемента начинки
        String classAttribute = driver.findElement(breadSection).getAttribute("class");
        return classAttribute.contains("current");
    }
    //клик для перехода в раздел соусы
    @Step("Click on the sauces section")
    public MainPage clickSaucesSectionButton() {
        this.driver.findElement(this.saucesSection).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeContains(driver.findElement(saucesSection), "class", "current"));
        return this;
    }


    @Step("clicking on the button leads to the appearance of the sauce section")
    public boolean isCurrentClassSauceSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        clickSaucesSectionButton();
        // Получаем текущий класс элемента начинки
        String classSauceAttribute = driver.findElement(saucesSection).getAttribute("class");
        return classSauceAttribute.contains("current");
    }
    //клик для перехода в раздел начинки
    @Step("Click on the fillings section")
    public MainPage clickFillingsSectionButton() {
        this.driver.findElement(this.fillingSection).click();
        // Ожидаем, пока атрибут "class" элемента ingredientTab не будет содержать "current"
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeContains(driver.findElement(fillingSection), "class", "current"));
        return this;
    }
    @Step("clicking on the button leads to the appearance of the filling section")
    public boolean isCurrentClassFillingSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       clickFillingsSectionButton();
        // Получаем текущий класс элемента начинки
        String classFillingAttribute = driver.findElement(fillingSection).getAttribute("class");
        return classFillingAttribute.contains("current");
    }
    @Step("the user has been logged in")
    public boolean iscreateOrderButton(){
             return driver.findElement(createOrderButton).isDisplayed();}
}
