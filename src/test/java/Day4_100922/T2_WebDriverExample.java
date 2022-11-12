package Day4_100922;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_WebDriverExample {

    public static void main(String[] args) throws InterruptedException {

        //define the WebDriver manager setup from chromeDriver
        WebDriverManager.chromedriver().setup();

        //define the chrome driver to use for your test
        //creating an instance for a chrome driver(driver) to use for automation
        WebDriver driver= new ChromeDriver();

        //navigate to google site
        driver.navigate().to("https://www.google.com");

        //wait few seconds
        Thread.sleep(3000);

        //quit the chrome session
        driver.quit();

    }//end of main

}//end of class
