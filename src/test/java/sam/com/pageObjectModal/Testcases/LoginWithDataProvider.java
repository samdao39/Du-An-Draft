package sam.com.pageObjectModal.Testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sam.com.common.BaseTest;
import sam.com.constants.constants.ConfigData;
import sam.com.constants.helpers.ExcelHelper;
import sam.com.dataProviders.DataProviderFactory;
import sam.com.pageObjectModal.Pages.LoginPage;

public class LoginWithDataProvider extends BaseTest {
    //khởi tạo đối tương cho  page login
    LoginPage loginPage;

    @Test()
    public void loginSuccess() {
        loginPage = new LoginPage();
        loginPage.clickPopup();
        loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginCMSSuccess();

    }

    @Test()
    public void loginFailWithEmailInvalid() {
        ExcelHelper excelHelper = new ExcelHelper();// khai bao doi tuong vi cac ham trong Excel helper khong co static
        excelHelper.setExcelFile("src/test/resources/DataExcel/DemoExcelData.xlsx", "Sheet 1");
        loginPage = new LoginPage();
        loginPage.clickPopup();
        loginPage.loginCMS(excelHelper.getCellData("Email", 1), excelHelper.getCellData("Password", 1));
        loginPage.verifyLoginCMSFail();
    }

    @Test(dataProvider = "data_provider_login_excel", dataProviderClass = DataProviderFactory.class)
    public void loginFailWithPasswordInvalid(String email, String password) {
        loginPage = new LoginPage();
        loginPage.clickPopup();
        loginPage.loginCMS(ConfigData.EMAIL, "1123123");
        loginPage.verifyLoginCMSFail();
    }


}
