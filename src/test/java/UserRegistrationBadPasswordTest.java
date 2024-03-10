import static util.Constants.PERSONAL_ACCOUNT_BUTTON;
import static util.Constants.TEST_USER_EMAIL;
import static util.Constants.TEST_USER_NAME;
import static util.Constants.URL;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebElement;

@RunWith(Parameterized.class)
public class UserRegistrationBadPasswordTest extends BaseTest {

  @Parameter
  public String password;

  @Parameters
  public static Object[][] setTestData() {
    return new Object[][]{
        {"12"},
        {"12345"}
    };
  }

  @Test
  @DisplayName("Check incorrect password length")
  @Description("Проверка ошибки для некорректного пароля")
  public void registrationTooShortPasswordThenFail() {
    steps.openSite(URL, driver);
    steps.clickButton(PERSONAL_ACCOUNT_BUTTON);
    WebElement incorrectPasswordMessage = steps.inputIncorrectRegistrationData(
        TEST_USER_NAME, TEST_USER_EMAIL, password);
    Assert.assertNotNull(incorrectPasswordMessage);
  }
}
