import static util.Constants.PERSONAL_ACCOUNT_BUTTON;
import static util.Constants.TEST_USER_EMAIL;
import static util.Constants.TEST_USER_NAME;
import static util.Constants.TEST_USER_PASSWORD;
import static util.Constants.URL;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class UserRegistrationTest extends BaseTest {

  @After
  public void cleanTestData() {
    deleteTestData();
  }

  @Test
  @DisplayName("Check user registration")
  @Description("Проверка успешной регистрации")
  public void registrationValidDataThenSuccess() {
    steps.openSite(URL, driver);
    steps.clickButton(PERSONAL_ACCOUNT_BUTTON);
    steps.inputCorrectRegistrationData(TEST_USER_NAME, TEST_USER_EMAIL, TEST_USER_PASSWORD);
    steps.loginPersonalAccount(TEST_USER_EMAIL, TEST_USER_PASSWORD);
    Assert.assertTrue(steps.isMakeOrderButtonExists());
  }
}
