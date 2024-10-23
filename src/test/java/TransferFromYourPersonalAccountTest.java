import API.User;
import API.UserClient;
import PageObject.EnterPage;
import PageObject.MainPage;
import PageObject.RegisterPage;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static API.Constant.RandomDataUser.*;

public class TransferFromYourPersonalAccountTest {
    private WebDriver driver;
    private MainPage mainPage;
    private EnterPage enterPage;
    private RegisterPage registerPage;
    private String accessToken;
    @Rule
    public DriverRule factory = new DriverRule();
    @Test
    public void testAccordionAnswers() {
        User user = new User(RANDOM_EMAIL, RANDOM_PASSWORD, RANDOM_NAME);
        Response createUserTest = UserClient.createUser(user);
        this.accessToken = UserClient.getAccessToken(createUserTest);
        WebDriver driver = factory.getDriver();
        mainPage = new MainPage(driver);
        enterPage=new EnterPage(driver);
        registerPage=new RegisterPage(driver);
        mainPage.open();
mainPage.clickPersonalAccountButton();
enterPage.setUserData(user.getEmail(), user.getPassword());

    }
@After
public void deleteUser() {
    if (accessToken != null) {
        Response delete = UserClient.deleteUser(accessToken);
        delete.then().statusCode(202);
    }
}}

