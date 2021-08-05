package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.logging.Logger;

public class SignInPage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(String.valueOf(SignInPage.class));

    private By google = By.id("zocial-google");
    private By mailInput = By.id("identifierId");
    private By continueButton = By.id("button");
    private By passwordInput = By.id("password");
    private By signInButton = By.id("button");

    private By loginFailedErrorMessage = By.xpath("//span[text()=\"We can't find user with such credentials.\"]");

    public SignInPage signInWithGoogle() {
        getElement(google).click();
        LOG.info("Enter to check Google account.");
        return this;
    }

    public SignInPage enterEmail(String email) {
        getElement(mailInput).sendKeys(email);
        LOG.info("Mail was entered.");
        return this;
    }

    public SignInPage clickContinueButton() {
        getElement(continueButton).click();
        LOG.info("Continue button clicked.");
        return this;
    }

    public SignInPage enterPassword(String password) {
        getElement(passwordInput).sendKeys(password);
        LOG.info("Password was entered.");
        return this;
    }

    public HomePage clickSignInButton() {
        getElement(signInButton).click();
        LOG.info("Sign in button clicked.");
        return new HomePage();
    }

    public boolean isLoginFailedErrorMessageDisplayed() {
        boolean isDisplayed = isDisplayed(loginFailedErrorMessage);
        LOG.info(String.format("Is 'Login Failed' error message displayed': '%s'", isDisplayed));
        return isDisplayed;
    }

    public void verifyFailedLoginErrorMessageDisplayed() {
        Assert.assertTrue(isLoginFailedErrorMessageDisplayed(),
                "'Login failed' error message is not displayed");
    }

}
