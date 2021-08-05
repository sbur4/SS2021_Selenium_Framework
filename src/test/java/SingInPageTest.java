import dataProvider.InvalidInput;
import dataProvider.ValidInput;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.HomePage;
import pageObjects.SignInPage;

public class SingInPageTest extends BaseTest {

    private boolean recipientName;
    private boolean recipientName2;
    private boolean domianName;
    private boolean domianName2;
    private boolean domianName3;

    @Test(description = "Verify error messageappears when user logging in with inappropriate credentials.")
    public void verifyErrorMessageAppearsForIncorrectUser() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton();
        new SignInPage()
                .signInWithGoogle()
                .enterEmail(String.valueOf(InvalidInput.FIRSTWRONGMAIL))
                .clickContinueButton()
                .enterPassword(String.valueOf(InvalidInput.FIRSTINCORRECTPASS))
                .clickSignInButton();
        new SignInPage()
                .isLoginFailedErrorMessageDisplayed();
    }

    @Test(description = "Verify user is successfully logged in with appropriate credentials.")
    public void verifyUserIsSuccessfullyLoggedIn() {
        HomePage homePage = new HomePage();
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
                .isUserNameDisplayed();
    }

    @BeforeSuite
    public void before_suite() {
        System.out.println("'@' symbol must be present");
    }

    // Hard positive
    @Test(description = "'@' symbol must be present.")
    public void verifyMailContainsSymbol() {
        Assert.assertTrue(String.valueOf(ValidInput.CORRECTMAIL).contains("@"), "Email don't contains symbol '@'");
    }

    @Test(description = "With invalid value")
    public void verifyMail1() {
        Assert.assertTrue(String.valueOf(InvalidInput.FIRSTWRONGMAIL).contains("@"), "Email contains symbol '@'");
    }

    @AfterSuite
    public void after_suite() {
        System.out.println("Test case checked!");
    }

    @BeforeSuite
    public void before_suite2() {
        System.out.println("'@' symbol is not placed at the beginning of mail address (mail address without recipient name)");
    }

    // Hard negative
    @Test(description = "'@' symbol is not placed at the beginning of mail address (mail address without recipient name).")
    public void verifyMailContainsSymbolInTheBeginning() {
        Assert.assertFalse(String.valueOf(ValidInput.CORRECTMAIL).startsWith(String.valueOf('@')), "Email don't contains symbol '@' in the beginning");
    }

    @Test(description = "With invalid value")
    public void verifyMail2() {
        Assert.assertFalse(String.valueOf(InvalidInput.FOURTHWRONGMAIL).startsWith(String.valueOf('@')), "Email contains symbol '@' in the beginning");
    }

    @AfterSuite
    public void after_suite2() {
        System.out.println("Test case checked!");
    }

    @BeforeSuite
    public void before_suite3() {
        System.out.println("‘.’ – dot symbol must be present");
    }

    // Hard positive
    @Test(description = "‘.’ – dot symbol must be present.")
    public void verifyMailContainsDot() {
        Assert.assertTrue(String.valueOf(ValidInput.CORRECTMAIL).contains("."), "Email don't contains symbol '.'");
    }

    @Test(description = "With invalid value")
    public void verifyMail3() {
        Assert.assertTrue(String.valueOf(InvalidInput.THIRDWRONGMAIL).contains("."), "Email contains symbol '.'");
    }

    @AfterSuite
    public void after_suite3() {
        System.out.println("Test case checked!");
    }

    @BeforeSuite
    public void before_suite4() {
        System.out.println("recipient name (string before @ symbol – for example: name.surname@gmail.com) length may be a maximum of 64 characters");
    }

    public boolean checkRecipientName() {
        String emailValue = String.valueOf(ValidInput.CORRECTMAIL);
        int trimRecipientName = emailValue.substring(0, emailValue.indexOf("@")).length();
        boolean recipientName = trimRecipientName < 64;
        return recipientName;
    }

    // Boundary values
    @Test(description = "recipient name (string before @ symbol – for example: name.surname@gmail.com) length may be a maximum of 64 characters.")
    public void verifyRecipientName() {
        Assert.assertTrue(recipientName, "Recipient name length  aren't in boundary values");
    }

    public boolean checkRecipientName2() {
        String emailValue2 = String.valueOf(InvalidInput.FIFTHWRONGMAIL);
        int trimRecipientName2 = emailValue2.substring(0, emailValue2.indexOf("@")).length();
        boolean recipientName2 = trimRecipientName2 < 64;
        return recipientName2;
    }

    @Test(description = "With invalid value")
    public void verifyMail4() {
        Assert.assertTrue(recipientName2, "Recipient name length in boundary values");
    }

    @AfterSuite
    public void after_suite4() {
        System.out.println("Test case checked!");
    }

    @BeforeSuite
    public void before_suite5() {
        System.out.println("top-level domain length may be a minimum of 2 characters and maximum of 10");
    }

    public boolean checkDomainLength() {

        String emailValue = String.valueOf(ValidInput.CORRECTMAIL);
        int trimDomianName = emailValue.substring(emailValue.lastIndexOf('.') + 1).length();
        boolean domianName = trimDomianName >= 2 & 10 >= trimDomianName;
        return domianName;
    }

    //Soft Assertion negative
    @Test(description = "top-level domain length may be a minimum of 2 characters and maximum of 10.")
    public void softAssertTest() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(domianName, true, "Top-level domain length less than 2 symbols");
        softAssert.assertEquals(domianName, false, "Top-level domain length above  than 10 symbols");
        softAssert.assertAll();
    }

    public boolean checkDomainLength2() {

        String emailValue2 = String.valueOf(InvalidInput.SIXTHWRONGMAIL);
        int trimDomianName2 = emailValue2.substring(emailValue2.lastIndexOf('.') + 1).length();
        boolean domianName2 = trimDomianName2 >= 2 & 10 >= trimDomianName2;
        return domianName2;
    }

    public boolean checkDomainLength3() {

        String emailValue3 = String.valueOf(InvalidInput.SEVENTHWRONGMAIL);
        int trimDomianName3 = emailValue3.substring(emailValue3.lastIndexOf('.') + 1).length();
        boolean domianName3 = trimDomianName3 >= 2 & 10 >= trimDomianName3;
        return domianName3;
    }

    @Test(description = "With invalid value")
    public void softAssertTest2() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(domianName2, false, "Top-level domain length  above than 2 symbols");
        softAssert.assertEquals(domianName3, false, "Top-level domain length  less than 10 symbols");
        softAssert.assertAll();
    }

    @AfterSuite
    public void after_suite5() {
        System.out.println("Test case checked!");
    }

}
