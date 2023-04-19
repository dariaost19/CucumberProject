package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonMethods {
    public LoginPage(){

        PageFactory.initElements(driver,this); //initialize driver which is on this page
    }

    @FindBy(id="txtUsername")
    public WebElement userNameTextBox;
    @FindBy(id="txtPassword")
    public  WebElement passwordTextBox;
    @FindBy(id = "btnLogin")
    public WebElement loginBtn;
    //page factory Model
    @FindBy(id = "welcome")
   public WebElement  welcomeIcon;
    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement logOut;





}
