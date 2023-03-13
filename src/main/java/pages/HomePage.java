package pages;

import com.microsoft.playwright.Page;

public class HomePage {
    private Page page;

    private String search = "input[name='search']";
    private String searchIcon = ".input-group-btn button";
    private String searchPageHeader = "#content h1";
    private String myAccDropdown = "//span[text()='My Account']";
    private String loginItem = "//a[text()='Login']";


    public HomePage(Page page) {
        this.page = page;
    }

    public String getHomePageTitle() {
        return page.title();
    }

    public String getHomePageUrl() {
        return page.url();
    }

    public String doSearch(String productName) {
        page.fill(search, productName);
        page.click(searchIcon);
        return page.textContent(searchPageHeader);
    }

    public LoginPage navigateToLoginPage() {
        page.click(myAccDropdown);
        page.click(loginItem);
        return new LoginPage(page);
    }
}
