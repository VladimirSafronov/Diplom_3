package pages;

/**
 * Page Object входа в личный кабинет
 */
public class PersonalAccountLoginPage {

  protected final String emailFieldXpath = ".//label[text()='Email']";
  protected final String passwordFieldXpath = ".//label[text()='Пароль']";
  private final String registrationLinkXpath = ".//a[text()='Зарегистрироваться']";

}
