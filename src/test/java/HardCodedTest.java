import dataProvider.ValidInput;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HardCodedTest {

    public static final CharSequence MAIL = ValidInput.CORRECTMAIL;
    private static final CharSequence PASS = ValidInput.CORRECTPASS;

    @Test(description = "Verify user is successfully logged in with appropriate credentials.")
    public void verifyUserIsSuccessfullyLoggedIn() {

        WebDriverManager.chromedriver().setup();

        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.get("https://training.by");

        try {
            WebElement clickSignIn = webDriver.findElement(By.className("header-auth__signin"));
            clickSignIn.click();
            WebElement enterUserGoogle = webDriver.findElement(By.id("zocial-google"));
            enterUserGoogle.click();
            WebElement enterUserMail = webDriver.findElement(By.id("identifierId"));
            enterUserMail.sendKeys(MAIL);
            String ActualEmail = String.valueOf(webDriver.findElements(By.tagName("data-initial-value")));
            String ExpectedEmail = "@email.com";
            Assert.assertTrue(ActualEmail.contains(ExpectedEmail));
            WebElement enterMailNext = webDriver.findElement(By.tagName("button"));
            enterMailNext.click();
            WebElement enterUserPass = webDriver.findElement(By.name("password"));
            enterUserPass.sendKeys(PASS);
            WebElement enterPassNext = webDriver.findElement(By.tagName("button"));
            enterPassNext.click();
            WebElement userName = webDriver.findElement(By.className("user-info__name"));
            Assert.assertTrue(userName.isDisplayed(), "Username is NOT displayed");

        } finally {
            webDriver.close();
            //webDriver.quit();
        }
    }
}
