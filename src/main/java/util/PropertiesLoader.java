package util;

import exceptions.PropertiesConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {

  private String url;
  private String browserName;
  private String yandexBrowserPath;
  Properties properties = new Properties();

  public void getProperties() {
    try (
        FileInputStream fileInputStream = new FileInputStream("config.properties")) {
      properties.load(fileInputStream);

      url = properties.getProperty("app.url");
      browserName = properties.getProperty("browser.name");
      yandexBrowserPath = properties.getProperty("yandex.browser.path");

    } catch (IOException ex) {
      throw new PropertiesConfigurationException(ex.getMessage());
    }
  }

  public String getUrl() {
    return url;
  }

  public String getBrowserName() {
    return browserName;
  }

  public String getYandexBrowserPath() {
    return yandexBrowserPath;
  }
}
