package tests.mfaPage.positive;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tests.base.BaseTest;
import static com.codeborne.selenide.Condition.visible;
import static constants.Constants.DOMAINS_URL.ABTASTY_LOGIN_PAGE;
import static constants.Constants.DOMAINS_URL.SMS_CODE_API;
import static constants.Constants.TestDataForSigningIn.*;

public class MFAPagePositiveTests extends BaseTest {

    /* Delete @Disabled annotation after getting valid in
      1) EMAIL, NON_ABTASTY_USER_EMAIL ,PASSWORD, NON_ABTASTY_USER_PASSWORD in Constants class.
      2) writing API path in SMS_CODE_API and TITLE_TEXT also in Constants class.
      3) writing Xpath for button_OK_For_SMS_Code, inputSMS in MFAPage Class */
    @Disabled
    @ParameterizedTest(name = "Sign in with valid email and password with MFA code - {0}")
    @CsvSource ({
                 EMAIL + "," + PASSWORD,
                 NON_ABTASTY_USER_EMAIL + "," + NON_ABTASTY_USER_PASSWORD
    })
    @DisplayName("ID 10,11 : Sign in with valid email and password with MFA code")
    void checkSignInWithMFAValidCode(String email, String password) {
        basePage.goToURL(ABTASTY_LOGIN_PAGE);
        loginPage
                .enterEmail(email)
                .enterPassword(password)
                .clickSignInButton();
        mfaPage
                .setConfirmationCodeSms(SMS_CODE_API, EMAIL)
                .clickOkButton()
                .checkInfo(TITLE_TEXT, visible);
    }

    @Disabled
    @Test
    @DisplayName("ID 13 : Verify that a user can successfully save the device in session storage after MFA")
    void checkSignInWithMFAInvalidCode() {
        basePage.goToURL(ABTASTY_LOGIN_PAGE);
        loginPage
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .clickSignInButton();
        mfaPage
                .setConfirmationCodeSms(SMS_CODE_API,EMAIL)
                .clickCheckBoxForTick()
                .clickOkButtonIfCheckBoxSelected()
                .checkInfo(TITLE_TEXT, visible);

    }

    @Disabled
    @Test
    @DisplayName("ID 15 : Check arrow back button on MFA page")
    void checkArrowBackButtonOfMFA() {
        basePage.goToURL(ABTASTY_LOGIN_PAGE);
        loginPage
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .clickSignInButton();
        mfaPage
                .clickArrowBackButton()
                .checkInfo(LOGIN_PAGE_TITLE_TEXT, visible);

    }

    @Disabled
    @Test
    @DisplayName("ID 18 : Check the receiving of another code")
    void checkAnotherSMSCodeToBeReceived() {
        basePage.goToURL(ABTASTY_LOGIN_PAGE);
        loginPage
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .clickSignInButton();
        mfaPage
                .setConfirmationCodeSms(SMS_CODE_API,EMAIL)
                .clickRenvoyerLeCode()
                .checkInfo(LOGIN_PAGE_TITLE_TEXT, visible);
        //       ДОДЕЛАТЬ!!!!
    }

}
