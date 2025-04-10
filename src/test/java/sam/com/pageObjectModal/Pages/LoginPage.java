package sam.com.pageObjectModal.Pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import sam.com.constants.constants.ConfigData;
import sam.com.constants.constants.drivers.DriverManager;
import sam.com.constants.keywords.WebUI;


public class LoginPage extends CommonPage {
    public LoginPage() {
    }

    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By errorMessage = By.xpath("//div/span[normalize-space()='Invalid login credentials']");
    private By dashboardMebuBar = By.xpath("(//div[@class='sidemnenu mb-3']//ul//li)[1]");
    private By popup = By.xpath("//div[@class='modal-content position-relative border-0 rounded-0']/button");


    public void enterEmail(String email) {
        DriverManager.getDriver().findElement(inputEmail).sendKeys(email);

    }

    public void enterPassword(String password) {
        DriverManager.getDriver().findElement(inputPassword).sendKeys(password);

    }

    public void clickLoginButton() {
        DriverManager.getDriver().findElement(buttonLogin).click();
    }

    public void clickPopup() {
        DriverManager.getDriver().get(ConfigData.URL);
        WebUI.waitForPageLoaded();
        DriverManager.getDriver().findElement(popup).click();
    }

    public ManageProfilePage loginCMS(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
        return new ManageProfilePage();
    }

    public DashboardPage loginCmsToDashboard(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
        return new DashboardPage();
    }

    public void verifyLoginCMSSuccess() {
        WebUI.waitForPageLoaded();
        Assert.assertEquals(DriverManager.getDriver().getCurrentUrl(), "https://cms.anhtester.com/profile", "Fail.The current Url not matching");
        Assert.assertTrue(DriverManager.getDriver().findElement(dashboardMebuBar).isDisplayed(), "Fail.The Dashboard is not displayed");
    }

    public void verifyLoginCMSFail() {
        WebUI.waitForPageLoaded();
        Assert.assertTrue(DriverManager.getDriver().findElement(errorMessage).isDisplayed(), "Fail.The error message is not displayed");
    }

}
