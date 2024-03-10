package util;

import exceptions.NotFoundElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Данный класс помогает дождаться загрузки элемента на странице
 */
public class Waiter {

  public static boolean isElementExists(WebDriver driver, By locator) {
    return driver.findElements(locator).size() > 0 && driver.findElement(locator).isDisplayed();
  }

  public static void waitForElement(WebDriver driver, By locator) {
    try {
      for (int i = 0; i < 10; i++) {
        if (isElementExists(driver, locator)) {
          return;
        }
        Thread.sleep(500);
      }
    } catch (Exception ex) {
      throw new NotFoundElementException("Element by locator " + locator + " didn't find");
    }
  }
}
