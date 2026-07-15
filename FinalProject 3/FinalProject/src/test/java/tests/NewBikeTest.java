package tests;

import baseTest.DriverSetupTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.NewBikesPage;

import java.util.ArrayList;
import java.util.List;

public class NewBikeTest extends DriverSetupTest {
    List<WebElement> bikeList = new ArrayList<>();
    
    private NewBikesPage nbp;

    @Test(priority = 0)
    public void clickUpComingBikes(){
        HomePage hp = new HomePage(driver);
        hp.navigateToUpcomingBikes();
    }

    @Test(dependsOnMethods = "clickUpComingBikes")
    public void clickBrandName() throws InterruptedException {
    	nbp = new NewBikesPage(driver);
        nbp.clickBrandName();
    }

    @Test(dependsOnMethods = "clickBrandName")
    public void selectFilter() throws InterruptedException {
        nbp = new NewBikesPage(driver);
        nbp.selectUnder5Lakhs();
    }

    @Test(dependsOnMethods = "selectFilter")
    public void getBikeListUnder5Lakhs(){
        nbp = new NewBikesPage(driver);
        bikeList = nbp.getBikeList();
    }

    @Test(dependsOnMethods = "getBikeListUnder5Lakhs")
    public void printBikeList(){
        nbp = new NewBikesPage(driver);
        nbp.printBikeDetails(bikeList);
    }

}
