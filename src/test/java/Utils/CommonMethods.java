package Utils;

import StepDefinitions.PageInitializer;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class CommonMethods extends PageInitializer {
    public  static WebDriver driver;
    public static void openBrowserAndLaunchApplication(){
        ConfigReader.readProperties();

        String browserType=ConfigReader.getPropertyValue("browserType");
        switch (browserType){
            case"Chrome":
                ChromeOptions ops = new ChromeOptions();
                ops.addArguments("--no-sandbox");
                ops.addArguments("--remote-allow-origins=*");
                if(ConfigReader.getPropertyValue("Headless").equals("true")){
                    ops.addArguments("--headless=new");
                }
                driver=new ChromeDriver(ops);
                break;
            case"Firefox":
                driver=new FirefoxDriver();
                break;
            case"IE":
                driver=new InternetExplorerDriver();
                break;
            default:
                driver=new EdgeDriver();

        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(Constants.WAIT_TIME));

        initializePageObjects(); //this will initialize all the pages we have in our page initializer class along with launching application

        // to configure the File and pattern of it
        DOMConfigurator.configure("log4j.xml"); //log4j.xml is the file with format in which logs will be generated
        Log.startTestCase("This is the beginning of my Test Case");
        Log.info("My test case is executing now");
        Log.warning("My Test case might have some issues");

    }
    public static void closeBrowser(){
        Log.info("This Test case is about to be completed");
        Log.endTestCase("This Test case is finished");
        driver.close();

    }
    public static void doClick(WebElement element){
        element.click();

    }
public static void sendText(WebElement element,String text){
        element.clear();
        element.sendKeys(text);

}
public static  Select clickOnDropDown(WebElement element){
    Select select=new Select(element);
    return select;
}
public static void selectByValue(WebElement element,String value){
        clickOnDropDown(element).selectByValue(value);
}
public static void selectByVisibleText(WebElement element, String text){
        clickOnDropDown(element).selectByVisibleText(text);
}
public static void selectByIndex(WebElement element,int index){
        clickOnDropDown(element).selectByIndex(index);
}
public static void selectByOptions(WebElement element,String text){
       List<WebElement> options= clickOnDropDown(element).getOptions();
       for (WebElement option:options){
        String dropDownListOptionText=   option.getText();
        if(dropDownListOptionText.equals(text)){
            option.click();
        }
       }

}
public static byte[] takeScreenShot(String imageName){
        //this is a casting for WebDriver instance "driver" to takeScreenShot interface
    //since TakeScreenShot is an Interface and we can not create an object of it , we have to cast it
    TakesScreenshot ts=(TakesScreenshot) driver;
    // this captures the screenshot and stores it as byte type array
    byte[]picBytes=ts.getScreenshotAs(OutputType.BYTES);
    //this line captures the screenshot and stores them as a file in the source file variable
   File sourcePath =ts.getScreenshotAs(OutputType.FILE);
    try {
        FileUtils.copyFile(sourcePath,new File(Constants.SCREENSHOT_FILEPATH+imageName+getTimeStamp("yyyy-MM-dd-HH-mm-ss")+".png"));
    } catch (IOException e) {
        throw new RuntimeException(e);

    }
    return picBytes;
}
public static String getTimeStamp(String pattern){
        //this method will capture the real date and time of your System whenever you run the code
    Date date=new Date();
    SimpleDateFormat sdf=new SimpleDateFormat(pattern);
   return sdf.format(date);

}



}
