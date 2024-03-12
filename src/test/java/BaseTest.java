import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import steps.Steps;
import util.PropertiesLoader;
import util.WebDriverSetup;

public class BaseTest {

  protected WebDriver driver;
  protected Steps steps;
  public PropertiesLoader propertiesLoader;

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
    propertiesLoader = new PropertiesLoader();
    propertiesLoader.getProperties();
    driver = WebDriverSetup.getWebDriver(propertiesLoader.getBrowserName(),
        propertiesLoader.getYandexBrowserPath());
    driver.manage().window().maximize();
    steps = new Steps();
    steps.openSite(propertiesLoader.getUrl(), driver);
  }

  @After
  public void after() {
    driver.quit();
  }
}
