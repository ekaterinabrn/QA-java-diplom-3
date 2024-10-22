import PageObject.EnterPage;
import PageObject.MainPage;
import PageObject.RegisterPage;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Testme {
    private WebDriver driver;
    private MainPage mainPage;
    private EnterPage enterPage;
    private RegisterPage registerPage;
    @Rule
    public DriverRule factory = new DriverRule();
    @Test
    public void testAccordionAnswers() {
        WebDriver driver = factory.getDriver();
        mainPage = new MainPage(driver);
        enterPage=new EnterPage(driver);
        registerPage=new RegisterPage(driver);
        mainPage.open();
mainPage.clickPersonalAccountButton();
enterPage.clickRegisterButton();
registerPage.setNewUserData("fwe", "ddf","bb");
}}
