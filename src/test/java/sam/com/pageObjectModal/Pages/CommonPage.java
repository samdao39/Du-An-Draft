package sam.com.pageObjectModal.Pages;


public class CommonPage {

    private LoginPage loginPage;
    public CommonPage() {
    }
    public LoginPage getLoginPage() {
        if(loginPage == null){
            loginPage = new LoginPage();
        }
        return loginPage;
    }
}

