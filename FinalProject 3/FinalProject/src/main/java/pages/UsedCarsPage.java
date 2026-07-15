package pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.LocatorReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.JavascriptExecutorUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class UsedCarsPage {

    private WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;

    public UsedCarsPage(WebDriver driver){
        this.driver = driver;
    }

    public void navigateToUsedCars(){

        String hoverMoreMenu = LocatorReader.getMoreMenu();
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement ele =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(hoverMoreMenu)));
        
        Actions act = new Actions(driver);
        act.moveToElement(ele).perform();

        String usedCars = LocatorReader.getUsedCars();
        WebElement ele2 = driver.findElement(By.linkText(usedCars));
        ele2.click();
    }

    public void selectLocation(){
        String loc = LocatorReader.getLocation();
        WebElement ele = driver.findElement(By.xpath(loc));
        ele.click();
    }

    public void scrollToPopularModels(){
    	
        String popularModels = LocatorReader.getPopularModel();
        WebElement ele = driver.findElement(By.xpath(popularModels));
        
        js = (JavascriptExecutor)driver;
        String scrollIntoCenterScript = JavascriptExecutorUtils.SCROLL_INTO_CENTER;
        js.executeScript(scrollIntoCenterScript, ele);

    }

    public void selectAllOptions() throws InterruptedException {
        Thread.sleep(3000);
        js = (JavascriptExecutor)driver;
        String scrollBy = JavascriptExecutorUtils.ScrollBy(0,500);
        js.executeScript(scrollBy);
        String checkBoxList = LocatorReader.getCheckBoxList();
        List<WebElement> checkboxes = driver.findElements(By.xpath(checkBoxList));

        for(WebElement checkbox : checkboxes) {
            js.executeScript(scrollBy);
            String clickScript = JavascriptExecutorUtils.CLICK;
            js.executeScript(clickScript,checkbox);
        }

    }

    public List<WebElement> getCarList() throws InterruptedException {
    	
        js = (JavascriptExecutor)driver;
        String scrollToBottom = JavascriptExecutorUtils.SCROLL_TO_BOTTOM;
        js.executeScript(scrollToBottom);
        
        Thread.sleep(3000);
        
        String carList = LocatorReader.getCarList();
        List<WebElement> e1 = driver.findElements(By.xpath(carList));
        
        int previousCount = 0;
        
        while (true) {
            List<WebElement> elements = driver.findElements(By.xpath(carList));
            
            int currentCount = elements.size();
            if (currentCount == previousCount) {
                break;
            }
            previousCount = currentCount;
            
            String scrollIntoViewTrue = JavascriptExecutorUtils.SCROLL_INTO_VIEW_TRUE;
            js.executeScript(scrollIntoViewTrue, elements.getLast());
            Thread.sleep(5000);
        }
        
        List<WebElement> resultList = new ArrayList<>(driver.findElements(By.xpath(carList)));

        System.out.println("\n===== Used Cars Details =====\n");
        System.out.printf("%-35s %-15s %-15s %-20s\n",
                "Car Name", "Price", "Year", "Location");
        System.out.println("--------------------------------------------------------------------------------");

        for(WebElement result : resultList){
            String s = result.getText();
            s = s.replace("View Seller Details","").trim();

            String[] lines = s.split("\\R");

            String carName = lines.length > 0 ? lines[0] : "";
            String price = lines.length > 1 ? lines[1] : "";
            String year = lines.length > 2 ? lines[2] : "";
            String location = lines.length > 3 ? lines[3] : "";

            System.out.printf("%-35s %-15s %-15s %-20s\n",
                    carName, price, year, location);
        }
        return resultList;
    }

}
