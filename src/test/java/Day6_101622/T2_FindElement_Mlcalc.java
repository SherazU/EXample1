package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_FindElement_Mlcalc {

    public static void main(String[] args) throws InterruptedException {

        //set up your chromedriver with web-driver-manager
        WebDriverManager.chromedriver().setup();

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();

        //add options for maximizing the Chrome window
        //headless-runs in the code in the background
        //options.addArguments("start-maximized");

        //for mac use "start-fullscreen"
 options.addArguments("start-fullscreen");

        //define the web-driver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);

        //go to google page
        driver.navigate().to("https://www.mlcalc.com");

        //sleep statement
        Thread.sleep(3000);

        //clear and enter a new value on purchase price field
        WebElement pPrice = driver.findElement(By.xpath("//*[@name= 'ma']"));
        //clear the purchase price
        pPrice.clear();
        //type new value on purchase price
        pPrice.sendKeys("450000");

        //clear and enter a new value on down payment field
        WebElement dPayment = driver.findElement(By.xpath("//*[@name= 'dp']"));
        //clear the down payment
        dPayment.clear();
        //type new value on down payment
        dPayment.sendKeys("25");

    }//end of main
}//end of class
