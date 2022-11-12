package Day9_102922;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class T2_ImplictWait_USPS {

    public static void main(String[] args) throws InterruptedException {
        //set up your chromedriver with web-driver-manager
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing the Chrome window
        options.addArguments("start-maximized");
        //define the web-driver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);

        //declare your implicit wait
        //write one time and will wait UP to "5" seconds to find all elements******
        //global wait statement*****
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //go to usps page
        driver.navigate().to("https://www.usps.com/");

        //hover over to send tab
        WebElement sendtab = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));

        //declare mouse actions
        Actions mouseActions = new Actions(driver);

        //always end with .perform()
        mouseActions.moveToElement(sendtab).perform();

        //click on calculate a price using mouse click
        WebElement calculatePrice = driver.findElement(By.xpath("//a[text()= 'Calculate a Price']"));

        mouseActions.moveToElement(calculatePrice).click().perform();


        //double click on usps home logo
        WebElement uspsHome = driver.findElement(By.xpath("//*[@alt='USPS.com home']"));
        //right-clicking on usps home logo
        mouseActions.moveToElement(uspsHome).contextClick().perform();
        //double-clicking on usps home logo
        mouseActions.moveToElement(uspsHome).doubleClick().perform();
    }//end of main

}//end of class
