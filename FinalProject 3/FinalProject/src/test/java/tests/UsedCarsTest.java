package tests;

import baseTest.DriverSetupTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.UsedCarsPage;
import java.util.ArrayList;
import java.util.List;

public class UsedCarsTest extends DriverSetupTest {
    List<WebElement> carList = new ArrayList<WebElement>();
    
    private UsedCarsPage ucp;

    @Test()
    public void navToUsedCarsPage(){
        ucp = new UsedCarsPage(driver);
        ucp.navigateToUsedCars();
    }

    @Test(dependsOnMethods = "navToUsedCarsPage")
    public void selectLocation() throws InterruptedException {
        ucp = new UsedCarsPage(driver);
        ucp.selectLocation();
    }

    @Test(dependsOnMethods = "selectLocation")
    public void scrollToPopularModels() throws InterruptedException {
        ucp = new UsedCarsPage(driver);
        ucp.scrollToPopularModels();
    }

    @Test(dependsOnMethods = "scrollToPopularModels")
    public void selectAllModels() throws InterruptedException {
        ucp = new UsedCarsPage(driver);
        ucp.selectAllOptions();
    }

    @Test(dependsOnMethods = "selectAllModels")
    public void getCarList() throws InterruptedException {
        ucp = new UsedCarsPage(driver);
        carList = ucp.getCarList();
    }

}
