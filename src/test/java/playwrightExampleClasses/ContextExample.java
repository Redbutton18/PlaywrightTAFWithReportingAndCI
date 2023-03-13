package playwrightExampleClasses;

import com.microsoft.playwright.*;

public class ContextExample {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));

        BrowserContext brContext1 = browser.newContext();
        Page page1 = brContext1.newPage();
        page1.navigate("https://www.ukr.net/");
        page1.fill("#search-input", "chatGPT");
        System.out.println(page1.title());

        BrowserContext brContext2 = browser.newContext();
        Page page2 = brContext2.newPage();
        page2.navigate("https://swapi.dev/");
        page2.fill(".form-control", "people/2");
        System.out.println(page2.title());
    }
}
