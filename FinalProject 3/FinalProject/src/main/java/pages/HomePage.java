package pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.LocatorReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class HomePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void navigateToUpcomingBikes(){
    	
        String newBikes = LocatorReader.getNewBikes(); 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(newBikes)));

        Actions act = new Actions(driver);
        act.moveToElement(ele).perform();

        String upcomingBikes = LocatorReader.getUpcomingBikes();
        WebElement ele2 = driver.findElement(By.linkText(upcomingBikes));
        ele2.click();
    }
}
