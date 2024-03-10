import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import steps.Steps;
import util.Constants;
import util.WebDriverSetup;

public class BaseTest {

  protected WebDriver driver;
  protected Steps steps;

  /**
   * Метод находит accessToken созданного пользователя, и в случае нахождения, вызывает его удаление
   * через api
   */
  protected void deleteTestData() {
    WebStorage webStorage = (WebStorage) new Augmenter().augment(driver);
    LocalStorage localStorage = webStorage.getLocalStorage();
    String accessToken = localStorage.getItem("accessToken");
    if (accessToken != null) {
      steps.deleteUserStep(accessToken);
    }
  }

  @Before
  public void before() {
    driver = WebDriverSetup.getWebDriver("chrome");
    driver.manage().window().maximize();
    steps = new Steps();
    steps.openSite(Constants.URL, driver);
  }

  @After
  public void after() {
    driver.quit();
  }
}
