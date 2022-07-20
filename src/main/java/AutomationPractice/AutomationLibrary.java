package AutomationPractice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class AutomationLibrary extends BaseClass{

    public boolean isuserOnAuthenticationPage() {
        WebElement authenticationPanel = driver.findElement(By.cssSelector("#authentication"));
        return authenticationPanel.isDisplayed();
    }

    public boolean isUserOnHomePage() {

        return driver.findElement(By.cssSelector("#home-page-tabs")).isDisplayed();
    }

    public boolean isUserOnMyAccountPage()  {

        return driver.findElement(By.className("info-account")).isDisplayed();
    }

    public boolean isUseOnSearchMyStorePage(){

        return driver.findElement(By.cssSelector("#uniform-selectProductSort")).isDisplayed();
    }


    public void navigateToRegisterPage() {

        //        iv. Select signIn link
        WebElement signInLink = driver.findElement(By.cssSelector(".login"));
        signInLink.click();
//        v. Wait for page load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void enterEmailAndPasswordAndContinue(String username,String password){
        //Enter the email address
        WebElement loginEmail = driver.findElement(By.cssSelector("#email"));
        loginEmail.sendKeys(username);
        //Enter the password
        WebElement loginPassword = driver.findElement(By.cssSelector("#passwd"));
        loginPassword.sendKeys(password);
        //Click on SignIn button
        WebElement signInBtn = driver.findElement(By.cssSelector("#SubmitLogin"));
        signInBtn.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void enterEmailAndContinue(String userEmail) {
        //        vii. Enter the email address and select create account button
        WebElement newAccountEmail = driver.findElement(By.cssSelector("#email_create"));
        newAccountEmail.sendKeys(userEmail);

        WebElement createAccountButton = driver.findElement(By.cssSelector("#SubmitCreate"));
        createAccountButton.click();
        //        viii. Wait for page load
//        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        Utils.sleep(20000);
    }

    public void selectTitle(String title) {
        //        x. Select the title
        if (title.equalsIgnoreCase("Mr")) {
            WebElement title1 = driver.findElement(By.cssSelector("#id_gender1"));
            title1.click();
        } else if (title.equalsIgnoreCase("Mrs")) {
            WebElement title2 = driver.findElement(By.cssSelector("#id_gender2"));
            title2.click();
        }
    }

    public void enterFirstName(String firstname) {
        //        Enter the first name
        WebElement firstNameField = driver.findElement(By.cssSelector("[name='customer_firstname']"));
        firstNameField.sendKeys(firstname);
    }

    public void enterLastName(String lastname) {
        //        Enter the last name
        WebElement lastNameField = driver.findElement(By.cssSelector("[name='customer_lastname']"));
        lastNameField.sendKeys(lastname);
    }
    public void enterDOB(String date, String month, String year) {
        Utils.selectUsingText(driver.findElement(By.cssSelector("#days")),date);
        Utils.selectUsingText(driver.findElement(By.cssSelector("#months")),month);
        Utils.selectUsingText(driver.findElement(By.cssSelector("#years")),year);
    }

    public void selectState(String state) {
        //        Select the state
        WebElement stateField = driver.findElement(By.cssSelector("#id_state"));
//        Select stateList = new Select(stateField);
//        stateList.selectByVisibleText(state);
        Utils.selectUsingText(stateField, state);
    }

    public void submitRegistrationForm() {
//        xi.  click register button
        WebElement registerButton = driver.findElement(By.cssSelector("#submitAccount"));
        registerButton.click();
    }

    public void selectNewsLetter() {
        WebElement newsLetterCheckBox = driver.findElement(By.cssSelector("#newsletter"));
        newsLetterCheckBox.click();
    }

    public boolean isUserOnRegistrationPage() {
        String pageheadingtext = driver.findElement(By.cssSelector(".page-heading")).getText();
        return pageheadingtext.contains("CREATE AN ACCOUNT");
    }

    public String getErrorMessage() {
        String alertMessage = driver.findElement(By.cssSelector(".alert.alert-danger")).getText();
        return alertMessage;
    }

    public void searchProduct(String productName){
        //Enter product in search textbox
        WebElement searchProdName = driver.findElement(By.cssSelector("#search_query_top"));
        searchProdName.sendKeys(productName);
        WebElement searchProd = driver.findElement(By.xpath("//button[@name='submit_search']"));
        searchProd.click();
    }

    public void addToCart(){
        //selecting the specific product
        WebElement selectProduct = driver.findElement(By.xpath("//img[@alt='Printed Summer Dress']"));
        selectProduct.click();
        //selecting the product color
        WebElement selectProductColor = driver.findElement(By.cssSelector("#color_13"));
        selectProductColor.click();
        WebElement selectProductSize = driver.findElement(By.cssSelector("#group_1"));
        Utils.selectUsingText(selectProductSize,"M");
        WebElement addToCartBtn = driver.findElement(By.cssSelector("#add_to_cart"));
        addToCartBtn.click();
    }


}


