import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import steps.Steps;
import util.WebDriverSetup;

public class BaseTest {

  protected WebDriver driver;
  protected Steps steps;

  @Before
  public void before() {
    driver = WebDriverSetup.getWebDriver("chrome");
    driver.manage().window().maximize();
    steps = new Steps();
  }

  @After
  public void after() {
    driver.quit();
  }
}
