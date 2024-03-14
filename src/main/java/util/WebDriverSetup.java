package util;

import exceptions.UnknownBrowserNameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Класс устанавливает браузер для тестирования (Паттерн Фабрика)
 */
public class WebDriverSetup {

  public static WebDriver getWebDriver(String browserName, String browserPath) {
    switch (browserName) {
      case "chrome":
        System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER"));
        return new ChromeDriver();
      case "yandex":
        System.setProperty("webdriver.chrome.driver", System.getenv("YANDEX_DRIVER"));
        ChromeOptions options = new ChromeOptions();
        options.setBinary(browserPath);
        return new ChromeDriver(options);
      default:
        throw new UnknownBrowserNameException(browserName + " is unknown browser name.");
    }
  }
}
