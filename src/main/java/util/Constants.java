package util;

import com.github.javafaker.Faker;

public class Constants {

  static Faker faker = new Faker();

  /**
   * Данные для тестового пользователя
   */
  public static final String TEST_USER_EMAIL = faker.internet().emailAddress();
  public static final String TEST_USER_PASSWORD = faker.internet().password(6, 10);
  public static final String TEST_USER_NAME = faker.name().firstName();

  /**
   * Названия кнопок
   */
  public static final String PERSONAL_ACCOUNT_BUTTON = "Личный кабинет";
  public static final String ENTER_ACCOUNT_BUTTON = "Войти в аккаунт";
  public static final String LOGOUT_BUTTON = "Выход";

  /**
   * Названия ссылок
   */
  public static final String REGISTRATION_LINK = "Зарегистрироваться";
  public static final String RECOVERY_PASSWORD_LINK = "Восстановить пароль";
  public static final String LOGIN_LINK = "Войти";
  public static final String CONSTRUCTOR_LINK = "Конструктор";
  public static final String LOGO_LINK = "Логотип";
  public static final String BUNS_LINK = "Булки";
  public static final String SOUSES_LINK = "Соусы";
  public static final String FILLINGS_LINK = "Начинки";
}
