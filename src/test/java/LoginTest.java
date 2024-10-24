import API.User;
import API.UserClient;
import PageObject.EnterPage;
import PageObject.MainPage;
import PageObject.PasswordRecoveryPage;
import PageObject.RegisterPage;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static API.Constant.RandomDataUser.*;
import static org.junit.Assert.assertTrue;

public class LoginTest {
    private WebDriver driver;
    private MainPage mainPage;
    private EnterPage enterPage;
    private RegisterPage registerPage;
   private PasswordRecoveryPage passwordRecoveryPage;
    private String accessToken;
    User user;
    @Rule
    public DriverRule factory = new DriverRule();
    @Before
    public void setUp() {
 user = new User(RANDOM_EMAIL, RANDOM_PASSWORD, RANDOM_NAME);
        Response createUserTest = UserClient.createUser(user);
        this.accessToken = UserClient.getAccessToken(createUserTest);
    }

    @Test
    @DisplayName("Log in using the personal account button on the main page")
    public void LoginClickPersonalAccountButtonTest() {
        WebDriver driver = factory.getDriver();
        mainPage = new MainPage(driver);
        enterPage=new EnterPage(driver);
        mainPage.open();
        mainPage.clickPersonalAccountButton();
        enterPage.setUserData(user.getEmail(), user.getPassword());
enterPage.clickEnterButton();
        assertTrue(mainPage.iscreateOrderButton());

    }
    @Test
    @DisplayName("Log in using the log in to account button on the main page")
    public void LoginClickLoginButtonTest() {
        WebDriver driver = factory.getDriver();
        mainPage = new MainPage(driver);
        enterPage=new EnterPage(driver);
        mainPage.open();
        mainPage.clickLoginButton();
        enterPage.setUserData(user.getEmail(), user.getPassword());
        enterPage.clickEnterButton();
        assertTrue(mainPage.iscreateOrderButton());}
    @Test
    @DisplayName("Log in  the button in the registration form")
    public void loginFromRegisterPageTest(){
        WebDriver driver = factory.getDriver();
        mainPage = new MainPage(driver);
        enterPage=new EnterPage(driver);
        registerPage=new RegisterPage(driver);
        mainPage.open();
        mainPage.clickLoginButton();
        enterPage.clickRegisterButton();
        registerPage.clickEnterButton();
        enterPage.setUserData(user.getEmail(), user.getPassword());
        enterPage.clickEnterButton();
        assertTrue(mainPage.iscreateOrderButton());
    }



    @Test
    @DisplayName("Login  the button in the password recovery form")
    public void loginFromPasswordRecoveryPageTest(){
            WebDriver driver = factory.getDriver();
            mainPage = new MainPage(driver);
            enterPage=new EnterPage(driver);
            registerPage=new RegisterPage(driver);
            passwordRecoveryPage=new PasswordRecoveryPage(driver);
            mainPage.open();
            mainPage.clickLoginButton();
            enterPage.clickForgotPassword();
            passwordRecoveryPage.clickEnterButton();
        enterPage.setUserData(user.getEmail(), user.getPassword());
        enterPage.clickEnterButton();
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
