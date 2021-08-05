package pageObjects;

import constants.BusinessConfigs;
import constants.DriverConfigs;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static driver.DriverFactory.*;

public class AbstractPage {

    private static final WebDriverWait wait = new WebDriverWait(getDriver(), DriverConfigs.IMPLICITY_WAIT_VALUE);

    AbstractPage() {
    }

    void proceedToPage() {
        getDriver().get(String.valueOf(BusinessConfigs.BASE_URL));
    }

    WebElement getElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    List<WebElement> getElements(By locator) {
        return getDriver().findElements(locator);
    }

    public boolean isDisplayed(By locator) {
        try {
            return getDriver().findElement(locator).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
}
