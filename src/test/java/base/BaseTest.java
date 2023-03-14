package base;

import com.microsoft.playwright.Page;
import factory.PlaywrightFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    private PlaywrightFactory factory;
    private Page page;
    protected Properties properties;

    protected HomePage homePage;
    protected LoginPage loginPage;

    @Parameters({"browser"})
    @BeforeTest
    public void setUp(String browserName) throws IOException {
        factory = new PlaywrightFactory();
        properties = factory.initProperties();

        if(browserName!=null){
            properties.setProperty("browser", browserName);
        }

        page = factory.initBrowser(properties);
        homePage = new HomePage(page);
    }

    @AfterTest
    public void tearDown() {
        page.context().browser().close();
    }
}
