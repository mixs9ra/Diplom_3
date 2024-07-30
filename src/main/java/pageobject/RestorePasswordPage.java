package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePasswordPage {
    private final WebDriver driver; // Объект для браузера
    private final By loginButton = By.linkText("Войти"); // Локатор для кнопки "Войти"

    // Конструктор класса, инициализирует WebDriver
    public RestorePasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для клика по кнопке "Войти"
    @Step("Клик по кнопке 'Войти'.")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}