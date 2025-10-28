package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BrowserUtils;
import utilities.Driver;
@Getter

public class ElarCarriersPage {
    WebDriver driver;
    public ElarCarriersPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    private final By addCarrierBtnLocator = By.xpath("//button[text()='Add carrier']");

    @FindBy(xpath = "//button[text()='Add carrier']")
    public WebElement addCarrierBtn;

}
