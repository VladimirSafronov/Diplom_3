package util;

import static io.restassured.RestAssured.given;
import static util.Constants.URL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class Specification {

  /**
   * Создание базовых параметров запроса
   */
  private static RequestSpecification requestSpec() {
    return new RequestSpecBuilder()
        .setBaseUri(URL)
        .setContentType("application/json")
        .addFilter(new RequestLoggingFilter())
        .addFilter(new ResponseLoggingFilter())
        .build();
  }

  public static void doDeleteRequest(String path, String accessToken) {
    given()
        .spec(requestSpec())
        .header("Authorization", accessToken)
        .when()
        .delete(path)
        .thenReturn();
  }
}
