import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.Home;
import org.example.pages.Login;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestAmazonStore {

    private WebDriver driver;

    protected String number = "01127808781";
    protected String password = "TestPassword";

    @Before
    public void prepare() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
    }
    @Test
    public void testAccountLogin() {
//     new Login(driver).loginChaining(number, password).startTestCycle();
        Home myStoreHomePage = new Home(driver);
        myStoreHomePage.startTestCycle();
    }
    @After
    public void teardown(){
        driver.quit();
    }

}
