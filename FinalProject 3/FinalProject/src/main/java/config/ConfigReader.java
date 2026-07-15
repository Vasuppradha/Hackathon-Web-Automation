package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties prop;

    static {
        prop = new Properties();
        try{
            String filePath = "src/test/resources/config.properties";
            FileInputStream file = new FileInputStream(filePath);
            prop.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUrl(){
        return prop.getProperty("url");
    }

    public static String getExcelFilePath(){
        return prop.getProperty("excelFilePath");
    }

    public static String getSheetName(){
        return prop.getProperty("sheetName");
    }

    public static String getScreenShotPath(){
        return prop.getProperty("screenShotFilePath");
    }

    public static String getInvalidEmail(){
        return prop.getProperty("invalidEmail");
    }

}
