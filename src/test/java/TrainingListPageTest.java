import dataProvider.ValidInput;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SignInPage;
import pageObjects.TrainingListPage;

public class TrainingListPageTest extends BaseTest {

    @Test(description = "Verify ‘Trainings’ search works properly with searching in ‘Skills’.")
    public void verifyTrainingsInSkills() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton();
        new SignInPage()
                .signInWithGoogle()
                .enterEmail(String.valueOf(ValidInput.CORRECTMAIL))
                .clickContinueButton()
                .enterPassword(String.valueOf(ValidInput.CORRECTPASS))
                .clickSignInButton()
                .verifyUserIsLoggedIn();
        new HomePage()
                .openTrainingListPage();
        new TrainingListPage()
                .scrollToTrainings()
                .selectJava()
                .verifyJavaResult();
        new TrainingListPage()
                .unSelectJava()
                .selectRuby()
                .verifyTrainingListPageIsDisplayed();
    }

    @Test(description = "Verify ‘Trainings’ search works properly with searching in ‘Locations’.")
    public void verifyTrainingsSearchInLocations() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton();
        new SignInPage()
                .signInWithGoogle()
                .enterEmail(String.valueOf(ValidInput.CORRECTMAIL))
                .clickContinueButton()
                .enterPassword(String.valueOf(ValidInput.CORRECTPASS))
                .clickSignInButton()
                .verifyUserIsLoggedIn();
        new HomePage()
                .openTrainingListPage();
        new TrainingListPage()
                .findCity();
                //
    }

}
