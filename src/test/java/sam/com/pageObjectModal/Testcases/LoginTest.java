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
        loginPage.loginCMS(ConfigData.Email, ConfigData.Password);
        loginPage.verifyLoginCMSSuccess();

    }
    @Test()
    public void loginFailWithEmailInvalid(){
        loginPage = new LoginPage();
        loginPage.clickPopup();
        loginPage.loginCMS("sam@ecomdy.com",ConfigData.Password);
        loginPage.verifyLoginCMSFail();
    }
    @Test()
    public void loginFailWithPasswordInvalid(){
        loginPage = new LoginPage();
        loginPage.clickPopup();
        loginPage.loginCMS(ConfigData.Email,"1123123");
        loginPage.verifyLoginCMSFail();
    }
}
