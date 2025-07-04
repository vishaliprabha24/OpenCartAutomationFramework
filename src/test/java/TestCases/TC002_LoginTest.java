package TestCases;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import org.testng.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import TestCases.BaseClass;


public class TC002_LoginTest extends BaseClass{

    @Test(groups={"Sanity","Master"})
    public void verify_login(){
        try {

            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("clicked on myaccount link on the home page..");
            hp.clickLogin(); //Login link under MyAccount
            logger.info("clicked on login link under myaccount..");

            logger.info("Navigated to login page, now About to login");
            LoginPage lp = new LoginPage(driver);

            lp.enterEmail(p.getProperty("email"));
            logger.info("email entered");
//            Thread.sleep(2000);

            lp.enterPass(p.getProperty("password"));
            logger.info("password entered");
//            Thread.sleep(2000);

            lp.clickLogin();

            MyAccountPage mp = new MyAccountPage(driver);
            Boolean mpresult = mp.isMyAccountPageExists();
            if(mpresult.booleanValue()){
                Assert.assertTrue(true);
                logger.info("Loggedin successfull and navigated to Myaccount page");
            }
            else {
                logger.error("Loggedin failed and not navigated to Myaccount page");
                logger.debug("debug logs");
                Assert.assertTrue(false);
            }
//            Assert.assertEquals(mpresult, true);
//            logger.info("Loggedin successfull and navigated to Myaccount page");

        }
        catch (Exception e){
//            logger.error("Loggedin failed and not navigated to Myaccount page");
            Assert.fail();
        }
    }
}
