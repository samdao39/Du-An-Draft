package sam.com.pageObjectModal.Pages;

import org.openqa.selenium.By;
import sam.com.constants.keywords.WebUI;

public class CommonPage {

    public CommonPage() {
    }

    private LoginPage loginPage;


    public By searchBox = By.xpath("//input[@id='search']");
    public By iconSearch = By.xpath("(//button[@type='submit'])[1]");
    public By searchResult = By.xpath("//form[@id='search-form']/div//div/h3/a");
    public By iConCart = By.xpath("//div[@id='cart_items']");
    public By viewCartButton = By.xpath("//div[contains(@class, 'px-3 py-2 text-center border-top')]//a[contains(text(), 'View cart')]");


    public void searchProduct(String value) {
        WebUI.clickElement(searchBox, 2);
        WebUI.waitForPageLoaded();
        WebUI.setText(searchBox, value);
        WebUI.clickElement(iconSearch, 2);
        WebUI.clickElement(searchResult, 3);
    }


}

