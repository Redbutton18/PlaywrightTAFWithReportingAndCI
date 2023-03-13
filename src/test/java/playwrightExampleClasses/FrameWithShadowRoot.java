package playwrightExampleClasses;

import com.microsoft.playwright.*;

public class FrameWithShadowRoot {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));

        BrowserContext brContext1 = browser.newContext();
        Page page1 = brContext1.newPage();
        page1.navigate("https://selectorshub.com/shadow-dom-in-iframe/");

        page1.frameLocator("#pact").locator("div#snacktime #tea").fill("Green tea with lemon");
    }
}
