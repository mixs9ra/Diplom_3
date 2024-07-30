import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.MainPage;

import static org.junit.Assert.assertEquals;

public class TransitionBurgerTest {

    private static final String site = BaseTest.SITE;// Используем BaseTest.SITE напрямую
    private WebDriver driver;
    private pageobject.MainPage mainPage;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(site);
        mainPage = new MainPage(driver);
        mainPage.waitLoadHeader();
    }

    @Test
    @DisplayName("Переход в раздел 'Булки'.")

    public void checkGoToBuns() {
        mainPage.clickSauce();
        mainPage.clickBun();
        String bun = mainPage.checkActivity();
        assertEquals("Булки", bun);
    }

    @Test
    @DisplayName("Переход в раздел 'Соусы'.")
    @Description("Проверка перехода в раздел 'Соусы'.")
    public void checkGoToSauces() {
        mainPage.clickSauce();
        String sauce = mainPage.checkActivity();
        assertEquals("Соусы", sauce);
    }

    @Test
    @DisplayName("Переход в раздел 'Начинки'.")
    @Description("Проверка перехода в раздел 'Начинки'.")
    public void checkGoToFillings() {
        mainPage.clickFilling();
        String filling = mainPage.checkActivity();
        assertEquals("Начинки", filling);
    }

    @After
    public void tearDown() {

        driver.quit();
    }
}