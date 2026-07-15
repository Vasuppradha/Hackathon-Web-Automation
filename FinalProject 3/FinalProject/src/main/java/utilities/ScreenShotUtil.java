package utilities;

import config.ConfigReader;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ScreenShotUtil {
    private WebDriver driver;
    private WebDriverWait wait;

    public ScreenShotUtil(WebDriver driver){
        this.driver = driver;
    }

    public void takeScreenShot() throws IOException {
    	
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        String errorMsg = LocatorReader.getErrorMsg();
        
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(errorMsg))));
        
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        
        String screenShotPath =  ConfigReader.getScreenShotPath() + ".png";
        
        File destination = new File(screenShotPath);
        
        FileUtils.copyFile(src,destination);
    }
}
