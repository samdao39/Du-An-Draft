package sam.com.pageObjectModal.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import sam.com.constants.helpers.ExcelHelper;
import sam.com.constants.keywords.WebUI;

import java.util.List;

public class CartDetailPage extends CommonPage {
    private By continueToShippingButton = By.xpath("//section[@id='cart-summary']//div[@class='col-md-6 text-center text-md-right']/a");
    private By productInTable = By.xpath("//section[@id='cart-summary']//child::div[@class='mb-4']/ul/li");
    private By productName = By.xpath(".//span[contains(@class, 'fs-14')]");
    private By productPrice = By.xpath(".//span[contains(@class, 'fw-600') and contains(text(), '$')]");
    private By productQuantity = By.xpath("..//input[contains(@class, 'input-number')]");
    private By totalPrice = By.xpath(".//span[contains(@class, 'text-primary')]");
    //private By x = By.xpath("(//div[@id='addToCart-modal-body']//div/a)[2]");

    public CheckoutDetailPage viewCart() {
        WebUI.clickElement(iConCart, 2);
        WebUI.clickElement(viewCartButton, 1);
        return new CheckoutDetailPage();
    }


    public void clickContinueToShippingButton() {
        WebUI.clickElement(continueToShippingButton, 1);

    }


    public void checkProductsInCart() {
        WebUI.checkElementExist(productInTable);
        List<WebElement> items = WebUI.getWebElements(productInTable);

        for (int index = 0; index < items.size(); index++) {
            WebElement item = items.get(index);
            String productInfo = item.findElement(productName).getText();
            String[] productInfoArr = productInfo.split("-");
            String formatName = productInfoArr.length > 0 ? productInfoArr[0].trim() : "";
            String formatColor = productInfoArr.length > 1 ? productInfoArr[1].trim() : "";
            String formatSize = productInfoArr.length > 2 ? productInfoArr[2].trim() : "";

            List<WebElement> prices = item.findElements(productPrice);
            String price = prices.size() > 0 ? prices.get(0).getText() : "N/A";
            String quantity = item.findElement(productQuantity).getAttribute("value");
            String total = item.findElement(totalPrice).getText();

            // get data of a product in excel src/test/resources/DataExcel/ExcelData.xlsx
            ExcelHelper excelHelper = new ExcelHelper();
            excelHelper.setExcelFile("src/test/resources/DataExcel/ExcelData.xlsx", "Sheet 2");
            String nameExel = excelHelper.getCellData("Product Name", index + 1);
            String colorExel = excelHelper.getCellData("Color", index + 1);
            String sizeExel = excelHelper.getCellData("Size", index + 1);
            String priceExel = excelHelper.getCellData("Prices", index + 1);


            Assert.assertEquals(formatName, nameExel, "Product name is not correct");
            Assert.assertEquals(formatColor, colorExel, "Product color is not correct");
            Assert.assertEquals(formatSize, sizeExel, "Product size is not correct");
            Assert.assertEquals(price, priceExel, "Product price is not correct");
            Assert.assertEquals(quantity, "1", "Quantity is not correct");
            Assert.assertEquals(total, priceExel, "Product Total is not correct");
        }
    }
}

