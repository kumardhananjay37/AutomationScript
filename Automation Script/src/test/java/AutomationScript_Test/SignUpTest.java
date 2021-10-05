package AutomationScript_Test;

import BasePage.DesktopBase;
import Pages.LoginPage;
import Pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends DesktopBase {
    @Test
    public void verifySignUpAmazonWithExistingUser() {
       boolean isStepTrue;

        SignUpPage signUpPage = new SignUpPage(driver);
        String customerNameText = propertyUtils.propertyValueOf("expectedUserName");
        String customerPhoneNumber = propertyUtils.propertyValueOf("mobileNumber");
        String customerPasswordText = propertyUtils.propertyValueOf("singUppassword");
        String warningText = propertyUtils.propertyValueOf("warningText");
        String mobileNumber = propertyUtils.propertyValueOf("mobileNumber");
        isStepTrue=signUpPage.signUpAmazonIsUn_Successfully(customerNameText,customerPhoneNumber,customerPasswordText,warningText,mobileNumber);
        Assert.assertTrue(isStepTrue,"The is not existing therefore it will required to singUp properly.");
    }
}
