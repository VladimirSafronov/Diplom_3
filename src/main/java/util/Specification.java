package util;

import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Specification {

  /**
   * Создание базовых параметров запроса
   */
  private static RequestSpecification requestSpec() {
    PropertiesLoader propertiesLoader = new PropertiesLoader();

    return new RequestSpecBuilder()
        .setBaseUri(propertiesLoader.getUrl())
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

  public static Response doPostRequest(String path, Object body) {
    return given()
        .spec(requestSpec())
        .body(body)
        .when()
        .post(path)
        .thenReturn();
  }
}
