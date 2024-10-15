import PageObject.MainPage;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Testme {
    private WebDriver driver;
    private MainPage mainPage;
    @Rule
    public DriverRule factory = new DriverRule();
    @Test
    public void testAccordionAnswers() {
        WebDriver driver = factory.getDriver();
        mainPage = new MainPage(driver);
        mainPage.open();
        driver.findElement(By.xpath(".//span[contains(text(),'Булки')]"));
}}
