import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebElement;
import util.Constants;

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
    steps.openSite(Constants.URL, driver);
    steps.movePersonalAccount();
    WebElement incorrectPasswordMessage = steps.inputIncorrectRegistrationData(
        Constants.TEST_USER_NAME, Constants.TEST_USER_EMAIL, password);
    Assert.assertNotNull(incorrectPasswordMessage);
  }
}
