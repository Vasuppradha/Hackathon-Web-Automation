package pages;

import config.ConfigReader;
import utilities.LocatorReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.JavascriptExecutorUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LoginPage {
    private WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickLoginIcon(){
        String loginIcon = LocatorReader.getLoginIcon();
        driver.findElement(By.xpath(loginIcon)).click();
    }

    public void clickGoogleBtn(){
        String googleBtn = LocatorReader.getGoogleBtn();
        WebElement gb = driver.findElement(By.xpath(googleBtn));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String clickScript = JavascriptExecutorUtils.CLICK;
        js.executeScript(clickScript,gb);
    }

    public void switchToGoogleWindow() throws InterruptedException {
        Thread.sleep(3000);
        Set<String> handles = driver.getWindowHandles();
        List<String> windows = new ArrayList<String>(handles);
        
        driver.switchTo().window(windows.getLast());
        
        System.out.println(windows.size());
        
        String flag = LocatorReader.getCheckWindowIsOpened();
        WebElement ele = driver.findElement(By.xpath(flag));
        
        wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public void checkWindowHeading(){
        String windowHeading = LocatorReader.getWindowHeading();
        
        if(windowHeading.equalsIgnoreCase("choose an account")){
            String chooseAnAccount = LocatorReader.getChooseAnAccount();
            driver.findElement(By.xpath(chooseAnAccount)).click();
        }
        LoginPage lp = new LoginPage(driver);
        lp.enterInvalidEmail();
    }

    public void enterInvalidEmail(){
        String email = LocatorReader.getEmailField();
        String invalidEmail = ConfigReader.getInvalidEmail();
        driver.findElement(By.xpath(email)).sendKeys(invalidEmail);
    }

    public void clickNextBtn(){
        String nextBtn = LocatorReader.getNextBtn();
        driver.findElement(By.xpath(nextBtn)).click();
    }

}
