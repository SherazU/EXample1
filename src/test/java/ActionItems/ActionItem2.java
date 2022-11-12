package ActionItems;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
public class ActionItem2 {
    public static void main(String[] args) throws InterruptedException {

        //ArrayList for places
        ArrayList<String> regions = new ArrayList<>();
        regions.add("North");
        regions.add("South");
        regions.add("East");
        regions.add("West");

        //define the webDriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();

        //creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver();


        for (int i = 0; i < regions.size(); i++) {

            //navigate to the bing site
            driver.navigate().to("https://www.bing.com/");

            //sleep statement
            Thread.sleep(3000);

            //relative xpath to locate the element
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(regions.get(i));

            //hit submit on the Google search button
            driver.findElement(By.xpath("//*[@id= 'search_icon']")).submit();

            //sleep statement
            Thread.sleep(3000);

            //capture the search result text
            String result = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();

            //split message to extract out the search number
            String[] splitResult = result.split(" ");
            System.out.println("the search number is for " + regions.get(i) + " is " + splitResult[0]);

        }//end of loop
        driver.quit();
    }//end of main
}//end of class

