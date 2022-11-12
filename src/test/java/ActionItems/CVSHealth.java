package ActionItems;

import ReusableLibrary.ReusableActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class CVSHealth {
    //declare web-driver variable
    WebDriver driver;
    @BeforeSuite
    public void SetChromeDriver(){
        driver = ReusableActions.setUpDriver();
        //navigate to CVS Health page
        driver.navigate().to("https://www.cvshealth.com/");
        //click on dropdown
        ReusableActions.clickAction(driver, "//*[@class='open-mobile-menu-inner']","drop down" );
        //click by index our services
        ReusableActions.clickActionByIndex(driver, "//*[@class='menu-expand-button']", 6, "Our services");
        //click pharmacy services
        ReusableActions.clickActionByIndex(driver, "//*[@aria-label='Button. Pharmacy services. expand. 4 of 6']", 2, "Pharmacy services");
        //select mail pharmacy
        ReusableActions.clickActionByIndex(driver, "//*[@class='menu-expand-button button-level-2']", 18 , "Mail Pharmacy");





    }//end of set driver method
    @AfterSuite
    public void quitTheSession(){
        driver.quit();
    }//end of after suite


}//end of class
