package sam.com.ExcelFileData;

import org.testng.annotations.Test;
import sam.com.constants.helpers.ExcelHelper;

public class DemoExcelFIle {
    @Test
    public void getDataFromExcel() {
        ExcelHelper excelHelper = new ExcelHelper();// khai bao doi tuong vi cac ham trong Excel helper khong co static
        excelHelper.setExcelFile("src/test/resources/DataExcel/DemoExcelData.xlsx", "Sheet 1");
        // get data simple from excel
        System.out.println(excelHelper.getCellData("Email", 1));
        System.out.println(excelHelper.getCellData("Password", 1));

        // set data vào file excel
        excelHelper.setCellData("Passed", "Status", 1);
        excelHelper.setCellData("Fail", "Status", 2);
    }
}
