package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object восстановления пароля
 */
public class PasswordRecoveryPage {

  protected final By emailFieldLocator = By.xpath(
      ".//label[contains(text(),'Email')]/following-sibling::input");
  private final By loginLinkLocator = By.xpath(".//a[text()='Войти']");

  protected WebDriver driver;
  protected WebDriverWait wait;
  protected WebElement emailField;

  public PasswordRecoveryPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    wait.until(ExpectedConditions.elementToBeClickable(emailFieldLocator));
    this.emailField = driver.findElement(emailFieldLocator);
  }

  public WebElement getLoginLink() {
    wait.until(ExpectedConditions.elementToBeClickable(loginLinkLocator));
    return driver.findElement(loginLinkLocator);
  }
}
