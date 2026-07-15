package pages;

import config.ConfigReader;
import utilities.LocatorReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ExcelUtils;
import utilities.JavascriptExecutorUtils;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class NewBikesPage {
    private final WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;
    List<WebElement> bikeList = new ArrayList<WebElement>();
    private String scrollIntoCenterScript;
    private String clickScript;

    public NewBikesPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickBrandName() throws InterruptedException {
    	
        String brandName = LocatorReader.getHondaBrand();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(brandName)));
        
        js = (JavascriptExecutor) driver;
        scrollIntoCenterScript = JavascriptExecutorUtils.SCROLL_INTO_CENTER;
        js.executeScript(scrollIntoCenterScript, ele);
        
        Thread.sleep(2000);
        
        clickScript = JavascriptExecutorUtils.CLICK;
        js.executeScript(clickScript, ele);

    }

    public void selectUnder5Lakhs() throws InterruptedException {
    	
        String filter = LocatorReader.getUnder5Lakhs();
        WebElement ele = driver.findElement(By.xpath(filter));
        
        js = (JavascriptExecutor) driver;
        scrollIntoCenterScript = JavascriptExecutorUtils.SCROLL_INTO_CENTER;
        js.executeScript(scrollIntoCenterScript, ele);
        
        Thread.sleep(2000);
        
        clickScript = JavascriptExecutorUtils.CLICK;
        js.executeScript(clickScript, ele);
    }

    public List<WebElement> getBikeList(){
    	
        String bike = LocatorReader.getBikeList();
        
        bikeList = driver.findElements(By.xpath(bike));
        
        System.out.print(bikeList.size());
        return bikeList;
    }

    public void printBikeDetails(List<WebElement> list) {
    	
        System.out.println("\n===== Upcoming Honda Bikes Under 5 Lakhs =====\n");
        System.out.printf("%-40s %-15s %-25s\n", "Bike Name", "Price", "Expected Launch Date");
        System.out.println("------------------------------------------------------------------------------");

        int rowSize = list.size();
        int colSize = 3;
        Object[][] values = new Object[rowSize+2][colSize];
        int i = 1;

        values[0][0] = "Bike Name";
        values[0][1] = "Price in Rs. Lakhs";
        values[0][2] = "Expected Launch Date";

        for(WebElement ele : list){
            String data = ele.getText();
            Object[] lines = data.split("\\R");

            values[i][0] = lines[0];
            values[i][1] = lines[1];
            values[i][2] = lines[2];

            System.out.print(i);
            System.out.printf("%-40s %-15s %-25s\n",values[i][0],values[i][1],values[i][2]);
            if(i == 24) break;
            i++;
        }

        String filePath = ConfigReader.getExcelFilePath();
        ExcelUtils eu = new ExcelUtils(filePath);
        String sheetName = ConfigReader.getSheetName();
        eu.writeTable(sheetName, values);
        try {
            eu.saveFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
