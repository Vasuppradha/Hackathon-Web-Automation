package baseTest;

import base.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class DriverSetupTest extends DriverSetup{
    public WebDriver driver;
    @Parameters("browser")
    @BeforeClass
    public void setup(String browser) {
        driver = setUp(browser);
    }

    @AfterClass
    public void closeBrowser(){
        tearDown();

    }
}
