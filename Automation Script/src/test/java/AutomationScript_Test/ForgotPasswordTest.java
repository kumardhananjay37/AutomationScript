package AutomationScript_Test;

import BasePage.DesktopBase;
import Pages.ForgotPasswordPage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends DesktopBase {
    @Test
    public void verifyForgotUser() {
       boolean isStepTrue;

        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        String mobile = propertyUtils.propertyValueOf("mobileNumber");
        String expectedOTPText = propertyUtils.propertyValueOf("textOTP");
        isStepTrue=forgotPasswordPage.checkForgotPasswordFunction(mobile,expectedOTPText);
        Assert.assertTrue(isStepTrue,"Forgot function is not verified.");
    }
}
