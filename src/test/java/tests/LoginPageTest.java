package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    private String email = "mnikh.anton@gmail.com";
    private String pwd = "1234567890";

    @Test
    public void  navigateToLoginPageTest() {
        loginPage = homePage.navigateToLoginPage();
        loginPage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
        Assert.assertEquals(loginPage.getLoginPageTitle(), "My Account");
    }

    @Test
    public void forgotPwdLinkExistTest() {
        loginPage = homePage.navigateToLoginPage();
        Assert.assertTrue(loginPage.isForgotPwdLinkExist());
    }
}
