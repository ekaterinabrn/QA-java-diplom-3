import PageObject.MainPage;
import io.qameta.allure.Description;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class TransitionConstructorTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Rule
    public DriverRule factory = new DriverRule();
    @Description("clicking on the button leads to the appearance of the bun section")
    @Test
    public void testBunSectionButton() {
        WebDriver driver = factory.getDriver();
        mainPage = new MainPage(driver);
        mainPage.open();
        //так как страница автоматически открывается с разделом булки перейдем на другой раздел и проверим , что работает клик
        mainPage.clickFillingsSectionButton();
        assertTrue("Класс не содержит 'current'", mainPage.isCurrentClassBreadSection());
    }
    @Description("clicking on the button leads to the appearance of the sauce section")
    @Test
        public void testSauceSectionButton() {
            WebDriver driver = factory.getDriver();
            mainPage = new MainPage(driver);
            mainPage.open();
        assertTrue("Класс не содержит 'current'", mainPage.isCurrentClassSauceSection());
    }

    @Description("clicking on the button leads to the appearance of the filling section")
    @Test
    public void testFillingSectionButton() {
        WebDriver driver = factory.getDriver();
        mainPage = new MainPage(driver);
        mainPage.open();
        // Проверяем, что  клик переводит в раздел начинки
        assertTrue("Класс не содержит 'current'", mainPage.isCurrentClassFillingSection());

    }}

