import API.User;
import API.UserClient;
import PageObject.EnterPage;
import PageObject.MainPage;
import PageObject.UserPersonalAccountPage;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static API.Constant.RandomDataUser.*;
import static org.junit.Assert.assertTrue;

public class ExitingAccountTest {
    private WebDriver driver;
    private MainPage mainPage;
    private EnterPage enterPage;
    private String accessToken;
    User user;
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
    @Description("the entry label appears after clicking on the exit button in your personal account")
    public void transferByClickingOnExitTest() {
        WebDriver driver = factory.getDriver();
        UserPersonalAccountPage personalAccountPage = new UserPersonalAccountPage(driver);
       personalAccountPage.clickExitButton();
        assertTrue(enterPage.isEntranceIndicatorDisplayed());

    }


    @After
    public void deleteUser() {
        if (accessToken != null) {
            Response delete = UserClient.deleteUser(accessToken);
            delete.then().statusCode(202);
        }
    }
}