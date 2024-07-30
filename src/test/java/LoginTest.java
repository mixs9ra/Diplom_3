import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Вход по кнопке 'Войти в аккаунт'.")
    @Description("Проверка кнопки 'Войти в аккаунт' на главной странице лендинга.")
    public void loginLoginButtonTest() {
        mainPage.clickLoginButton();

        loginPage.login(user);

        mainPage.waitLoadHeader();
        String actualUrl = driver.getCurrentUrl();
        assertEquals(SITE, actualUrl);
    }

    @Test
    @DisplayName("Вход по кнопке 'Личный Кабинет'.")
    @Description("Проверка кнопки 'Личный Кабинет' на хедере главной страницы.")
    public void loginAreaButtonTest() {
        mainPage.clickPersonalArea();

        loginPage.login(user);

        mainPage.waitLoadHeader();
        String actualUrl = driver.getCurrentUrl();
        assertEquals(SITE, actualUrl);
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации.")
    @Description("Проверка входа через форму регистрации.")
    public void loginRegistrationTest() {
        mainPage.clickPersonalArea();
        loginPage.clickRegistration();
        registrationPage.clickLogin();

        loginPage.login(user);

        mainPage.waitLoadHeader();
        String actualUrl = driver.getCurrentUrl();
        assertEquals(SITE, actualUrl);
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля.")
    @Description("Проверка входа через форму восстановления пароля.")
    public void loginRestorePasswordTest() {
        mainPage.clickPersonalArea();
        loginPage.clickRestorePasswordButton();
        restorePasswordPage.clickLoginButton();

        loginPage.login(user);

        mainPage.waitLoadHeader();
        String actualUrl = driver.getCurrentUrl();
        assertEquals(SITE, actualUrl);
    }
}
