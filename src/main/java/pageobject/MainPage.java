package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private final By homePageHeader = By.xpath(".//*[@class='active']");
    private final By personalAreaButton = By.xpath(".//p[text() = 'Личный Кабинет']");
    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By sectionBun = By.xpath(".//*[text()='Булки']//parent::div");
    private final By sectionSauce = By.xpath(".//*[text()='Соусы']//parent::div");
    private final By sectionFilling = By.xpath(".//*[text()='Начинки']//parent::div");
    private final By activity = By.xpath("//div[starts-with(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc')]//span");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ожидание загрузки главной страницы.")
    public void waitLoadHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(driver -> (driver.findElement(homePageHeader).isEnabled()
        ));
    }

    @Step("Клик по кнопке 'Личный кабинет'.")
    public void clickPersonalArea() {
        waitLoadHeader();
        driver.findElement(personalAreaButton).click();
    }

    @Step("Клик по кнопке 'Войти в аккаунт'.")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Клик по кнопке 'Булки' в конструкторе бургера.")
    public void clickBun() {

        driver.findElement(sectionBun).click();
    }

    @Step("Клик по кнопке 'Соусы' в конструкторе бургера.")
    public void clickSauce() {
        waitLoadHeader();
        driver.findElement(sectionSauce).click();
    }

    @Step("Клик по кнопке 'Начинки' в конструкторе бургера.")
    public void clickFilling() {
        waitLoadHeader();
        driver.findElement(sectionFilling).click();
    }

    @Step("Поиск активного раздела конструктора бургера")
    public String checkActivity() {
        String activityElement = driver.findElement(activity).getText();
        return activityElement;
    }
}
