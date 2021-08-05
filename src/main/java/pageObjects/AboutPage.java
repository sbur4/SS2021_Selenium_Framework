package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.logging.Logger;

public class AboutPage extends AbstractPage {

    private static final java.util.logging.Logger LOG = Logger.getLogger(String.valueOf(AboutPage.class));

    private final By aboutButton = By.xpath("//a[contains(@href,'/#!/About') and @class='main-nav__item']//self::a");


    private HomePage homePage;

    public void HomePage() {
        homePage = new HomePage();
    }

    public AboutPage() {
        AboutPage aboutPage = new AboutPage();
    }

    public AboutPage aboutPage() {
        homePage.proceedToHomePage()
                .openAboutPage();
        return new AboutPage();
    }

    public boolean verifyAboutPageIsDisplayed() {
        Assert.assertTrue(verifyAboutPageIsDisplayed(),
                "'About' page is not displayed");
        return false;
    }
}
