package playwrightExampleClasses;

import com.microsoft.playwright.*;

import java.util.List;

public class LocatorsExample {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));

        BrowserContext brContext1 = browser.newContext();
        Page page1 = brContext1.newPage();
        page1.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/");

        //single element
//        Locator bookFreeDemoBtn = page1.getByText("Platform").first();
//        bookFreeDemoBtn.hover();
//        bookFreeDemoBtn.click();

        //multiple elements
        Locator countriesList = page1.locator("select#Form_getForm_Country option");
        System.out.println(countriesList.count());

        List<String> optionsTextList = countriesList.allTextContents();
        optionsTextList.forEach(element -> System.out.println(element));
    }
}
