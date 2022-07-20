package AutomationPractice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utils extends BaseClass {
    public static void selectUsingText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public static String getPageTitle() {
        String title = driver.getTitle();
        return title;
    }

    public static boolean isElementPresent(WebElement element) {

        return element.isDisplayed();
    }

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}




