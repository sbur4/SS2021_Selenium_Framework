package driver;

import constants.DriverConfigs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static constants.DriverConfigs.*;

public abstract class DriverFactory {

    public static WebDriver webDriver;

    protected void initDriver(String DEFAULTBROWSER) {
        switch (DriverConfigs.DEFAULTBROWSER) {
            case CHROME_NAME:
                System.setProperty(String.valueOf(DriverConfigs.CHROME_NAME), String.valueOf(DriverConfigs.CHROME_DRIVER_LOCATION));
                webDriver = new ChromeDriver();
                break;
            case FIREFOX_NAME:
                System.setProperty(String.valueOf(DriverConfigs.FIREFOX_NAME), String.valueOf(FIREFOX_DRIVER_LOCATION));
                webDriver = new FirefoxDriver();
                break;
            case EDGE_NAME:
                System.setProperty(String.valueOf(DriverConfigs.EDGE_NAME), String.valueOf(DriverConfigs.EDGE_DRIVER_LOCATION));
                webDriver = new EdgeDriver();
                break;
            default:
                Assert.fail("Incorrect browser name");
        }
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(DriverConfigs.IMPLICITY_WAIT_VALUE, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        return webDriver;
    }

    protected void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
