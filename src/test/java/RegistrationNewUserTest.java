import API.UserClient;
import PageObject.EnterPage;
import PageObject.MainPage;
import PageObject.PasswordRecoveryPage;
import PageObject.RegisterPage;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;

import static API.Constant.RandomDataUser.RANDOM_EMAIL;
import static API.Constant.RandomDataUser.RANDOM_NAME;
import static org.junit.Assert.assertTrue;

public class RegistrationNewUserTest {
    private MainPage mainPage;
    private EnterPage enterPage;
    private RegisterPage registerPage;
    private PasswordRecoveryPage passwordRecoveryPage;
    private String accessToken;

    @Rule
    public DriverRule factory = new DriverRule();

    @Test
    public void registerNewUserTest() {
        WebDriver driver = factory.getDriver();
        mainPage = new MainPage(driver);
        enterPage = new EnterPage(driver);
        registerPage = new RegisterPage(driver);
        mainPage.open();
        mainPage.clickLoginButton();
        enterPage.clickRegisterButton();
        registerPage.setNewUserData(RANDOM_NAME, RANDOM_EMAIL, "123456");
        registerPage.clickRegisterButton();
        //проверка что пользователь зарегестрирован
        assertTrue(enterPage.isEntranceIndicatorDisplayed());
        //логиним пользователя для получения токена из консоли разработчика
        enterPage.setUserData(RANDOM_EMAIL, "123456");
        enterPage.clickEnterButton();
        assertTrue(mainPage.iscreateOrderButton());
//получаем токен
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        this.accessToken = localStorage.getItem("accessToken");
        System.out.println(accessToken);

    }

    @Test
    @DisplayName("Registration  new user with wrong password less then 6 char")
    public void userRegistrationWithWrongPassTest() {
        WebDriver driver = factory.getDriver();
        mainPage = new MainPage(driver);
        enterPage = new EnterPage(driver);
        registerPage = new RegisterPage(driver);
        mainPage.open();
        mainPage.clickLoginButton();
        enterPage.clickRegisterButton();
        registerPage.setNewUserData(RANDOM_NAME, RANDOM_EMAIL, "12345");
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
