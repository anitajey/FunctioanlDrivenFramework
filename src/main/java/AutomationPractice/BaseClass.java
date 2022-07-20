package AutomationPractice;

import org.openqa.selenium.WebDriver;

public class BaseClass{
    //Global tet data and global methods
    //Global Test Data
    static String baseURL = "http://automationpractice.com/index.php";
    static String username = "testaccount123@mailinator.com";
    static String password = "Password123";
    static String browser = "chrome";

    //Instantiate the webdriver object
    public static WebDriver driver;


}
