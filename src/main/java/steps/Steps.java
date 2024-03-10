package steps;

import static util.Specification.doDeleteRequest;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PersonalAccountLoginPage;
import pages.RegistrationPage;
import pages.StellarBurgersMain;
import util.Constants;

/**
 * Помогает реализовать тестирование при помощи степов - тесты короче, отчет понятнее.
 */
public class Steps {

  /**
   * Адрес ручки удаления пользователя
   */
  final String deleteUserDataUrl = "api/auth/user";

  private static WebDriver driver;

  @Step("Переходим на сайт: {url}")
  public void openSite(String url, WebDriver currentDriver) {
    driver = currentDriver;
    driver.get(url);
  }

  @Step("Кликаем по кнопке Личный кабинет")
  public void movePersonalAccount() {
    StellarBurgersMain page = new StellarBurgersMain(driver);
    page.getPersonalAccountButton().click();
  }

  @Step("Вводим корректные данные регистрации")
  public void inputCorrectRegistrationData(String name, String email, String password) {
    RegistrationPage registrationPage = inputRegistrationData(name, email, password);

    new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOf(
        registrationPage.getEmailField()));
  }

  @Step("Вводим некорректные данные регистрации")
  public WebElement inputIncorrectRegistrationData(String name, String email, String password) {
    RegistrationPage registrationPage = inputRegistrationData(name, email, password);
    return registrationPage.getBadPasswordMessage();
  }

  @Step("Входим в личный кабинет")
  public void loginPersonalAccount() {
    PersonalAccountLoginPage page = new PersonalAccountLoginPage(driver);
    inputFieldData(page.getEmailField(), Constants.TEST_USER_EMAIL);
    inputFieldData(page.getPasswordField(), Constants.TEST_USER_PASSWORD);
    page.getEnterButton().click();
  }

  @Step("Удаление пользователя")
  public void deleteUserStep(String accessToken) {
    doDeleteRequest(deleteUserDataUrl, accessToken);
  }

  @Step("Проверяем имеется ли кнопка Оформить заказ")
  public boolean isMakeOrderButtonExists() {
    StellarBurgersMain page = new StellarBurgersMain(driver);
    return page.getMakeOrderButton() != null;
  }

  /**
   * Метод вводит текст в поле ввода
   */
  private void inputFieldData(WebElement element, String data) {
    element.click();
    element.clear();
    element.sendKeys(data);
  }

  /**
   * Метод вводит текст во все поля регистрационного окна
   */
  private RegistrationPage inputRegistrationData(String name, String email, String password) {
    PersonalAccountLoginPage personalAccountLoginPage = new PersonalAccountLoginPage(driver);
    personalAccountLoginPage.getRegistrationLink().click();

    RegistrationPage registrationPage = new RegistrationPage(driver);
    inputFieldData(registrationPage.getNameField(), name);
    inputFieldData(registrationPage.getEmailField(), email);
    inputFieldData(registrationPage.getPasswordField(), password);
    registrationPage.getRegistrationButton().click();

    return registrationPage;
  }
}
