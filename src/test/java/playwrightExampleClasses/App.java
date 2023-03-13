package playwrightExampleClasses;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

public class App {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
//            Browser browser = playwright.chromium().launch();
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            Page page = browser.newPage();
            page.navigate("http://playwright.dev");
            System.out.println(page.title());
        }
    }


//        public static void main(String[] args) {
//            try (Playwright playwright = Playwright.create()) {
//                Browser browser = playwright.webkit().launch();
//                Page page = browser.newPage();
//                page.navigate("http://whatsmyuseragent.org/");
//                page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
//                browser.close();
//                playwright.close();
//            }
//        }
}
