import static util.Constants.ENTER_ACCOUNT_BUTTON;
import static util.Constants.LOGIN_LINK;
import static util.Constants.PERSONAL_ACCOUNT_BUTTON;
import static util.Constants.RECOVERY_PASSWORD_LINK;
import static util.Constants.REGISTRATION_LINK;
import static util.Constants.TEST_USER_EMAIL;
import static util.Constants.TEST_USER_PASSWORD;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class LoginAccountTest extends BaseTestWithUser {

  @Test
  @DisplayName("Check login of button 'Войти в аккаунт'")
  @Description("Проверка входа по кнопке Войти в аккаунт на главной странице")
  public void loginButtonEnterAccount() {
    steps.clickElementMainPage(ENTER_ACCOUNT_BUTTON);
    steps.loginPersonalAccount(TEST_USER_EMAIL, TEST_USER_PASSWORD);
    Assert.assertTrue(steps.isMakeOrderButtonExists());
  }

  @Test
  @DisplayName("Check login of button 'Личный кабинет'")
  @Description("Проверка входа по кнопке Личный кабинет")
  public void loginButtonPersonalAccount() {
    steps.clickElementMainPage(PERSONAL_ACCOUNT_BUTTON);
    steps.loginPersonalAccount(TEST_USER_EMAIL, TEST_USER_PASSWORD);
    Assert.assertTrue(steps.isMakeOrderButtonExists());
  }

  @Test
  @DisplayName("Check login from registration window")
  @Description("Проверка входа через кнопку в форме регистрации")
  public void loginRegistrationWindow() {
    steps.clickElementMainPage(PERSONAL_ACCOUNT_BUTTON);
    steps.clickLinkLoginPage(REGISTRATION_LINK);
    steps.clickLinkRegistrationPage(LOGIN_LINK);
    steps.loginPersonalAccount(TEST_USER_EMAIL, TEST_USER_PASSWORD);
    Assert.assertTrue(steps.isMakeOrderButtonExists());
  }

  @Test
  @DisplayName("Check login from password recovery window")
  @Description("Проверка входа через кнопку в форме восстановления пароля")
  public void loginPasswordRecoveryWindow() {
    steps.clickElementMainPage(PERSONAL_ACCOUNT_BUTTON);
    steps.clickLinkLoginPage(RECOVERY_PASSWORD_LINK);
    steps.clickLinkPasswordRecoveryPage(LOGIN_LINK);
    steps.loginPersonalAccount(TEST_USER_EMAIL, TEST_USER_PASSWORD);
    Assert.assertTrue(steps.isMakeOrderButtonExists());
  }
}
