package AutomationScript_Test;

import BasePage.DesktopBase;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends DesktopBase {
    @Test
    public void verifyUserLoginWithCredential() {
       boolean isStepTrue;

        LoginPage loginPage = new LoginPage(driver);
        String email = propertyUtils.propertyValueOf("loginEmail");
        String password = propertyUtils.propertyValueOf("loginPassword");
        String expecteUserName = propertyUtils.propertyValueOf("expectedUserName");
        isStepTrue=loginPage.loginAmazonWithCredential(email, password, expecteUserName);
        Assert.assertTrue(isStepTrue,"Amazon login with credentials failed.");
    }
}
