package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.logging.Logger;

public class FAQPage extends AbstractPage {

    private static final java.util.logging.Logger LOG = Logger.getLogger(String.valueOf(FAQPage.class));

    private final By faqButton = By.xpath("//a[contains(@href,'/#!/FAQ') and @class='main-nav__item']//self::a");

    private HomePage homePage;

    public void HomePage() {
        homePage = new HomePage();
    }

    public FAQPage() {
        FAQPage faqPage = new FAQPage();
    }

    public FAQPage faqPage() {
        homePage.proceedToHomePage()
                .openFAQPage();
        return new FAQPage();
    }

    public boolean verifyFAQPageIsDisplayed() {
        Assert.assertTrue(verifyFAQPageIsDisplayed(),
                "'FAQ' is not appeared");
        return false;
    }
}
