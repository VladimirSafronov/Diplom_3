package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Page Object регистрации
 */
public class RegistrationPage extends PersonalAccountLoginPage {

  protected final By nameFieldLocator = By.xpath(
      ".//label[contains(text(),'Имя')]/following-sibling::input");
  private final By registrationButtonLocator = By.xpath(".//button[text()='Зарегистрироваться']");
  private final By loginLinkLocator = By.xpath(".//a[text()='Войти']");

  private final WebElement nameField;

  public RegistrationPage(WebDriver driver) {
    super(driver);

    wait.until(ExpectedConditions.elementToBeClickable(nameFieldLocator));
    this.nameField = driver.findElement(nameFieldLocator);
  }

  public WebElement getRegistrationButton() {
    wait.until(ExpectedConditions.elementToBeClickable(registrationButtonLocator));
    return driver.findElement(registrationButtonLocator);
  }

  public WebElement getNameField() {
    return nameField;
  }

  public WebElement getLoginLink() {
    wait.until(ExpectedConditions.elementToBeClickable(loginLinkLocator));
    return driver.findElement(loginLinkLocator);
  }
}
