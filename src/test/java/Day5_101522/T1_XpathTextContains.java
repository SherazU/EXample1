package Day5_101522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_XpathTextContains {

    public static void main(String[] args) throws InterruptedException {

        //define the webDriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();

//define the chrome driver to use for your test
//creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver();

//navigate to the yahoo site
        driver.navigate().to("https://www.yahoo.com");

//maximize the driver
        driver.manage().window().maximize();

//click on sign button
        driver.findElement(By.xpath("//*[text() = 'Sign in']")).click();

//wait 2 seconds
        Thread.sleep(2000);

//go to yahoo home page
        driver.navigate().to("https://www.yahoo.com");

//wait 1 second
        Thread.sleep(1000);

//click on the bell icon
        driver.findElement(By.xpath("//*[contains(@class, 'rapid-nonanchor')]")).click();

//wait 2 seconds
        Thread.sleep(2000);

//quit chrome
        driver.quit();




    }//end of main
}//end of class

