package pages;

/**
 * Page Object регистрации
 */
public class RegistrationPage extends PersonalAccountLoginPage {

  private final String nameFieldXpath = ".//label[text()='Имя']";
  private final String registrationButtonXpath = ".//button[text()='Зарегистрироваться']";
}
