package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Page Object входа в личный кабинет
 */
public class PersonalAccountLoginPage extends PasswordRecoveryPage {

  protected final By passwordFieldLocator = By.xpath(
      ".//label[contains(text(),'Пароль')]/following-sibling::input");
  private final By registrationLinkLocator = By.xpath(".//a[text()='Зарегистрироваться']");
  private final By enterButtonLocator = By.xpath(".//button[text()='Войти']");
  private final By badPasswordMessageLocator = By.xpath(".//p[text()='Некорректный пароль']");
  private final By passwordRecoveryLinkLocator = By.xpath(".//a[text()='Восстановить пароль']");
  private final By headerLocator = By.xpath(".//h2[text()='Вход']");

  protected WebElement passwordField;

  public PersonalAccountLoginPage(WebDriver driver) {
    super(driver);

    this.passwordField = driver.findElement(passwordFieldLocator);
  }

  public WebElement getEmailField() {
    return emailField;
  }

  public WebElement getPasswordField() {
    return passwordField;
  }

  public WebElement getRegistrationLink() {
    wait.until(ExpectedConditions.elementToBeClickable(registrationLinkLocator));
    return driver.findElement(registrationLinkLocator);
  }

  public WebElement getEnterButton() {
    wait.until(ExpectedConditions.elementToBeClickable(enterButtonLocator));
    return driver.findElement(enterButtonLocator);
  }

  public WebElement getBadPasswordMessage() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(badPasswordMessageLocator));
    return driver.findElement(badPasswordMessageLocator);
  }

  public WebElement getPasswordRecoveryLink() {
    wait.until(ExpectedConditions.elementToBeClickable(passwordRecoveryLinkLocator));
    return driver.findElement(passwordRecoveryLinkLocator);
  }

  public WebElement getHeader() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(headerLocator));
    return driver.findElement(headerLocator);
  }
}
