package TestCases;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import UtilityFiles.DataProviders;
import org.testng.annotations.Test;

import static TestCases.BaseClass.driver;

public class TC004_Test extends BaseClass {
    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "Datadriven")
    public void verify_loginDDT(String email, String pwd, String exp) {

        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        logger.info("clicked on myaccount link on the home page..");
        hp.clickLogin(); //Login link under MyAccount
        logger.info("clicked on login link under myaccount..");

        logger.info("Navigated to login page, now About to login");
        LoginPage lp = new LoginPage(driver);

        lp.enterEmail(email);
        logger.info("email entered");
//        Thread.sleep(2000);
        lp.enterPass(pwd);
        logger.info("password entered");
//        Thread.sleep(2000);

//
        lp.clickLogin();
//        Thread.sleep(2000);

    }
}
