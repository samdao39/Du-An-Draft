package sam.com.pageObjectModal.Pages;

import org.openqa.selenium.By;
import sam.com.constants.helpers.ExcelHelper;
import sam.com.constants.keywords.WebUI;

public class ProductDetailPage extends CommonPage {
    ProductDetailPage productDetailPage;
    public By productName = By.xpath("//section[@class='mb-4 pt-3']//div[@class='col-xl-7 col-lg-6']//h1[@class='mb-2 fs-20 fw-600']");
    public By price = By.xpath("//div[@class='product-price']/strong[@id='chosen_price']");
    private By size = By.xpath("//input[@name='attribute_id_1']/following-sibling::span");////input[@name='attribute_id_1'][@value='22']/following-sibling::span[contains(text(), '22')]
    private By color = By.xpath("//input[@name='color']");
    public By quantity = By.xpath("//div[@class='avialable-amount opacity-60']/span[@id='available-quantity']");
    private By addToCartButton = By.xpath("(//button[@class='btn btn-soft-primary mr-2 add-to-cart fw-600'])[1]");
    private By popupSuccess = By.xpath("//div[@id='addToCart-modal-body']");
    private By closePopup = By.xpath("//div[@id='modal-size']/div/button[@aria-label='Close']");


    public void getInfoProductSetToExcel(int rowIndex) {
        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile("src/test/resources/DataExcel/ExcelData.xlsx", "Sheet 2");
        excel.setCellData(WebUI.getText(productName), "Product Name", rowIndex);
        excel.setCellData(WebUI.getText(price), "Prices", rowIndex);
        if (WebUI.checkElementExist(size)) {
            excel.setCellData(WebUI.getText(size), "Size", rowIndex);
        }
        if (WebUI.checkElementExist(color)) {
            excel.setCellData(WebUI.getAttribute(color, "value"), "Color", rowIndex);
        }

        excel.setCellData(WebUI.getText(quantity), "Quantity", rowIndex);
    }

    public void resetDataInSheet() {
        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile("src/test/resources/DataExcel/ExcelData.xlsx", "Sheet 2");
        excel.setCellData("", "Product Name", 1);
        excel.setCellData("", "Prices", 1);
        excel.setCellData("", "Size", 1);
        excel.setCellData("", "Color", 1);
        excel.setCellData("", "Quantity", 1);

    }

    public void addProductToCart() {
        WebUI.waitForPageLoaded();
        WebUI.clickElement(addToCartButton, 2);
        WebUI.waitForElementsVisibled(popupSuccess, 2);
        WebUI.clickElement(closePopup, 1);
    }


}
