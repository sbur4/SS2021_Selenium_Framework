package pageObjects;

import constants.BusinessConfigs;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.logging.Logger;

public class BlogPage extends AbstractPage {

    private static final java.util.logging.Logger LOG = Logger.getLogger(String.valueOf(BlogPage.class));

    private By newsButton = By.xpath("//a[contains(@href,'#!/News/Category/news')]");
    private By realStoriesButton = By.xpath("//a[contains(@href,'#!/News/Category/real-stories')]");
    private By materialsButton = By.xpath("//a[contains(@href,'#!/News/Category/materials')]");
    private By hardSkillsButton = By.xpath("//a[contains(@href,'#!/News/Category/hard-skills')]");
    private By softSkillsButton = By.xpath("//a[contains(@href,'#!/News/Category/soft-skills')]");
    private By eventButton = By.xpath("//a[contains(@href, '#!/News/Category/events')]");

    private HomePage homePage;
    private SignInPage signInPage;
    private Object blogPageUrl;

    public void HomePage() {
        homePage = new HomePage();
    }

    public void SignInPage() {
        signInPage = new SignInPage();
    }

    public BlogPage blogPage(String mail, String password) {
        homePage.proceedToHomePage();
        signInPage.signInWithGoogle()
                .enterEmail(mail)
                .clickContinueButton()
                .enterPassword(password)
                .clickSignInButton();
        homePage.openBlogPage();
        return new BlogPage();
    }

    public boolean isBlogPageDisplayed(By blogPageUrl) {
        boolean isDisplayed = isDisplayed(blogPageUrl);
        LOG.info(String.format("'Blog' page is displayed: '%s'", isDisplayed));
        return isDisplayed;
    }

    public String getBlogPageLink(BusinessConfigs blogPageUrl) {
        return getBlogPageLink(BusinessConfigs.BLOG_PAGE_URL);
    }

    public void verifyBlogPageIsDisplayed() {
        Assert.assertTrue(isBlogPageDisplayed((By) blogPageUrl), "'Blog' page haven't appeared");
    }

    public boolean isNewsButtonDisplayed() {
        boolean isDisplayed = isDisplayed(newsButton);
        LOG.info(String.format("'News' button is displayed: '%s'", isDisplayed));
        return isDisplayed;
    }

    public String getNewsButton() {
        return getElement(newsButton).getText();
    }

    public boolean verifyNewsButtonIsDisplayed() {
        Assert.assertTrue(verifyNewsButtonIsDisplayed(), "'News' button haven't displayed");
        return false;
    }

    public boolean isRealStoriesButtonDisplayed() {
        boolean isDisplayed = isDisplayed(realStoriesButton);
        LOG.info(String.format("'Real Stories' button is displayed: '%s'", isDisplayed));
        return isDisplayed;
    }

    public String getRealStoriesButton() {
        return getElement(realStoriesButton).getText();
    }

    public boolean verifyRealStoriesButtonIsDisplayed() {
        Assert.assertTrue(verifyRealStoriesButtonIsDisplayed(), "'Real Stories' button haven't displayed");
        return false;
    }

    public boolean isMaterialsButtonDisplayed() {
        boolean isDisplayed = isDisplayed(materialsButton);
        LOG.info(String.format("'Materials' button is displayed: '%s'", isDisplayed));
        return isDisplayed;
    }

    public String getMaterialsButton() {
        return getElement(materialsButton).getText();
    }

    public boolean verifyMaterialsButtonIsDisplayed() {
        Assert.assertTrue(verifyMaterialsButtonIsDisplayed(), "'Materials' button haven't displayed");
        return false;
    }

    public boolean isHardSkillsButtonDisplayed() {
        boolean isDisplayed = isDisplayed(hardSkillsButton);
        LOG.info(String.format("'Hard Skills' button is displayed: '%s'", isDisplayed));
        return isDisplayed;
    }

    public String getHardSkillsButton() {
        return getElement(hardSkillsButton).getText();
    }

    public boolean verifyHardSkillsButtonIsDisplayed() {
        Assert.assertTrue(verifyHardSkillsButtonIsDisplayed(), "'Hard Skills' button haven't displayed");
        return false;
    }

    public boolean isSoftSkillsButtonDisplayed() {
        boolean isDisplayed = isDisplayed(softSkillsButton);
        LOG.info(String.format("'Soft Skills' button is displayed: '%s'", isDisplayed));
        return isDisplayed;
    }

    public String getSoftSkillsButton() {
        return getElement(softSkillsButton).getText();
    }

    public boolean verifySoftSkillsButtonIsDisplayed() {
        Assert.assertTrue(verifySoftSkillsButtonIsDisplayed(), "'Soft Skills' button haven't displayed");
        return false;
    }

    public boolean isEventButtonDisplayed() {
        boolean isDisplayed = isDisplayed(eventButton);
        LOG.info(String.format("'Event' button is displayed: '%s'", isDisplayed));
        return isDisplayed;
    }

    public String getEventButton() {
        return getElement(eventButton).getText();
    }

    public boolean verifyEventButtonIsDisplayed() {
        Assert.assertTrue(verifyEventButtonIsDisplayed(), "'Event' button haven't displayed");
        return false;
    }

}