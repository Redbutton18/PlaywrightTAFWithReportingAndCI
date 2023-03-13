package playwrightExampleClasses;

import com.microsoft.playwright.*;

import java.util.List;

public class SelectorsExample {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));

        BrowserContext brContext1 = browser.newContext();
        Page page1 = brContext1.newPage();
        page1.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/");

        page1.locator("text=Privacy Policy").first().click();

        BrowserContext brContext2 = browser.newContext();
        Page page2 = brContext2.newPage();
        page2.navigate("https://www.amazon.com/");

        List<String> links = page2.locator("a:has-text('Amazon')").allInnerTexts();
        links.forEach(el -> System.out.println(el));
//        links.stream().forEach(el -> System.out.println(el));

        page1.close();
        brContext1.close();
    }
}
