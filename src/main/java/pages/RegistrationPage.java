package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Page Object регистрации
 */
public class RegistrationPage extends PersonalAccountLoginPage {

  private final By nameFieldLocator = By.xpath(
      ".//label[contains(text(),'Имя')]/following-sibling::input");
  private final By registrationButtonLocator = By.xpath(".//button[text()='Зарегистрироваться']");
  private final By loginLinkLocator = By.xpath(".//a[text()='Войти']");

  private final WebElement nameField;
  private final WebElement registrationButton;
  private final WebElement loginLink;

  public RegistrationPage(WebDriver driver) {
    super(driver);

    this.nameField = driver.findElement(nameFieldLocator);
    this.registrationButton = driver.findElement(registrationButtonLocator);
    this.loginLink = driver.findElement(loginLinkLocator);
  }

  public WebElement getRegistrationButton() {
    return registrationButton;
  }

  public WebElement getNameField() {
    return nameField;
  }

  public WebElement getLoginLink() {
    return loginLink;
  }
}
