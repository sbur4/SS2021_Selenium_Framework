package pageObjects;

import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.logging.Logger;

import static driver.DriverFactory.webDriver;


public class TrainingListPage extends AbstractPage {

    private static final java.util.logging.Logger LOG = Logger.getLogger(String.valueOf(TrainingListPage.class));

    /**
     * private By realStoriesButton = By.xpath("//a[contains(@href,'#!/News/Category/real-stories')]");
     * private By materialsButton = By.xpath("//a[contains(@href,'#!/News/Category/materials')]");
     * private By hardSkillsButton = By.xpath("//a[contains(@href,'#!/News/Category/hard-skills')]");
     * private By softSkillsButton = By.xpath("//a[contains(@href,'#!/News/Category/soft-skills')]");
     * private By eventButton = By.xpath("//a[contains(@href, '#!/News/Category/events')]");
     */

    private static By findTrainings = By.xpath("//h1[contains(.,'TRAINING') and @class='section-ui__title ng-binding']");
    private static By searchInput = By.xpath("//input[@type='text']");
    private static By cleanLocation = By.xpath("//span[@class='filter-field__input-item-close-icon filter-field__input-item-close-icon--common']//parent::div[contains(., 'Selected locations')]//child::span");
    private static By selectUkraine = By.xpath("//div[contains(., 'Ukraine') and @class[contains(., 'location__not-active-label city-name ng-binding location__location-active-label location__location-active-label-country')]]");
    private static By selectLviv = By.xpath("//label[contains(., 'Lviv') and @class[contains(., 'city__item-not-active-label')]]//child::span");
    private static By bySkills = By.xpath("//div[@class='drop-down-choose__header']//child::div[contains(., 'By skills')]");
    private static By selectJava = By.xpath("//label[contains(.,'Java')]//child::span[@class='checkmark']");//
    private static By selectRuby = By.xpath("//label[contains(.,'Ruby')]//child::span[@class='checkmark']"); //
    private static By verifyJava = By.xpath("//span[@class='filter-field__input-item-name ng-binding']");
    private static By containsUkraine = By.xpath("//div[@class='training-list__container training-list__desktop']//div[@class='training-item__location']//following-sibling::span[@class='training-item__location--text ng-binding ng-scope' or contains(., 'Ukraine')]");
    private static By containsMultilocation = By.xpath("//div[@class='rd-tooltip']//div[contains(., 'Multi-location')]");

    private By noTrainingsMessage = By.xpath("//span[text()='Subscribe for training updates. We will let you know when the training you chose starts.']");

    private HomePage homePage;
    private SignInPage signInPage;

    public void HomePage() {
        homePage = new HomePage();
    }

    public void SignInPage() {
        signInPage = new SignInPage();
    }


    public TrainingListPage trainingListPage(String mail, String password) {
        homePage.proceedToHomePage();
        signInPage.signInWithGoogle()
                .enterEmail(mail)
                .clickContinueButton()
                .enterPassword(password)
                .clickSignInButton();
        homePage.openTrainingListPage();
        return new TrainingListPage();
    }

    public TrainingListPage scrollToTrainings() {
        WebElement scrollTo = getElement(searchInput);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", scrollTo);
        LOG.info("Scroll to 'Input'");
        getElement(cleanLocation).click();
        LOG.info("Clean 'Input'");
        getElement(searchInput).click();
        LOG.info("Select 'Input'");
        getElement(bySkills).click();
        LOG.info("Select 'By skills'");
        return this;
    }

    public TrainingListPage selectJava() {
        getElement(selectJava).click();
        LOG.info("Select 'Java'");
        getElement(searchInput).click();
        LOG.info("Hide panel");
        return this;
    }

    public TrainingListPage unSelectJava() {
        getElement(searchInput).click();
        LOG.info("Show panel");
        getElement(selectJava).click();
        LOG.info("Unselect 'Java'");
        return this;
    }

    public TrainingListPage selectRuby() {
        getElement(selectRuby).click();
        LOG.info("Select 'Ruby'");
        getElement(searchInput).click();
        LOG.info("Hide panel");
        return this;
    }

    // Verify that Search results with ‘Java’ word only are returned
    public boolean isJavaResultDisplayed() {
        boolean isDisplayed = isDisplayed(verifyJava);
        LOG.info(String.format("'Java' is displayed: '%s'", isDisplayed));
        return isDisplayed;
    }

    public String getJavaResult() {
        return getElement(verifyJava).getText();
    }

    public void verifyJavaResult() {
        Assert.assertTrue(isJavaResultDisplayed(), "'Java' haven't displayed");
    }

    // Verify that ‘No trainings available’ message is displayed
    public boolean verifyTrainingListPageIsDisplayed() {
        Assert.assertTrue(verifyTrainingListPageIsDisplayed(),
                "'TrainingList page haven't appeared");
        return false;
    }

    public boolean isNoTrainingsMessageDisplayed() {
        boolean isDisplayed = isDisplayed(noTrainingsMessage);
        LOG.info(String.format("Is 'No Trainings' message displayed': '%s'", isDisplayed));
        return isDisplayed;
    }

    public void verifyNoTrainingsMessageDisplayed() {
        Assert.assertTrue(isNoTrainingsMessageDisplayed(),
                "'No Trainings' message is not displayed");
    }

    // Verify that returned search results are ones with ‘Ukraine’ or ‘Multi location’ labels only
    public void findCity() {
        WebElement scrollTo = getElement(searchInput);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", scrollTo);
        LOG.info("Scroll to 'Input'");
        getElement(cleanLocation).click();
        LOG.info("Clean 'Input'");
        getElement(searchInput).click();
        LOG.info("Select 'Input'");
        getElement(selectUkraine).click();
        LOG.info("Select 'Ukraine'");
        getElement(selectLviv).click();
        LOG.info("Select 'Lviv'");
        getElement(searchInput).click();
        LOG.info("Hide panel");
    }
}
