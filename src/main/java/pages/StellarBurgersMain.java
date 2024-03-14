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
  private final By bunsLinkLocator = By.xpath(".//span[text()='Булки']");
  private final By sousesLinkLocator = By.xpath(".//span[text()='Соусы']");
  private final By fillingsLinkLocator = By.xpath(".//span[text()='Начинки']");

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

  public WebElement getBunsLink() {
    wait.until(ExpectedConditions.elementToBeClickable(bunsLinkLocator));
    return driver.findElement(bunsLinkLocator);
  }

  public WebElement getSousesLink() {
    wait.until(ExpectedConditions.elementToBeClickable(sousesLinkLocator));
    return driver.findElement(sousesLinkLocator);
  }

  public WebElement getFillingsLink() {
    wait.until(ExpectedConditions.elementToBeClickable(fillingsLinkLocator));
    return driver.findElement(fillingsLinkLocator);
  }

  /**
   * Метод проверяет подсвечен ли переданный элемент
   */
  public boolean getElementLinkLight(String linkName) {
    By elementLinkLightLocator = By.xpath(String.format(
        ".//span[text()='%s']/parent::div[contains(@class, 'tab_tab_type_current__2BEPc')]",
        linkName));
    wait.until(ExpectedConditions.visibilityOfElementLocated(elementLinkLightLocator));
    return driver.findElement(elementLinkLightLocator).isDisplayed();
  }
}
