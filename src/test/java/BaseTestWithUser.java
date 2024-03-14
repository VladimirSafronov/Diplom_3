import static util.Constants.TEST_USER_EMAIL;
import static util.Constants.TEST_USER_NAME;
import static util.Constants.TEST_USER_PASSWORD;

import dto.CreatedUser;
import dto.User;
import org.apache.http.HttpStatus;
import org.junit.After;
import org.junit.Before;

public class BaseTestWithUser extends BaseTest {

  protected CreatedUser createdUser;

  @Before
  public void setTestData() {
    User user = new User(TEST_USER_EMAIL, TEST_USER_NAME, TEST_USER_PASSWORD);
    createdUser = steps.createUserStep(user)
        .then()
        .statusCode(HttpStatus.SC_OK)
        .extract().as(CreatedUser.class);
  }

  @After
  public void cleanTestData() {
    steps.deleteUserStep(createdUser.getAccessToken());
  }
}
