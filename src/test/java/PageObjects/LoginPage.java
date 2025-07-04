package PageObjects;

import TestCases.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseConstructorPage {
    public LoginPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement email;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginbutton;

    public void enterEmail(String mail){
        email.sendKeys(mail);
    }
    public void enterPass(String pass){
        password.sendKeys(pass);
    }
    public void clickLogin(){
        loginbutton.click();
    }

}
