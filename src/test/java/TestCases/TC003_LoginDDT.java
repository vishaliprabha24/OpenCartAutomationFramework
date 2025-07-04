package TestCases;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import UtilityFiles.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003_LoginDDT extends BaseClass{

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "Datadriven")
    public void verify_loginDDT(String email, String pwd, String exp) {
            try {
                HomePage hp = new HomePage(driver);
                hp.clickMyAccount();
                logger.info("clicked on myaccount link on the home page..");
                hp.clickLogin(); //Login link under MyAccount
                logger.info("clicked on login link under myaccount..");

                logger.info("Navigated to login page, now About to login");
                LoginPage lp = new LoginPage(driver);

                lp.enterEmail(email);
                logger.info("email entered");
              Thread.sleep(2000);
                lp.enterPass(pwd);
                logger.info("password entered");
                Thread.sleep(2000);

//
                lp.clickLogin();
                Thread.sleep(2000);


                MyAccountPage mp = new MyAccountPage(driver);
                Boolean targetpage = mp.isMyAccountPageExists();

                if (exp.equalsIgnoreCase("Valid")) {
                    if (targetpage == true) {
                        mp.clickLogout();
                        Thread.sleep(2000);
                        Assert.assertTrue(true);
                    } else {
                        Assert.assertTrue(false);
                    }
                } else if (exp.equalsIgnoreCase("Invalid")) {
                    if (targetpage == true) {
                        mp.clickLogout();
                        Thread.sleep(2000);
                        Assert.assertTrue(false);
                    } else {
                        Assert.assertTrue(true);
                    }
                }
            }
            catch (Exception e){
                Assert.fail();
            }
    }

}
