package sam.com.pageObjectModal.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sam.com.constants.constants.drivers.DriverManager;
import sam.com.constants.keywords.WebUI;

public class ManageProfilePage extends LoginPage {
    public ManageProfilePage() {
         // khai báoclass WebUI để dùng chung cho các hàm bên dư��i
    }

    private By manageProfileTab  =By.xpath("(//div[@class='sidemnenu mb-3']/ul/li)[7]");
    private By yourNameInfo  =By.xpath("(//div[@class='card-body']/div[1])/div/input");
    private By yourPhoneInfo  =By.xpath("(//div[@class='card-body']/div[2])/div/input");
    private By photoInfo  =By.xpath("(//div[@class='card-body']/div[3])//div[contains(text(),'Browse')]");
    private By passwordInfo  =By.xpath("(//div[@class='card-body']/div[4])/div/input");
    private By passwordConfirmInfo  =By.xpath("(//div[@class='card-body']/div[5])/div/input");
    private By submitButton  =By.xpath("//div/button[normalize-space()='Update Profile']");
    private By popupUploadphoTo  =By.xpath("");
    private By  uploadNewButton =By.xpath("//div[@id='aizUploaderModal']//div/ul/li[2]");
    private By  browserButton =By.xpath("");
    private By  addFileButton =By.xpath("");
    public void clickManageProfileTab(){
        WebUI.waitForElementsToBeClickabled(manageProfileTab, 5);  // đ��i 5 giây cho tab trên web page đã được hiển thị
        DriverManager.getDriver().findElement(manageProfileTab).click();
        WebUI.waitForPageLoaded();  // đ��i cho trang web page đã load xong

    }
}
