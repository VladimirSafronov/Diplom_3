import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import util.Constants;

public class ConstructorTest extends BaseTest {

  @Test
  @DisplayName("Check move to souse")
  @Description("Проверка работы перехода к разделу Соусы")
  public void clickSouseThenElementLight() {
    steps.clickElementMainPage(Constants.SOUSES_LINK);
    Assert.assertTrue(steps.isElementLight(Constants.SOUSES_LINK));
  }

  @Test
  @DisplayName("Check move to buns")
  @Description("Проверка работы перехода к разделу Булки")
  public void clickBunThenElementLight() {
    steps.clickElementMainPage(Constants.SOUSES_LINK);
    steps.clickElementMainPage(Constants.BUNS_LINK);
    Assert.assertTrue(steps.isElementLight(Constants.BUNS_LINK));
  }

  @Test
  @DisplayName("Check move to fillings")
  @Description("Проверка работы перехода к разделу Начинки")
  public void clickFillingsThenElementLight() {
    steps.clickElementMainPage(Constants.FILLINGS_LINK);
    Assert.assertTrue(steps.isElementLight(Constants.FILLINGS_LINK));
  }
}
