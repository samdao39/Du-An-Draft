package sam.com.dataProviders;

import org.testng.annotations.DataProvider;
import sam.com.constants.helpers.ExcelHelper;
import sam.com.constants.helpers.SystemHelper;

public class DataProviderFactory {
    @DataProvider(name = "data_provider_login", parallel = true)
    public Object[][] dataHRM() {
        return new Object[][]{{"anhtester", "123456", "Admin"}, {"joe.larson", "joe.larson", "Employee"}};
    }

    @DataProvider(name = "data_provider_02")
    public Object[][] dataLogin() {
        return new Object[][]{{"anhtester", "123456", "Admin"}};
    }

    @DataProvider(name = "data_provider_login_excel")
    public Object[][] dataLoginProviderFromExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData(SystemHelper.getCurrentDir() + "src/test/resources/DataExcel/LoginProvider.xlsx", "Sheet1");
        System.out.println("Login Data from Excel: " + data);
        return data;
    }
}
