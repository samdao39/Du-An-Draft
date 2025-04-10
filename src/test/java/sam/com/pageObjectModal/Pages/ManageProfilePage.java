package sam.com.pageObjectModal.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import sam.com.constants.constants.drivers.DriverManager;
import sam.com.constants.keywords.WebUI;

public class ManageProfilePage extends CommonPage {
    public ManageProfilePage() {
    }

    private By manageProfileTab = By.xpath("(//div[@class='sidemnenu mb-3']/ul/li)[7]");
    private By yourNameInfo = By.xpath("(//div[@class='card-body']/div[1])/div/input");
    private By yourPhoneInfo = By.xpath("(//div[@class='card-body']/div[2])/div/input");
    private By photoInfo = By.xpath("(//div[@class='card-body']/div[3])//div[contains(text(),'Browse')]");
    private By passwordInfo = By.xpath("(//div[@class='card-body']/div[4])/div/input");
    private By passwordConfirmInfo = By.xpath("(//div[@class='card-body']/div[5])/div/input");
    private By updateButton = By.xpath("//div/button[normalize-space()='Update Profile']");
    private By uploadNewButton = By.xpath("//div[@id='aizUploaderModal']//a[normalize-space()='Upload New']");
    private By uploadFle = By.xpath("//input[@class='uppy-Dashboard-input']");
    private By searchFile = By.xpath("//input[@placeholder='Search your files']");
    private By selectFile = By.xpath("(//div[@class='aiz-file-box'])[1]");
    private By addFileButton = By.xpath("//div[@id='aizUploaderModal']//div/div[3]/button");

    public void clickManageProfileTab() {
        WebUI.clickElement(manageProfileTab, 2);
        WebUI.waitForPageLoaded();
    }

    public void inputBasicInfo() {
        WebUI.clickElement(yourNameInfo, 0);
        Actions action = new Actions(DriverManager.getDriver());
        action.keyDown(WebUI.getWebElement(yourNameInfo), Keys.COMMAND).sendKeys("A").keyUp(Keys.COMMAND).sendKeys("SamSam1").build().perform();
        action.keyDown(WebUI.getWebElement(yourPhoneInfo), Keys.COMMAND).sendKeys("A").keyUp(Keys.COMMAND).sendKeys("12345611").build().perform();
        uploadPhoto();
        selectPhoto();
        WebUI.setText(passwordInfo, "0123456");
        WebUI.setText(passwordConfirmInfo, "0123456");
        WebUI.clickElement(updateButton, 2);
    }

    public void selectPhoto() {
        WebUI.clickElement(photoInfo, 0);
        WebUI.clickElement(searchFile, 2);
        WebUI.setText(searchFile, "samcuptest1");
        WebUI.waitForElementClickable(selectFile, 2);
        handelFileIsSelected();

    }

    public void uploadPhoto() {
        WebUI.clickElement(photoInfo, 2);
        WebUI.clickElement(uploadNewButton, 2);
        WebUI.setText(uploadFle, System.getProperty("user.dir") + "/src/test/resources/FileImage/samcuptest1.png");
        WebUI.waitForElementsVisibled(addFileButton, 4);
        WebUI.clickElement(addFileButton, 0);
    }

    public void handelFileIsSelected() {
        String selectedState = DriverManager.getDriver().findElement(selectFile).getAttribute("data-selected");
        if ("true".equals(selectedState)) {
            WebUI.clickElement(selectFile, 0);
        }
        WebUI.clickElement(addFileButton, 0);

    }
}
