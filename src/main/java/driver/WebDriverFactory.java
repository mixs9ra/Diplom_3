package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    public static WebDriver getWebDriver() {
        // Получаем значение свойства browser, если оно не задано, то по умолчанию "chrome"
        String browser = System.getProperty("browser", "chrome");

        switch (browser) {
            case "yandex":
                // Указываем путь к chromedriver для Яндекс.Браузера
                System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver");

                ChromeOptions yandexOptions = new ChromeOptions();
                // Указываем путь к бинарному файлу Яндекс.Браузера
                yandexOptions.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");

                // Возвращаем ChromeDriver с указанными опциями для Яндекс.Браузера
                return new ChromeDriver(yandexOptions);

            default:
                // Указываем путь к chromedriver для Google Chrome
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                return new ChromeDriver();
        }
    }
}