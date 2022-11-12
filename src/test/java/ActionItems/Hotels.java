package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class Hotels {
    public static void main(String[] args) throws InterruptedException {

//set up your chromedriver with web-driver-manager
        WebDriverManager.chromedriver().setup();
//define the web-driver and pass the options into the method
        WebDriver driver = new ChromeDriver();
//initialize chrome options
        ChromeOptions options = new ChromeOptions();
//add options for maximizing the Chrome window
        options.addArguments("start-maximized");


//Array list for destination, adults, and child-age
        ArrayList<String> destination = new ArrayList<>();
        destination.add("Virgina");
        //destination.add("New Jersey");
        //destination.add("Dallas");
        ArrayList<Integer> adults = new ArrayList<>();
        adults.add(2);
        adults.add(3);
        adults.add(4);
        ArrayList<String> childage = new ArrayList<>();
        childage.add("1");
        childage.add("1");
        childage.add("2");

        for (int i = 0; i < destination.size(); i++) {
            //goto hotels page
            try {
                driver.navigate().to("https://www.hotels.com/");
            } catch (Exception e) {
                System.out.println("Unable goto hotels page " + e);
            }
            //wait a bit
            Thread.sleep(4000);

            //click on search destination
            try {
                driver.findElement(By.xpath("//*[@class='uitk-fake-input uitk-form-field-trigger']")).click();
            } catch (Exception e) {
                System.out.println("Unable click on search destination " + e);
            }

            //enter destinations
            try {
                driver.findElement(By.xpath("//*[@id='destination_form_field']")).sendKeys(destination.get(i) + "\n");
            } catch (Exception e) {
                System.out.println("unable to enter destinations " + e);
            }
            //wait a bit
            Thread.sleep(2000);

            //click on travels
            try {
                driver.findElement(By.xpath("//*[contains(@class, 'uitk-menu-trigger uitk-fake-input')]")).click();
            } catch (Exception e) {
                System.out.println("unable to click travels " + e);
            }
            //wait a bit
            Thread.sleep(2000);

            //set adult list back to 1
            try {
                driver.findElement(By.xpath("//*[contains(@aria-label, 'Decrease the number of adults in room 1')]")).click();
            } catch (Exception e) {
                System.out.println("unable to set adult back to 1 " + e);
            }
            //wait a bit
            Thread.sleep(1000);

            //loop to iterate adults arraylist
            for (int j = 1; j < adults.size(); j++) {
                try {
                    driver.findElements(By.xpath("//*[contains(@class,'uitk-icon uitk-step-input-icon uitk')]")).get(1).click();
                } catch (Exception e) {
                    System.out.println("unable to iterate adults arraylist " + e);
                }
            }//end of 2nd loop
            Thread.sleep(1000);

            //click on children as one always
            try {
                driver.findElements(By.xpath("//*[contains(@class,'uitk-icon uitk-step-input-icon uitk')]")).get(3).click();
            } catch (Exception e) {
                System.out.println("unable to set children to one " + e);
            }
            //wait a bit
            Thread.sleep(2000);

            //pass childage values
            WebElement age = driver.findElement(By.xpath("//*[@name='child-traveler_selector_children_age_selector-0-0']"));
            Select dropDownForAge = new Select(age);

            //select childage from arraylist
            try {
                dropDownForAge.selectByVisibleText(childage.get(i));
            } catch (Exception e) {
                System.out.println("unable iterate childage" + e);
            }
            Thread.sleep(2000);

            //click on done
            try {
                driver.findElement(By.xpath("//*[@id= 'traveler_selector_done_button']")).click();
            } catch (Exception e) {
                System.out.println("unable click on done under travelers " + e);
            }

            //click on search
            try {
                driver.findElement(By.xpath("//*[@id= 'submit_button']")).click();
            } catch (Exception e) {
                System.out.println("unable click on search " + e);
            }
            //wait a bit
            Thread.sleep(2000);

            //make arraylist for hotels
            ArrayList<WebElement> hotels = new ArrayList<>(driver.findElements(By.xpath("//*[@class='uitk-spacing uitk-spacing-margin-blockstart-three']")));

            //creating conditional statement
            if (i == 0) {
                //click on first hotel
                try {
                    hotels.get(2).click();
                } catch (Exception e) {
                    System.out.println("unable click 1st hotel " + e);
                }
            } else if (i == 1) {
                //click on 3rd hotel
                try {
                    hotels.get(5).click();
                } catch (Exception e) {
                    System.out.println("unable click 3rd hotel " + e);
                }
            } else if (i == 2) {
                //click 2nd hotel
                try {
                    hotels.get(4).click();
                } catch (Exception e) {
                    System.out.println("unable click 2nd hotel " + e);
                }
            }//end of conditional statement
            //wait a bit
            Thread.sleep(1000);

            //create arraylist to switch to tabs
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch tabs
            try {
                driver.switchTo().window(tabs.get(1));
            } catch (Exception e) {
                System.out.println("unable switch tabs " + e);
            }
            //wait a bit
            Thread.sleep(7000);

            //capture the name of the resort and print it
            String capture = driver.findElements(By.xpath("//*[contains(@class,'uitk-heading uitk-heading-3')]")).get(0).getText();
            System.out.println("The hotel name is " + "\n" + capture);

            //click on reserve now
            try {
                driver.findElement(By.xpath("//*[@data-stid='navbar-quick-reserve-button']")).click();
            } catch (Exception e) {
                System.out.println("unable to click Reserve a room " + e);
            }
            //wait a bit
            Thread.sleep(2000);

            //capture price per night
            String price = driver.findElements(By.xpath("//*[contains(@class,'uitk-text uitk-type-600')]")).get(0).getText();
            System.out.println("Price for one night is " + price);

            //click on reserve button
            try {
                driver.findElement(By.xpath("//*[@data-stid='submit-hotel-reserve']")).click();
                //wait a bit
                Thread.sleep(3000);
                //capture the check in and check out date
                String date = driver.findElement(By.xpath("//*[@class='booking-details-travel-details-wrapper fs-base clear bg-white mb-none--xs bd-all bdra-big mt-mouse']")).getText();
                //display check-in and checkout time in one line
                String[] splitDate = date.split("\n");
                System.out.println(splitDate[0] + " " + splitDate[1] + "\n" + splitDate[2] + " " + splitDate[3]);
                //separate line
                System.out.println();

            } catch (Exception e) {
                System.out.println("unable to capture check in and check out date " + e);
            }

            //close tab
            driver.close();
            //switch to first tab
            driver.switchTo().window(tabs.get(0));
        }//end loop

        driver.quit();
    }//end of main
}//end of class






