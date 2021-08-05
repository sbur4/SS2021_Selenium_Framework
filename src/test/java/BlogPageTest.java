import dataProvider.ValidInput;
import org.testng.annotations.Test;
import pageObjects.BlogPage;
import pageObjects.HomePage;
import pageObjects.SignInPage;

public class BlogPageTest extends BaseTest {


    @Test(description = "Verify links on ‘Blog’ Page.")
    public void verifyLinksOnBlog() {
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
        new BlogPage()
                .verifyBlogPageIsDisplayed();
    }

    @Test(description = "Verify ‘News’, ‘Real Stories, ‘Materials’, ‘Hard Skills’ , ‘Soft Skills’, ‘Events’ links are displayed.")
    public void verifyLinksTest() {
        new BlogPage()
                .verifyNewsButtonIsDisplayed();
        new BlogPage()
                .verifyRealStoriesButtonIsDisplayed();
        new BlogPage()
                .verifyMaterialsButtonIsDisplayed();
        new BlogPage()
                .verifyHardSkillsButtonIsDisplayed();
        new BlogPage()
                .verifySoftSkillsButtonIsDisplayed();
        new BlogPage()
                .verifyEventButtonIsDisplayed();
    }
}