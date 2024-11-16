package sam.com.pageObjectModal.Testcases;

import org.testng.annotations.Test;
import sam.com.common.BaseTest;
import sam.com.constants.constants.ConfigData;
import sam.com.pageObjectModal.Pages.LoginPage;

public class LoginTest extends BaseTest {
//khởi tạo đối tương cho  page login
    LoginPage loginPage;
    @Test()
    public void loginSuccess(){
        loginPage = new LoginPage();
        loginPage.clickPopup();
        loginPage.loginCMS(ConfigData.EMAIL,ConfigData.PASSWORD);
        loginPage.verifyLoginCMSSuccess();

    }
    @Test()
    public void loginFailWithEmailInvalid(){
        loginPage = new LoginPage();
        loginPage.clickPopup();
        loginPage.loginCMS("sam@ecomdy.com",ConfigData.PASSWORD);
        loginPage.verifyLoginCMSFail();
    }
    @Test()
    public void loginFailWithPasswordInvalid(){
        loginPage = new LoginPage();
        loginPage.clickPopup();
        loginPage.loginCMS(ConfigData.EMAIL,"1123123");
        loginPage.verifyLoginCMSFail();
    }
}
