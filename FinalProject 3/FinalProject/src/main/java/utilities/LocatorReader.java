package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LocatorReader {
    private static final Properties prop = new Properties();

    static {
        try{
            String filePath = "src/main/resources/propertyFiles/Locators.properties";
            FileInputStream input = new FileInputStream(filePath);
            prop.load(input);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getNewBikes(){
        return prop.getProperty("newBikes");
    }

    public static String getUpcomingBikes(){
        return prop.getProperty("upcomingBikes");
    }

    public static String getHondaBrand(){
        return prop.getProperty("hondaBrand");
    }

    public static String getUnder5Lakhs(){
        return prop.getProperty("under5Lakhs");
    }

    public static String getBikeList(){
        return prop.getProperty("bikeList");
    }

    public static String getMoreMenu(){
        return prop.getProperty("moreMenu");
    }

    public static String getUsedCars(){
        return prop.getProperty("usedCars");
    }

    public static String getLocation(){
        return prop.getProperty("location");
    }

    public static String getPopularModel(){
        return prop.getProperty("popularModel");
    }

    public static String getCheckBoxList() {
        return prop.getProperty("checkBoxList");
    }

    public static String getCarList(){
        return prop.getProperty("carList");
    }

    public static String getLoginIcon(){
        return prop.getProperty("loginIcon");
    }

    public static String getGoogleBtn(){
        return prop.getProperty("googleBtn");
    }

    public static String getCheckWindowIsOpened(){
        return prop.getProperty("checkWindowIsOpened");
    }

    public static String getWindowHeading(){
        return prop.getProperty("windowHeading");
    }

    public static String getChooseAnAccount(){
        return prop.getProperty("chooseAnAccount");
    }

    public static String getEmailField(){
        return prop.getProperty("emailField");
    }

    public static String getNextBtn(){
        return prop.getProperty("nextBtn");
    }

    public static String getErrorMsg(){
        return prop.getProperty("errorMsg");
    }

}
