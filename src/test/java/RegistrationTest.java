import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegistrationPage;
import driver.WebDriverFactory;
import user.UserClient;

import static org.junit.Assert.assertEquals;

public class RegistrationTest extends BaseTest { // Наследуемся от базового класса

    private static final String INVALID_PASSWORD = "Некорректный пароль";
    private final String expectedUrl = SITE + "login"; // Используем SITE из базового класса
    private String actual;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = WebDriverFactory.getWebDriver(); // Используем статический метод напрямую
        driver.get(SITE); // URL теперь используется из базового класса

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);

    }

    @DisplayName("Переход на форму регистрации")
    private void toRegistrationPage() {
        mainPage.clickPersonalArea();
        loginPage.clickRegistration();
    }

    @Test
    @DisplayName("Корректная регистрация")
    @Description("Проверка корректной регистрации")
    public void createCorrectUserTest() {
        toRegistrationPage();
        registrationPage.createCorrectUser();
        loginPage.waitDownloadLoginPage();

        actual = driver.getCurrentUrl();
        assertEquals(expectedUrl, actual);
    }

    @Test
    @DisplayName("Некорректная регистрация")
    @Description("Проверка регистрации некорректного пользователя и сообщения: пароль меньше 6 символов")
    public void createInvalidUserTest() {
        toRegistrationPage();
        registrationPage.createInvalidUser();

        actual = registrationPage.getTextException();
        assertEquals(INVALID_PASSWORD, actual);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
