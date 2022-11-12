package ActionItems;

import ReusableLibrary.ReusableActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class UHC {

    WebDriver driver;

    @BeforeSuite
    public void setChromeDriver(){
        driver = ReusableActions.setUpDriver();
    }//end of set up driver method

    @AfterSuite
    public void quitTheSession(){
        driver.quit();
    }//end of the after suite

    @Test()
    public void findADoctor() throws InterruptedException {
        //navigate to the website
        driver.navigate().to("https://www.uhc.com/");
        //wait a bit
       // Thread.sleep(2000);
        //click find a doctor
        ReusableActions.clickAction(driver, "//*[@aria-label='Find a doctor']", "Find a doctor");
        //Thread.sleep(3000);
        //scroll to view find a doctor
        ReusableActions.scrollByViewAction(driver, "//*[@id='main-content']",0, "main content");
        //wait a bit
       // Thread.sleep(2000);
        //click on find a dentist
        ReusableActions.clickAction(driver, "//*[text()='Find a dentist']", "Find a Dentist");
        //switch tabs
        ReusableActions.switchToTabsAction(driver,1);
        //refresh page
        driver.navigate().refresh();
        //click on employer and individual plan
        ReusableActions.clickAction(driver,"//*[text()='Employer and Individual Plans']", "Employer and Individual Plans");
    }//end of test 1

    @Test(dependsOnMethods = "findADoctor")
    public void zipCode() throws InterruptedException {
        //enter zipcode
        ReusableActions.sendKeysAction(driver, "//*[@id='location']", "11003", "zipCode");
        //click continue
        ReusableActions.clickAction(driver, "//*[@cs-id='locationSubmit']", "Continue");
        //wait a bit
        //Thread.sleep(3000);
        //click on national options
        ReusableActions.clickAction(driver,"//*[text()='*National Options PPO 30']", "National Options");
        //click on general dentist
        ReusableActions.clickAction(driver,"//*[@id='nodeDescription1']","click on general dentist");
    }//end of test 2

  @Test(dependsOnMethods = "zipCode")
    public void doctorAddress(){
        //select 50 miles from drop down
        ReusableActions.selectByTextAction(driver, "//*[@id='distance']", 0,"With 50 miles", "miles dropdown on general dentist");
        //click on first doctor
        ReusableActions.clickActionByIndex(driver, "//*[data-ui-element-name='search-result-person']", 0 , "click First doctor" );
        //click save
        ReusableActions.clickAction(driver,"//*[@class='cta-header-button action-btn saved-provider-button negative']", "Click save on doctor page");
        //capture address, miles and network type
      String info = ReusableActions.getTextAction(driver, "//*[@class='outer-container tbl']", "Address, Miles and Network Types");
      //print-out info
      System.out.println(info);
      //close tab
      driver.close();
    }//end of test 3

    @Test(dependsOnMethods = "doctorAddress")
    public void doctor(){
        //switch to default tab
        ReusableActions.switchToTabsAction(driver, 0);
        //enter doctor in search field
        ReusableActions.sendKeysAction(driver, "//*[@id='search-desktop']", "Typing doctor in search field", "Search Doctor");
        //click submit on the search
        ReusableActions.clickAction(driver, "//*[@id='search__button-desktop']", "click search" );
        //capture search results
        String searchResults = ReusableActions.getTextAction(driver, "//*[@id='search-results-count__header']", "Search Results");

        String[] arrayResults = searchResults.split(" ");
        System.out.println(arrayResults[0] + arrayResults[1] + arrayResults[2]);
    }//end of test 4

}//end of class

