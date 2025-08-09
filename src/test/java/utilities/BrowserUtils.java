package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

public class BrowserUtils {

    /**
     * Creates a Select object and selects an option based on the provided "value" parameter
     * @param dropdown
     * @param value
     */
    public static void selectByValue(WebElement dropdown, String value){
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    /**
     * Waits for provided webelement to be clickable
     * @param element
     */
    public static  void waitForElementToBeClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Scrolls the page until the provided element is in view
     */
    public static  void scrollToBottom(){
        JavascriptExecutor jse = ((JavascriptExecutor) Driver.getDriver());
        jse.executeScript("window.scrollBy(0,document.body.scrollHeight");
    }

    /**
     * Takes a screenshot of the browser at the moment of execution
     * @param fileName
     * @throws IOException
     */
    public static void takeScreenshot(String fileName) throws IOException {
        String path = "src/test/resources/screenshots/" + fileName + ".png";
        File screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        File file = new File(path);
        FileUtils.copyFile(screenshot, file);
    }

    /**
     * Generates a random email using the provided firstName and lastName paramenters
     * @param firstName
     * @param lastName
     * @return
     */
    public static String randomEmailGenerator(String firstName, String lastName){
        Random random = new Random();
        int randomNum = random.nextInt(99999);
        String email = randomNum+firstName+"."+lastName+"@gmail.com";
        System.out.println(email);
        return email;
    }

    /**
     * Generates a UUID random email
     * @return
     */
    public static String uuidEmailGenerator(){
        UUID uuid = UUID.randomUUID();
        return "user-" + uuid + "@gmail.com";
    }

    /**
     * Generates a UUID random ID
     * @return
     */
    public static String uuidIDGenerator(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    /**
     *
     */
    public static void removeGoogleAds(){
        JavascriptExecutor jse = ((JavascriptExecutor) Driver.getDriver());
        jse.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
    }

    /**
     * Scrolls the page using the provided pixel count
     * @param pixels
     */
    public static void scrollBy(Integer pixels){
        JavascriptExecutor jse = ((JavascriptExecutor) Driver.getDriver());
        jse.executeScript("window.scrollBy(0,"+pixels+")", "");
    }

}
