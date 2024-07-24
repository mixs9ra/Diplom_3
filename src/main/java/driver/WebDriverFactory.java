package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    public static WebDriver getWebDriver() {
        String browser = System.getProperty("browser", "chrome");

        switch (browser) {
            case "yandex":
                // Путь к chromedriver указан правильно
                System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver");

                ChromeOptions options = new ChromeOptions();

                // Путь к Yandex Browser
                options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");

                // Возвращаем ChromeDriver с указанными опциями
                return new ChromeDriver(options);

            default:
                // Для Chrome Browser
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                return new ChromeDriver();
        }
    }
}