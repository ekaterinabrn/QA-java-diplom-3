import api.User;
import api.UserClient;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.EnterPage;
import pageobject.MainPage;
import pageobject.UserPersonalAccountPage;

import static api.constant.RandomDataUser.*;
import static org.junit.Assert.assertTrue;

public class TransferFromYourPersonalAccountTest {
    private MainPage mainPage;
    private EnterPage enterPage;
    private String accessToken;

    @Rule
    public DriverRule factory = new DriverRule();

    @Before
    public void setUp() {
        User user = new User(RANDOM_EMAIL, RANDOM_PASSWORD, RANDOM_NAME);
        Response createUserTest = UserClient.createUser(user);
        this.accessToken = UserClient.getAccessToken(createUserTest);
        WebDriver driver = factory.getDriver();
        mainPage = new MainPage(driver);
        enterPage = new EnterPage(driver);
        mainPage.open();
        mainPage.clickPersonalAccountButton();
        enterPage.setUserData(user.getEmail(), user.getPassword());
        enterPage.clickEnterButton();
        mainPage.closeModalWindow();
        mainPage.clickPersonalAccountButton();

    }

    @Test
    @Description("Checking the transfer from your personal account to the main page after click on the Constructor button")
    public void transferByClickingOnTheConstructorTest() {
        WebDriver driver = factory.getDriver();
        UserPersonalAccountPage personalAccountPage = new UserPersonalAccountPage(driver);
        personalAccountPage.clickConstructorButton();
        mainPage.closeModalWindow();
        assertTrue(mainPage.iscreateOrderButton());

    }

    @Test
    @Description("Checking the transition from your personal account to the main page by clicking the Stellar Burgers logo")
    public void transferByClickingOnTheLogoTest() {
        WebDriver driver = factory.getDriver();
        UserPersonalAccountPage personalAccountPage = new UserPersonalAccountPage(driver);
        personalAccountPage.clickStellarBurgerLogo();
        mainPage.closeModalWindow();
        assertTrue(mainPage.iscreateOrderButton());
    }

    @After
    public void deleteUser() {
        if (accessToken != null) {
            Response delete = UserClient.deleteUser(accessToken);
            delete.then().statusCode(202);
        }
    }
}

