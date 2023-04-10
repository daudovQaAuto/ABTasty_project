package tests.mfaPage.negative;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.visible;
import static constants.Constants.DOMAINS_URL.ABTASTY_LOGIN_PAGE;
import static constants.Constants.DOMAINS_URL.SMS_CODE_API;
import static constants.Constants.TestDataForSigningIn.*;

public class MFAPageNegativeTests extends BaseTest {


    /* Delete @Disabled annotation after getting valid in
      1) EMAIL,PASSWORD and ERROR_MESSAGE_INVALID_SMS in Constants class.
      2) writing Xpath for button_OK_For_SMS_Code, inputSMS in MFAPage Class
      */
    @Test
    @DisplayName("ID 12 : Verify that an error message is displayed when entering an invalid MFA code")
    void checkSignInWithMFAInvalidCode() {
        basePage.goToURL(ABTASTY_LOGIN_PAGE);
        loginPage
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .clickSignInButton();
        mfaPage
                .setConfirmationInvalidCodeSms()
                .clickOkButton()
                .checkInfo(ERROR_MESSAGE_INVALID_SMS, visible);
    }

    @Disabled
    @Test
    @DisplayName("ID 14 : Verify that a user can't log in after expiration of MFA code")
    void checkExpirationOfMFACode() {
        basePage.goToURL(ABTASTY_LOGIN_PAGE);
        loginPage
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .clickSignInButton();
        mfaPage
                .setConfirmationCodeSms(SMS_CODE_API,EMAIL);
        Selenide.sleep(60000);
        mfaPage
                .clickOkButton()
                .checkInfo(ERROR_MESSAGE_INVALID_SMS, visible);

    }
}
