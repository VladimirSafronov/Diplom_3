import static util.Constants.CONSTRUCTOR_LINK;
import static util.Constants.LOGOUT_BUTTON;
import static util.Constants.LOGO_LINK;
import static util.Constants.PERSONAL_ACCOUNT_BUTTON;
import static util.Constants.TEST_USER_EMAIL;
import static util.Constants.TEST_USER_PASSWORD;
import static util.Constants.URL;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class CrossingTest extends BaseTestWithUser {

  @Test
  @DisplayName("Check login through 'Личный кабинет'")
  @Description("Проверка входа в ЛК по клику на кнопку 'Личный кабинет'")
  public void checkLoginPersonalAccount() {
    steps.openSite(URL, driver);
    steps.clickButton(PERSONAL_ACCOUNT_BUTTON);
    steps.loginPersonalAccount(TEST_USER_EMAIL, TEST_USER_PASSWORD);
    Assert.assertTrue(steps.isMakeOrderButtonExists());
  }

  @Test
  @DisplayName("Check cross from personal account to constructor")
  @Description("Проверка перехода из личного кабинета в конструктор")
  public void crossFromPersonalAccountToConstructor() {
    steps.openSite(URL, driver);
    steps.clickButton(PERSONAL_ACCOUNT_BUTTON);
    steps.loginPersonalAccount(TEST_USER_EMAIL, TEST_USER_PASSWORD);
    steps.clickButton(PERSONAL_ACCOUNT_BUTTON);
    steps.clickLinkPersonalAccountPage(CONSTRUCTOR_LINK);
    Assert.assertTrue(steps.isMakeOrderButtonExists());
  }

  @Test
  @DisplayName("Check click to logo from personal account")
  @Description("Проверка перехода из личного кабинета на главную страницу по логотипу")
  public void clickLogoLinkFromPersonalAccount() {
    steps.openSite(URL, driver);
    steps.clickButton(PERSONAL_ACCOUNT_BUTTON);
    steps.loginPersonalAccount(TEST_USER_EMAIL, TEST_USER_PASSWORD);
    steps.clickButton(PERSONAL_ACCOUNT_BUTTON);
    steps.clickLinkPersonalAccountPage(LOGO_LINK);
    Assert.assertTrue(steps.isMakeOrderButtonExists());
  }

  @Test
  @DisplayName("Check logout from personal account")
  @Description("Проверка выхода из личного кабинета")
  public void checkLogoutFromPersonalAccount() {
    steps.openSite(URL, driver);
    steps.clickButton(PERSONAL_ACCOUNT_BUTTON);
    steps.loginPersonalAccount(TEST_USER_EMAIL, TEST_USER_PASSWORD);
    steps.clickButton(PERSONAL_ACCOUNT_BUTTON);
    steps.clickLinkPersonalAccountPage(LOGOUT_BUTTON);
    Assert.assertTrue(steps.isLoginHeaderExists());
  }

  //кнопка выход -> страница PersonalAccountLoginPage
}
