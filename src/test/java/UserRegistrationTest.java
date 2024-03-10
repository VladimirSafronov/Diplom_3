import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import util.Constants;

public class UserRegistrationTest extends BaseTest {

  @Test
  @DisplayName("Check user registration")
  @Description("Проверка успешной регистрации")
  public void registrationValidDataThenSuccess() {
    steps.openSite(Constants.URL, driver);
    steps.movePersonalAccount();
    steps.inputCorrectRegistrationData(Constants.TEST_USER_NAME, Constants.TEST_USER_EMAIL, Constants.TEST_USER_PASSWORD);
    steps.loginPersonalAccount();
    Assert.assertTrue(steps.isMakeOrderButtonExists());
    deleteTestData();
  }



  /**
   * Метод находит accessToken созданного пользователя, и в случае нахождения, вызывает его удаление
   * через api
   */
  private void deleteTestData() {
    WebStorage webStorage = (WebStorage) new Augmenter().augment(driver);
    LocalStorage localStorage = webStorage.getLocalStorage();
    String accessToken = localStorage.getItem("accessToken");
    if (accessToken != null) {
      steps.deleteUserStep(accessToken);
    }

  }
}
