package com.rocketmiles.util;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * PropertyLoader class
 *
 */

public class PropertyLoader {

  private static final String DEFAULT_PROPERTIES = "/default.properties";

  public static Capabilities loadCapabilities() throws IOException {
    return loadCapabilities(System.getProperty("application.properties", DEFAULT_PROPERTIES));
  }

  public static Capabilities loadCapabilities(String propFile) throws IOException {
    Properties properties = new Properties();
    properties.load(PropertyLoader.class.getResourceAsStream(propFile));
    String capabilitiesFile = properties.getProperty("capabilities");

    Properties capabilitiesProps = new Properties();
    capabilitiesProps.load(PropertyLoader.class.getResourceAsStream(capabilitiesFile));

    DesiredCapabilities capabilities = new DesiredCapabilities();
    for (String name : capabilitiesProps.stringPropertyNames()) {
      String value = capabilitiesProps.getProperty(name);
      if (value.toLowerCase().equals("true") || value.toLowerCase().equals("false")) {
        capabilities.setCapability(name, Boolean.valueOf(value));
      } else if (value.startsWith("file:")) {
        capabilities.setCapability(name, new File(".", value.substring(5)).getCanonicalFile().getAbsolutePath());
      } else {
        capabilities.setCapability(name, value);
      }
    }
    return capabilities;
  }

  public static String loadProperty(String name) throws IOException {
    return loadProperty(name, System.getProperty("application.properties", DEFAULT_PROPERTIES));
  }

  public static String loadProperty(String name, String fromResource) throws IOException {
    Properties props = new Properties();
    props.load(PropertyLoader.class.getResourceAsStream(fromResource));
    return props.getProperty(name);
  }
}