package AutomationPractice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest extends BaseClass {

    public static AutomationLibrary automationLibrary;

    public void openBrowser(){
        //setting up the Chrome driver object
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //open the url
        driver.get(baseURL);
        //maximise the browser
        driver.manage().window().maximize();
    }

    @After
    public void closeBrowser(){
        driver.close();
    }

    @Before
    public void startBrowser(){
        openBrowser();
    }

    @BeforeClass
    public static void startUp(){
        automationLibrary = new AutomationLibrary();

    }

}

