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

public class RegistrationNewUserTest {
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
        this.accessToken = UserClient.getAccessToken(createUserTest);}

     @Test
     public void registerNewUserTest() {
         WebDriver driver = factory.getDriver();
            mainPage = new MainPage(driver);
            enterPage=new EnterPage(driver);
            registerPage=new RegisterPage(driver);
            mainPage.open();
            mainPage.clickLoginButton();
            enterPage.clickRegisterButton();
            registerPage.setNewUserData(user.getName(), user.getEmail(), user.getPassword());
            registerPage.clickRegisterButton();

        }
        @Test
        @DisplayName("Registration  new user with wrong password less then 6 char")
        public void userRegistrationWithWrongPassTest() {
            WebDriver driver = factory.getDriver();
            mainPage = new MainPage(driver);
            enterPage=new EnterPage(driver);
            registerPage=new RegisterPage(driver);
            mainPage.open();
            mainPage.clickLoginButton();
            enterPage.clickRegisterButton();
            registerPage.setNewUserData(user.getName(), user.getEmail(),"12345");
            registerPage.clickRegisterButton();
            assertTrue(registerPage.isWrongPassword());
        }

    @After
    public void deleteUser() {
        if (accessToken != null) {
            Response delete = UserClient.deleteUser(accessToken);
            delete.then().statusCode(202);
        }
    }
}
