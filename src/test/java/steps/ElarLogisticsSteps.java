package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ElarLogisticsLoginPage;
import pages.ElarLogisticsMainPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

public class ElarLogisticsSteps {

    WebDriver driver = Driver.getDriver();
    ElarLogisticsLoginPage elarLogisticsLoginPage = new ElarLogisticsLoginPage();
    ElarLogisticsMainPage elarLogisticsMainPage = new ElarLogisticsMainPage();

    @Given("user navigates to elar logistics app")
    public void user_navigates_to_elar_logistics_app() {
        driver.get(ConfigReader.getProperty("elarlogisticsURL"));
    }

    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        elarLogisticsLoginPage.usernameInput.sendKeys(username);
        elarLogisticsLoginPage.passwordInput.sendKeys(password);
        elarLogisticsLoginPage.loginBtn.click();
    }

    @Then("user validates successful login with home page message {string}")
    public void user_validates_successful_login_with_home_page_message(String welcomeMsg) {
        Assert.assertEquals(welcomeMsg, elarLogisticsMainPage.welcomeMsg.getText());
    }

    @Then("user validates error message is displayed {string}")
    public void user_validates_error_message_is_displayed(String invalidMsg) {
        BrowserUtils.waitForElementToBeClickable(elarLogisticsLoginPage.invalidMsg);
        Assert.assertEquals(invalidMsg, elarLogisticsLoginPage.invalidMsg.getText());
    }

    @When("user clicks on show password button")
    public void user_clicks_on_show_password_button() {
        elarLogisticsLoginPage.hidePWBtn.click();
    }

    @Then("user validates password is shown with type attribute {string}")
    public void user_validates_password_is_shown_with_type_attribute(String attribute) {
        Assert.assertEquals(attribute, elarLogisticsLoginPage.passwordInput.getAttribute("type"));
    }

    @When("user clicks on hide password button")
    public void user_clicks_on_hide_password_button() {
        elarLogisticsLoginPage.hidePWBtn.click();
    }

    @Then("user validates password is hidden with type attribute {string}")
    public void user_validates_password_is_hidden_with_type_attribute(String attribute) {
        Assert.assertEquals(attribute, elarLogisticsLoginPage.passwordInput.getAttribute("type"));
    }
}
