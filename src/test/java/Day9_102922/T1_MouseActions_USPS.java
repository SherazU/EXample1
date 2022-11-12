package Day9_102922;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class T1_MouseActions_USPS {

    public static void main(String[] args) throws InterruptedException {

        //set up your chromedriver with web-driver-manager
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing the Chrome window
        //headless-runs in the code in the background
        options.addArguments("start-maximized");
        //define the web-driver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);
        //go to usps page
        driver.navigate().to("https://www.usps.com/");
        Thread.sleep(2000);

        //hover over to send tab
        WebElement sendtab = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));

        //declare mouse actions
        Actions mouseActions = new Actions(driver);

        //always end with .perform()
        mouseActions.moveToElement(sendtab).perform();

        //wait a bit
        Thread.sleep(1000);

        //click on calculate a price using mouse click
        WebElement calculatePrice = driver.findElement(By.xpath("//a[text()= 'Calculate a Price']"));

        mouseActions.moveToElement(calculatePrice).click().perform();

        Thread.sleep(2000);
        //double click on usps home logo
        WebElement uspsHome = driver.findElement(By.xpath("//*[@alt='USPS.com home']"));
        //right-clicking on usps home logo
        mouseActions.moveToElement(uspsHome).contextClick().perform();
        //double-clicking on usps home logo
        mouseActions.moveToElement(uspsHome).doubleClick().perform();


    }//end main


}//end of class
