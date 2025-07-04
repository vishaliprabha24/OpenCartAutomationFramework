package TestCases;

import PageObjects.AccountRegistrationPage;
import PageObjects.HomePage;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class TC001_AccountRegistrationTest extends BaseClass{

    @Test(groups={"Regression","Master"})
    public void verify_account_registration(){
        try {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickRegister();

            logger.info("***TEST STARTED***");

            AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

            regpage.setFirstName(p.getProperty("firstname1"));
            regpage.setLastName(p.getProperty("lastname1"));
            regpage.setEmail(randomeString() + "@gmail.com");
            regpage.setTelephone(p.getProperty("mobilenumber1"));
            String mypass=p.getProperty("password1");
            regpage.setPassword(mypass);
            regpage.setConfirmPassword(mypass);

            logger.info("***INPUT VALUES ENTERED***");

            regpage.setPrivacyPolicy();
            regpage.clickContinue();

            logger.info("***BUTTON SUBMITTED***");

            String confmsg = regpage.getConfirmationMsg();
            Assert.assertEquals(confmsg, "Your Account Has Been Created!");
        }
        catch (Exception e){
            logger.error("Test failed");
            logger.debug("Debug logs");
            Assert.fail();
        }
    }

}
