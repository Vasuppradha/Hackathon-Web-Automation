package base;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class DriverSetup {

    protected WebDriver driver;

    public WebDriver setUp(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions co = new ChromeOptions();
            co.addArguments("--disable-notifications");
            driver = new ChromeDriver(co);

        } else if (browser.equalsIgnoreCase("edge")) {

            EdgeOptions eo = new EdgeOptions();
            eo.addArguments("--disable-notifications");
            driver = new EdgeDriver(eo);

        } else {
            throw new IllegalArgumentException("Invalid browser: " + browser);
        }

        String url = ConfigReader.getUrl();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    public void tearDown() {
        driver.quit();
    }
}
