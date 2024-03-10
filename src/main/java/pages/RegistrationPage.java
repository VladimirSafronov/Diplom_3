package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object регистрации
 */
public class RegistrationPage extends PersonalAccountLoginPage {

  private final By nameFieldLocator = By.xpath(
      ".//label[contains(text(),'Имя')]/following-sibling::input");
  private final By registrationButtonLocator = By.xpath(".//button[text()='Зарегистрироваться']");

  private final WebElement nameField;
  private final WebElement registrationButton;

  public RegistrationPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    wait.until(ExpectedConditions.elementToBeClickable(emailFieldLocator));
    this.emailField = driver.findElement(emailFieldLocator);
    this.passwordField = driver.findElement(passwordFieldLocator);
    this.nameField = driver.findElement(nameFieldLocator);
    this.registrationButton = driver.findElement(registrationButtonLocator);
  }

  public WebElement getRegistrationButton() {
    return registrationButton;
  }

  public WebElement getNameField() {
    return nameField;
  }
}
