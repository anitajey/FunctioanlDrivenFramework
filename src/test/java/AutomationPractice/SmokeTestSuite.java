package AutomationPractice;

import org.junit.Assert;
import org.junit.Test;

public class SmokeTestSuite extends AutomationPractice.BaseTest {
    //testcase-1 test data
    static String email1 = "sri@testmail.com";
    static String title = "Mr";
    static String firstName = "test";
    static String lastName = "test";
    static String dobDay = "12  ";
    static String dobMonth = "May ";
    static String dobYear = "1984  ";
    static String stateName = "Alabama";

    //testcase-2 test data
    static String email2 = "sri2@testmail.com";
    static String title2 = "Mr";
    static String firstName2 = "test";
    static String lastName2 = "test";
    static String dobDay2 = "15  ";
    static String dobMonth2 = "July ";
    static String dobYear2 = "1984  ";
    static String stateName2 = "Alaska";

    //testcase-4 test data
    static String productName;



    //Verify that user will see validation messages on the registration page, when mandatory fields are missing
    @Test
    public void verifyThatUserCanSeeValidationMessages() {
        //verify that user is on the homepage
        Assert.assertTrue(automationLibrary.isUserOnHomePage());
        //verify the home page title
        Assert.assertEquals("My Store",Utils.getPageTitle());
        automationLibrary.navigateToRegisterPage();
//        vi. Verify that user is on the Authentication page - TODO
        Assert.assertTrue(automationLibrary.isuserOnAuthenticationPage());
        automationLibrary.enterEmailAndContinue(email1);
//        ix. Verify that user is on the registration page
        Assert.assertTrue(automationLibrary.isUserOnRegistrationPage());
        automationLibrary.selectTitle(title2);
        automationLibrary.enterFirstName(firstName2);
        automationLibrary.enterLastName(lastName2);
        automationLibrary.enterDOB(dobDay2,dobMonth2,dobYear2);
        automationLibrary.selectNewsLetter();
        automationLibrary.selectState(stateName2);
        automationLibrary.submitRegistrationForm();
//        xii.  Verify that user will see validation messages on the page
//        Assert.assertEquals("There are 5 errors", automationLibrary.getErrorMessage());
        Assert.assertTrue(automationLibrary.getErrorMessage().contains("There are 5 errors"));
    }

    @Test
    public void verifyThatUserCannotRegisterWithInvalidData() {
        automationLibrary.navigateToRegisterPage();
//        vi. Verify that user is on the Authentication page - TODO
        automationLibrary.enterEmailAndContinue(email1);
//        ix. Verify that user is on the registration page - TODO
        automationLibrary.selectTitle(title);
        automationLibrary.enterFirstName(firstName);
        automationLibrary.enterLastName(lastName);
        automationLibrary.enterDOB(dobDay, dobMonth, dobYear);
        automationLibrary.selectNewsLetter();
        automationLibrary.selectState(stateName);
        automationLibrary.submitRegistrationForm();
//        xii.  Verify that user will see validation messages on the page
    }
    @Test
    public void userLogin(){
        //verify that user is on the homepage
        Assert.assertTrue(automationLibrary.isUserOnHomePage());
        //verify the home page title
        Assert.assertEquals("My Store",Utils.getPageTitle());
        //navigate to Login page
        automationLibrary.navigateToRegisterPage();
        automationLibrary.enterEmailAndPasswordAndContinue(username,password);
    }

    @Test
    public void searchProduct(){
        automationLibrary.navigateToRegisterPage();
        automationLibrary.enterEmailAndPasswordAndContinue(username,password);
        //verify user is on My Account Page
        Assert.assertTrue(automationLibrary.isUserOnMyAccountPage());
        //verify My Account page title
        Assert.assertEquals("My account - My Store",Utils.getPageTitle());
        //Search a product
        automationLibrary.searchProduct("Shirts");
        Assert.assertTrue(automationLibrary.isUseOnSearchMyStorePage());
        Assert.assertEquals("Search - My Store",Utils.getPageTitle());

    }

    @Test
    public void addToCart(){
        automationLibrary.navigateToRegisterPage();
        automationLibrary.enterEmailAndPasswordAndContinue(username,password);
        automationLibrary.searchProduct("Dresses");
        Assert.assertTrue(automationLibrary.isUseOnSearchMyStorePage());
        Assert.assertEquals("Search - My Store",Utils.getPageTitle());
        automationLibrary.addToCart();
    }

}
