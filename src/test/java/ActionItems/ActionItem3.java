package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class ActionItem3 {
    public static void main(String[] args) throws InterruptedException {
        //define the web-driver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        // add the options for maximizing and incognito
        options.addArguments("start-fullscreen", "incognito");
        //define the chrome driver to use
        //creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver(options);
        //Array list created/entered for zip code
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11208");
        zipCode.add("11416");
        zipCode.add("11101");
        //define javascript executor
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //for loop to iterate zipcode
        for (int i = 0; i < zipCode.size(); i++) {
            //navigate to the weight-watchers site
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");
            //wait 2 seconds
            Thread.sleep(2000);
            //click on FInd a Workshop link
            driver.findElements(By.xpath("//*[text()='Find a Workshop']")).get(0).click();
            //wait 2 seconds
            Thread.sleep(2000);
            //store the locator as WebElement in search variable
            WebElement search = driver.findElement(By.xpath("//*[@id='location-search']"));
            //clear search bar
            search.clear();
            //enter zipCodes and iterate using i variable
            search.sendKeys(zipCode.get(i));
            //click on search arrow
            driver.findElement(By.xpath("//*[@id='location-search-cta']")).click();
            //wait 2 seconds
            Thread.sleep(2000);
            //scroll to the address
            jse.executeScript("scroll(0,800)");
            //declare webElement arraylist for studios
            ArrayList<WebElement> studio = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class, 'wrapperLink')]")));

            //create an if condition
            if (i == 0) {
                jse.executeScript("scroll(0,1000)");
                //wait 2 seconds
                Thread.sleep(2000);
                studio.get(1).click();
            } else if (i == 1) {
                jse.executeScript("scroll(0,1400)");
                studio.get(2).click();
            } else if (i == 2) {
                studio.get(0).click();
            }//end of conditions
            String studioAddress = driver.findElements(By.xpath("//*[contains(@class, 'address')]")).get(1).getText();
            //call split address by using String array
            String[] splitStudioAddress = studioAddress.split("\n");
            System.out.println(splitStudioAddress[0] + "\n" + splitStudioAddress[1]);
            jse.executeScript("scroll(0,600)");
            String schedule = driver.findElement(By.xpath("//*[contains(@class, 'scheduleContainerMobile')]")).getText();
            System.out.println(schedule);
        }//end of loop
        //driver quit
        driver.quit();
    }//end of main
}//end of class


