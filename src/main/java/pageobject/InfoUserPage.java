package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class InfoUserPage {

    private final WebDriver driver; // Управление браузером

    // Локаторы для поиска элементов на странице
    private final By profileButton = By.xpath(".//*[text()='Профиль']");
    private final By allUserFields = By.xpath(".//*[@class='text input__textfield text_type_main-default input__textfield-disabled']");
    private final By constructorButton = By.linkText("Конструктор");
    private final By logoButton = By.xpath(".//*[@class='AppHeader_header__logo__2D0X2']");
    private final By exitButton = By.xpath(".//button[text()='Выход']");

    // Конструктор класса, инициализирует WebDriver
    public InfoUserPage(WebDriver driver) {
        this.driver = driver;
    }

    // Ожидание загрузки страницы "Личный кабинет"
    @Step("Ожидание загрузки страницы 'Личный кабинет'.")
    public InfoUserPage waitLoadingPage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver -> driver.findElement(profileButton).isEnabled());
        return this;
    }

    // Получение имени пользователя из первого поля
    @Step("Получение имени первого поля в разделе 'Профиль': 'Имя'.")
    public String getUserName() {
        return driver.findElements(allUserFields).get(0).getAttribute("value");
    }

    // Клик на кнопку "Конструктор"
    @Step("Клик на кнопку 'Конструктор'.")
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    // Клик на логотип
    @Step("Клик на логотип 'Stellar Burger'.")
    public void clickLogo() {
        driver.findElement(logoButton).click();
    }

    // Клик на кнопку "Выход"
    @Step("Клик на кнопку 'Выход'.")
    public void clickExit() {
        driver.findElement(exitButton).click();
    }
}