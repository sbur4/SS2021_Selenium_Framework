package constants;

public enum DriverConfigs {

    CHROME_NAME("webdriver.chrome.driver"),
    FIREFOX_NAME("webdriver.gecko.driver"),
    EDGE_NAME("webdriver.EDGE.driver"),
    CHROME_DRIVER_LOCATION("src/main/resources/chromedriver_92.exe"),
    FIREFOX_DRIVER_LOCATION("src/main/resources/gecodriver_29.exe"),
    EDGE_DRIVER_LOCATION("src/main/resources/msedgeriver_92.exe"),
    DEFAULTBROWSER("CHROME_NAME");
    public static final int IMPLICITY_WAIT_VALUE = 5;

    DriverConfigs(String dc) {
    }
}