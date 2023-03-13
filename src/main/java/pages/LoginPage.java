package pages;


import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;

    private String emailInputId = "#input-email";
    private String passwordInputId = "#input-password";
    private String loginButton = "//input[@value='Login']";
    private String forgottenPassword = ".form-group a";

    private String logoutLink = "//a[@class='list-group-item'][text()='Logout']";

    public LoginPage(Page page) {
        this.page = page;
    }

    public String getLoginPageTitle() {
        return page.title();
    }

    public boolean isForgotPwdLinkExist() {
        return page.isVisible(forgottenPassword);
    }

    public boolean doLogin(String appUserName, String appPwd) {
        page.fill(emailInputId, appUserName);
        page.fill(passwordInputId, appPwd);
        page.click(loginButton);
        if(page.isVisible(logoutLink)) {
            System.out.println("User is logged successfully...");
            return true;
        }
        return false;
    }
}
