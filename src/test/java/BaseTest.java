import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import util.WebDriverSetup;

public class BaseTest {

  protected WebDriver driver;

  @Before
  public void before() {

    driver = WebDriverSetup.getWebDriver("chrome");

    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
  }

  @Test
  public void test() {
    driver.navigate().to("https://stellarburgers.nomoreparties.site/");
  }

  @After
  public void after() {
    driver.quit();
  }
}
