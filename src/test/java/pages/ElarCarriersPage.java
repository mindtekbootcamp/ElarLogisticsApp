package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ElarCarriersPage {
    WebDriver driver;
    public ElarCarriersPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Add carrier']")
    public WebElement addCarrierBtn;
}
