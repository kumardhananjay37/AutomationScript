package Pages;

import CommonFunctions.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage
{
    WebDriver driver;
    CommonMethods commonMethods;
    public ForgotPasswordPage(WebDriver driver)
    {
        this.driver=driver;
        commonMethods=new CommonMethods(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@id='nav-signin-tooltip']//span")
    private static WebElement frontPageLoginBtn;
    @FindBy(className="a-expander-prompt")
    private static WebElement needHelp;
    @FindBy(id="auth-fpp-link-bottom")
    private static WebElement forgotPassword;
    @FindBy(xpath="//input[@type='email']")
    private static WebElement emailOrMobileTextArea;
    @FindBy(id="continue")
    private static WebElement continueBtn;
    @FindBy(xpath = "//div[@class='a-row a-spacing-none']/span[2]")
    private static WebElement textOTP;


    public boolean checkForgotPasswordFunction(String mobile, String expectedOTPText)
    {
        boolean isForgotPasswordRun= true;
        String text=null;
        try
        {
            commonMethods.clickElement(frontPageLoginBtn,20,"Front page SingIN button");
            commonMethods.clickElement(needHelp,20,"Need help button");
            commonMethods.clickElement(forgotPassword,50,"Forgot button");
            commonMethods.sendKeyBoolean(emailOrMobileTextArea,mobile,30,"Email or password text area");
            commonMethods.clickElement(continueBtn,20,"Continue button after Email or Phone insert.");
            text=commonMethods.getElementText(textOTP,30);
            isForgotPasswordRun  &=commonMethods.compareTexts(text,expectedOTPText);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("************************** checkForgotPasswordFunction failed.******************************");
        }
        return isForgotPasswordRun;
    }
}
