package Pages;

import CommonFunctions.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
    WebDriver driver;
    CommonMethods commonMethods;
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        commonMethods=new CommonMethods(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@id='nav-signin-tooltip']//span")
    private static WebElement frontPageLoginBtn;
    @FindBy(id="ap_email")
    private static WebElement emailTextArea;
    @FindBy(id="continue")
    private static WebElement continueBtn;
    @FindBy(id="ap_password")
    private static WebElement passwordTextArea;
    @FindBy(id="signInSubmit")
    private static WebElement signIn;
    @FindBy(id="nav-link-accountList-nav-line-1")
    private static WebElement loginUserName;

    @FindBy(className = "a-expander-prompt")
    private static WebElement forgotPasswordBtn;



    public boolean loginAmazonWithCredential(String email,String password, String expectedLoginUserName)
    {
        boolean isLogingSuccessful =true;

        try{
            commonMethods.clickElement(frontPageLoginBtn,20,"Fron page Sing In button got clicked.");
            commonMethods.sendKeyBoolean(emailTextArea,email);
            commonMethods.clickElement(continueBtn,20,"Continue button");
            commonMethods.sendKeyBoolean(passwordTextArea,password);
            commonMethods.clickElement(signIn,20,"Sing in button after providing credentials");
            isLogingSuccessful &=commonMethods.checkElementText(loginUserName,expectedLoginUserName,30,"Logged in user name");
        }
        catch (Exception e)
        {
            System.out.println("**************** loginAmazonWithCredential is failed.**********************");
            e.printStackTrace();
        }
        return isLogingSuccessful;
    }
}
