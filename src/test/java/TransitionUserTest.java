import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TransitionUserTest extends BaseTest {

    @Test
    @DisplayName("Переход в личный кабинет после авторизации")
    @Description("Проверка перехода по клику на 'Личный кабинет' после авторизации.")
    public void transitionToPersonalAreaTest() {
        mainPage.clickPersonalArea();
        loginPage.login(user);
        mainPage.waitLoadHeader();

        mainPage.clickPersonalArea();
        infoUserPage.waitLoadingPage();
        assertEquals(user.getName(), infoUserPage.getUserName());
        String expectedUrl = SITE + "account/profile";
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Переход в конструктор из личного кабинета.")
    @Description("Проверка перехода на вкладку 'Конструктор' из личного кабинета.")
    public void transitionToConstructorTest() {
        mainPage.clickPersonalArea();
        loginPage.login(user);
        mainPage.waitLoadHeader();

        mainPage.clickPersonalArea();
        infoUserPage.waitLoadingPage();

        infoUserPage.clickConstructorButton();
        mainPage.waitLoadHeader();

        assertEquals(SITE, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Клик по логотипу 'Stellar Burgers'.")
    @Description("Проверка перехода в конструктор при нажатии на логотип 'Stellar Burgers'.")
    public void transitionToLogoTest() {
        mainPage.clickPersonalArea();
        loginPage.login(user);
        mainPage.waitLoadHeader();

        mainPage.clickPersonalArea();
        infoUserPage.waitLoadingPage();

        infoUserPage.clickLogo();
        mainPage.waitLoadHeader();

        assertEquals(SITE, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Выход из аккаунта личного кабинета")
    @Description("Проверка выхода по кнопке 'Выйти' в личном кабинете")
    public void logout() {
        mainPage.clickPersonalArea();
        loginPage.login(user);
        mainPage.waitLoadHeader();
        mainPage.clickPersonalArea();
        infoUserPage.waitLoadingPage();

        infoUserPage.clickExit();
        loginPage.waitDownloadLoginPage();

        String expectedUrl = SITE + "login";
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }
}