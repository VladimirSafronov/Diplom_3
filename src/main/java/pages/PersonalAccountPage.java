package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object личного кабинета
 */
public class PersonalAccountPage {

  private final By constructorLinkLocator = By.xpath(".//p[text()='Конструктор']");
  private final By logoLinkLocator = By.xpath(".//div[@id='root']/div/header/nav/div/a");
  private final By logoutButtonLocator = By.xpath(".//button[text()='Выход']");

  private final WebDriver driver;
  private final WebDriverWait wait;

  public PersonalAccountPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  public WebElement getConstructorLink() {
    wait.until(ExpectedConditions.elementToBeClickable(constructorLinkLocator));
    return driver.findElement(constructorLinkLocator);
  }

  public WebElement getLogoLink() {
    wait.until(ExpectedConditions.elementToBeClickable(logoLinkLocator));
    return driver.findElement(logoLinkLocator);
  }

  public WebElement getLogoutButton() {
    wait.until(ExpectedConditions.elementToBeClickable(logoutButtonLocator));
    return driver.findElement(logoutButtonLocator);
  }
}
