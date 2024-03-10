package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Waiter;

/**
 * Page Object входа в личный кабинет
 */
public class PersonalAccountLoginPage {

  protected final By emailFieldLocator = By.xpath(
      ".//label[contains(text(),'Email')]/following-sibling::input");
  protected final By passwordFieldLocator = By.xpath(
      ".//label[contains(text(),'Пароль')]/following-sibling::input");
  private final By registrationLinkLocator = By.xpath(".//a[text()='Зарегистрироваться']");
  private final By enterButtonLocator = By.xpath(".//button[text()='Войти']");
  private final By badPasswordMessageLocator = By.xpath(".//p[text()='Некорректный пароль']");

  protected WebElement emailField;
  protected WebElement passwordField;
  private WebElement registrationLink;
  private WebElement enterButton;

  protected WebDriver driver;
  protected WebDriverWait wait;

  public PersonalAccountLoginPage() {
  }

  public PersonalAccountLoginPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    wait.until(ExpectedConditions.elementToBeClickable(emailFieldLocator));
    this.emailField = driver.findElement(emailFieldLocator);
    this.passwordField = driver.findElement(passwordFieldLocator);
    wait.until(ExpectedConditions.elementToBeClickable(registrationLinkLocator));
    this.registrationLink = driver.findElement(registrationLinkLocator);
    this.enterButton = driver.findElement(enterButtonLocator);
  }

  public WebElement getEmailField() {
    return emailField;
  }

  public WebElement getPasswordField() {
    return passwordField;
  }

  public WebElement getRegistrationLink() {
    return registrationLink;
  }

  public WebElement getEnterButton() {
    return enterButton;
  }

  public WebElement getBadPasswordMessage() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(badPasswordMessageLocator));
    return driver.findElement(badPasswordMessageLocator);
  }
}
