package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.logging.Logger;

import static constants.BusinessConfigs.HOME_PAGE_URL;

public class HomePage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(String.valueOf(HomePage.class));

    private final By trainingListPageButton = By.xpath("//a[contains(@href,'/#!/TrainingList') and @class='main-nav__item']");
    private final By aboutPageButton = By.className("//a[contains(@href,'/#!/About') and @class='main-nav__item']");
    private final By blogPageButton = By.className("//a[contains(@href,'/#!/News') and @class='main-nav__item']");
    private final By FAQPageButton = By.xpath("//a[contains(@href,'/#!/FAQ') and @class='main-nav__item']");
    private final By signInButton = By.className("header-auth__signin");
    private final By topRightCornerUserNameElement = By.className("user-info__name");

    public HomePage proceedToHomePage() {
        proceedToPage();
        LOG.info(String.format("Proceeded to '%s' URL.", HOME_PAGE_URL));
        return this;
    }

    public TrainingListPage openTrainingListPage() {
        getElement(trainingListPageButton).click();
        LOG.info("Open 'Training List' page.");
        return new TrainingListPage();
    }

    public AboutPage openAboutPage() {
        getElement(aboutPageButton).click();
        LOG.info("Open 'About' page.");
        return new AboutPage();
    }

    public BlogPage openBlogPage() {
        getElement(blogPageButton).click();
        LOG.info("Open 'Blog' page.");
        return new BlogPage();
    }

    public FAQPage openFAQPage() {
        getElement(FAQPageButton).click();
        LOG.info("Open 'FAQ' page.");
        return new FAQPage();
    }

    public SignInPage clickSignInButton() {
        getElement(signInButton).click();
        LOG.info("'Sign in' button clicked");
        return new SignInPage();
    }

    public boolean isUserNameDisplayed() {
        boolean isDisplayed = isDisplayed(topRightCornerUserNameElement);
        LOG.info(String.format("User is logged in: '%s'", isDisplayed));
        return isDisplayed;
    }

    public String getLoggedInUserName() {
        return getElement(topRightCornerUserNameElement).getText();
    }

    public void verifyUserIsLoggedIn() {
        Assert.assertTrue(isUserNameDisplayed(), "User is not logged in");
    }
}
