package Pages;

import CommonFunctions.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage
{
    WebDriver driver;
    CommonMethods commonMethods;
    public SignUpPage(WebDriver driver)
    {
        this.driver=driver;
        commonMethods=new CommonMethods(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@id='nav-signin-tooltip']//span")
    private static WebElement frontPageLoginBtn;
    @FindBy(id="createAccountSubmit")
    private static WebElement signUpBtn;
    @FindBy(id = "ap_customer_name")
    private static WebElement customerName;
    @FindBy(id = "ap_phone_number")
    private static WebElement customerPhone;
    @FindBy(id = "ap_password")
    private static WebElement customerPassword;
    @FindBy(id = "continue")
    private static WebElement continueBtn;
    @FindBy(xpath = "(//h4[@class='a-alert-heading'])[2]")
    private static WebElement signUpWarning;
    @FindBy(xpath = "//div[@class='a-alert-content']//child::b")
    private static WebElement warningMoblieNumber;

    public boolean signUpAmazonIsUn_Successfully(String customerNameText,String customerPhoneNumber,String customerPasswordText,String warningText,String mobileNumber)
    {
        boolean isSignUpSuccessful=true;

        try
        {
            commonMethods.clickElement(frontPageLoginBtn,20,"Front page Sign in button");
            commonMethods.clickElement(signUpBtn,20,"SignUp button");
            commonMethods.sendKeyBoolean(customerName,customerNameText);
            commonMethods.sendKeyBoolean(customerPhone,customerPhoneNumber);
            commonMethods.sendKeyBoolean(customerPassword,customerPasswordText);
            commonMethods.clickElement(continueBtn,20,"Continue button after filling sign up button");
            isSignUpSuccessful &=commonMethods.checkElementText(signUpWarning,warningText,20,"SignUp warning test");
            isSignUpSuccessful &=commonMethods.checkElementText(warningMoblieNumber,mobileNumber,20,"SignUp warning with mobile number");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("******************* signUpAmazonSuccessfully failed *********");
        }
        return isSignUpSuccessful;
    }
}
