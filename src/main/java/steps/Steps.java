package steps;

import static util.Specification.doDeleteRequest;
import static util.Specification.doPostRequest;

import io.restassured.response.Response;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PasswordRecoveryPage;
import pages.PersonalAccountLoginPage;
import pages.RegistrationPage;
import pages.StellarBurgersMain;

/**
 * Помогает реализовать тестирование при помощи степов - тесты короче, отчет понятнее.
 */
public class Steps {

  /**
   * Адрес ручки удаления пользователя
   */
  final String deleteUserDataUrl = "api/auth/user";

  /**
   * Адрес ручки создания пользователя
   */
  final String createUserUrl = "api/auth/register";

  private static WebDriver driver;

  @Step("Переходим на сайт: {url}")
  public void openSite(String url, WebDriver currentDriver) {
    driver = currentDriver;
    driver.get(url);
  }

  @Step("Кликаем по кнопке {button}")
  public void clickButton(String button) {
    StellarBurgersMain page = new StellarBurgersMain(driver);
    switch (button) {
      case "Личный кабинет":
        page.getPersonalAccountButton().click();
        break;
      case "Войти в аккаунт":
        page.getEnterAccountButton().click();
        break;
    }
  }

  @Step("Кликаем по ссылке {linkName} окна регистрации")
  public void clickLinkRegistrationPage(String linkName) {
    RegistrationPage page = new RegistrationPage(driver);
    switch (linkName) {
      case "Войти":
        page.getLoginLink().click();
        break;
    }
  }

  @Step("Кликаем по ссылке {linkName} окна восстановления пароля")
  public void clickLinkPasswordRecoveryPage(String linkName) {
    PasswordRecoveryPage page = new PasswordRecoveryPage(driver);
    switch (linkName) {
      case "Войти":
        page.getLoginLink().click();
        break;
    }
  }

  @Step("Кликаем по ссылке {linkName} окна входа в личный кабинет")
  public void clickLinkLoginPage(String linkName) {
    PersonalAccountLoginPage page = new PersonalAccountLoginPage(driver);
    switch (linkName) {
      case "Зарегистрироваться":
        page.getRegistrationLink().click();
        break;
      case "Восстановить пароль":
        page.getPasswordRecoveryLink().click();
        break;
    }
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
  public void loginPersonalAccount(String email, String password) {
    PersonalAccountLoginPage page = new PersonalAccountLoginPage(driver);
    inputFieldData(page.getEmailField(), email);
    inputFieldData(page.getPasswordField(), password);
    page.getEnterButton().click();
  }

  @Step("Создание пользователя")
  public Response createUserStep(Object body) {
    return doPostRequest(createUserUrl, body);
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
