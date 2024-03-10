package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object главной страницы Stellar Burgers
 */
public class StellarBurgersMain {

  private final By personalAccountButtonLocator = By.xpath(".//p[text()='Личный Кабинет']");
  private final By enterAccountButtonLocator = By.xpath(".//button[text()='Войти в аккаунт']");

  private final By makeOrderButtonLocator = By.xpath(".//button[text()='Оформить заказ']");

  private final WebDriver driver;
  private final WebDriverWait wait;

  private final WebElement personalAccountButton;

  public StellarBurgersMain(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(personalAccountButtonLocator));
    this.personalAccountButton = driver.findElement(personalAccountButtonLocator);
  }

  public WebElement getPersonalAccountButton() {
    return personalAccountButton;
  }

  public WebElement getMakeOrderButton() {
    wait.until(ExpectedConditions.elementToBeClickable(makeOrderButtonLocator));
    return driver.findElement(makeOrderButtonLocator);
  }

  public WebElement getEnterAccountButton() {
    wait.until(ExpectedConditions.elementToBeClickable(enterAccountButtonLocator));
    return driver.findElement(enterAccountButtonLocator);
  }
}
