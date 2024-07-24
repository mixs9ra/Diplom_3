package pageobject;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import user.UserGenerator;
import java.time.Duration;

public class RegistrationPage {
    private final WebDriver driver; // Объект для браузера

    // Локаторы для поиска элементов на странице
    private final By registrationHeader = By.xpath(".//h2[text() = 'Регистрация']");
    private final By nameField = By.xpath(".//div[./label[text()='Имя']]/input[@name='name']");
    private final By emailField = By.xpath(".//div[./label[text()='Email']]/input[@name='name']");
    private final By passwordField = By.xpath(".//div[./label[text()='Пароль']]/input[@name='Пароль']");
    private final By registrationButton = By.xpath(".//button[text() = 'Зарегистрироваться']");
    private final By invalidPassword = By.xpath(".//*[@class='input__error text_type_main-default' and text()='Некорректный пароль']");
    private final By loginButton = By.linkText("Войти");

    // Конструктор класса, инициализирует WebDriver
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Ожидание загрузки страницы с регистрацией
    @Step("Ожидание загрузки страницы с регистрацией.")
    public void waitDownloadRegistrationPage() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(driver ->
                (driver.findElement(registrationHeader).getText() != null && !driver.findElement(registrationHeader).getText().isEmpty())
        );
    }

    // Клик по кнопке "Зарегистрироваться"
    @Step("Клик по кнопке 'Зарегистрироваться'.")
    public void clickRegistrationUser() {
        driver.findElement(registrationButton).click();
    }

    // Клик по кнопке "Войти"
    @Step("Клик по кнопке 'Войти'.")
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    // Получение сообщения о некорректном пароле
    @Step("Получение сообщения о некорректном пароле")
    public String getTextException() {
        return driver.findElement(invalidPassword).getText();
    }

    // Заполнение поля name
    @Step("Заполнение поля name")
    public RegistrationPage setName(String newName) {
        waitDownloadRegistrationPage();
        getName().sendKeys(newName);
        return this;
    }

    // Заполнение поля email
    @Step("Заполнение поля email")
    public RegistrationPage setEmail(String newEmail) {
        getEmail().sendKeys(newEmail);
        return this;
    }

    // Заполнение поля password
    @Step("Заполнение поля password")
    public RegistrationPage setPassword(String newPassword) {
        getPassword().sendKeys(newPassword);
        return this;
    }

    // Поиск поля name
    @Step("Поиск поля name")
    public WebElement getName() {
        return driver.findElement(nameField);
    }

    // Поиск поля email
    @Step("Поиск поля email")
    public WebElement getEmail() {
        return driver.findElement(emailField);
    }

    // Поиск поля password
    @Step("Поиск поля password")
    public WebElement getPassword() {
        return driver.findElement(passwordField);
    }

    // Регистрация корректного пользователя
    @DisplayName("Регистрация корректного пользователя")
    public void createCorrectUser() {
        waitDownloadRegistrationPage();
        UserGenerator userGenerator = new UserGenerator();
        setName(userGenerator.getName());
        setEmail(userGenerator.getEmail());
        setPassword(userGenerator.getValidPassword());
        clickRegistrationUser();
    }

    // Регистрация некорректного пользователя: пароль меньше 6 символов
    @DisplayName("Регистрация некорректного пользователя: пароль меньше 6 символов")
    public void createInvalidUser() {
        waitDownloadRegistrationPage();
        UserGenerator userGenerator = new UserGenerator();
        setName(userGenerator.getName());
        setEmail(userGenerator.getEmail());
        setPassword(userGenerator.getInvalidPassword());
        clickRegistrationUser();
    }
}