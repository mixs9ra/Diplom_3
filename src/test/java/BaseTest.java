import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pageobject.*;
import driver.WebDriverFactory;
import user.User;
import user.UserClient;
import user.UserGenerator;

public class BaseTest {
    protected static final String SITE = "https://stellarburgers.nomoreparties.site/"; //  URL сайта
    protected WebDriver driver;
    protected pageobject.MainPage mainPage;
    protected pageobject.LoginPage loginPage;
    protected pageobject.RegistrationPage registrationPage;
    protected pageobject.RestorePasswordPage restorePasswordPage;
    protected pageobject.InfoUserPage infoUserPage;
    protected user.User user;
    public user.UserClient userClient;
    private final user.UserGenerator userGenerator = new user.UserGenerator();

    @Before
    @DisplayName("Создание переменных и пользователя")
    public void create() {

        WebDriverManager.chromedriver().setup();// Настройка WebDriverManager

        driver = WebDriverFactory.getWebDriver();// Вызов статического метода напрямую
        driver.get(SITE);

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        restorePasswordPage = new RestorePasswordPage(driver);
        infoUserPage = new InfoUserPage(driver);
        user = userGenerator.getUser();

        UserClient.createUser(user);// Вызов статического метода через имя класса
    }

    @After
    @DisplayName("Выход из браузера и удаление пользователя")
    public void delete() {
        UserClient.deleteUser(user);// Вызов статического метода через имя класса
        driver.quit();
    }
}
