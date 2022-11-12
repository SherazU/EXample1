package Day8_102322;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T1_TryCatch_MortageCalc {

    public static void main(String[] args) throws InterruptedException {
        //set up your chromedriver with web-driver-manager
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing the Chrome window
        //headless-runs in the code in the background
        options.addArguments("start-maximized");
        //for mac use "start-fullscreen"
//        options.addArguments("start-fullscreen");
        //define the web-driver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);
        //go to mortgagecalculator page
        driver.navigate().to("https://www.mortgagecalculator.org/");
        Thread.sleep(2000);
//define javascript executor
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //clear and enter new home value
        try{
            WebElement homeVal = driver.findElement(By.xpath("//*[@id='homeval']"));
            homeVal.clear();
            homeVal.sendKeys("380000");
        } catch (Exception e) {
            System.out.println("Unable to enter new value on Home Value.. " + e);
        }//end of home val exception

//clear and enter new down payment
        try{
            WebElement homeVal = driver.findElement(By.xpath("//*[@id='downpayment']"));
            homeVal.clear();
            homeVal.sendKeys("12000");
        } catch (Exception e) {
            System.out.println("Unable to enter new value on Down Payment.. " + e);
        }//end of down payment exception

//Select new value for the start month
        try{
            WebElement strMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
            Select dropDown = new Select(strMonth);
            dropDown.selectByVisibleText("Dec");
        } catch (Exception e) {
            System.out.println("Unable to select new value on Start Month drop down.. " + e);
        }//end of start month exception

//type in new value for the start year
        try{
            WebElement startYear = driver.findElement(By.xpath("//*[@id = 'start_year']"));
            startYear.sendKeys("2024");
        } catch (Exception e) {
            System.out.println("Unable to select new value on Start year drop down.. " + e);
        }//end of start year exception

//click on calculate
        try{
            driver.findElement(By.xpath("//*[@value='Calculate']")).click();
        } catch (Exception e) {
            System.out.println("Unable to click on Calculate.. " + e);
        }//end of calculate exception

        Thread.sleep(3000);

//capture and print monthly payment
        try{
            String result = driver.findElements(By.xpath("//*[@class='left-cell']/h3")).get(0).getText();
            System.out.println("Monthly payment is " + result);
        } catch (Exception e) {
            System.out.println("Unable to capture monthly payment.. " + e);
        }//end of monthly payment exception

        //quit chrome
        driver.quit();

    }//end of main


}//end of class
