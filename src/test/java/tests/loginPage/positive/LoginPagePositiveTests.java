package tests.loginPage.positive;

import commonActions.Listener;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.base.BaseTest;
import static com.codeborne.selenide.Condition.visible;
import static constants.Constants.DOMAINS_URL.ABTASTY_LOGIN_PAGE;
import static constants.Constants.TestDataForSigningIn.*;
import static constants.Docs.TEST_CASES_URL;

@Link(name = "test cases", url = TEST_CASES_URL)
@Story("A positive scenario")
@ExtendWith(Listener.class)
@Execution(ExecutionMode.CONCURRENT)

public class LoginPagePositiveTests extends BaseTest {

    /* Delete @Disabled annotation after getting valid credentials (EMAIL/PASSWORD)
       and writing text from the title of home page to "TITLE_TEXT" in Constants */
    @Disabled
    @Test
    @DisplayName("ID 1: Verify that a user can successfully log in with valid email and password")
    void checkLogInWithValidData() {
        basePage.goToURL(ABTASTY_LOGIN_PAGE);
        loginPage
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .clickSignInButton()
                .checkInfo(TITLE_TEXT, visible);
    }

    /* Delete @Disabled annotation after getting valid EMAIL_SSO in Constants
       and writing Xpath to "invitationToUseSSOLogin" locator in LoginPage */
    @Disabled
    @Test
    @DisplayName("ID 4: Check the display of invitation link to sign in as SSO user")
    void checkInvitationFor_SSO_User() {
        basePage.goToURL(ABTASTY_LOGIN_PAGE);
        loginPage
                .enterEmail(EMAIL_SSO)
                .checkSSOLinkInvitation();
    }

    @Test
    @DisplayName("ID 6: Check if the button eye/strikethrough shows/hides the password input")
    void checkDisplayPasswordWhenClickEyeButton() {
        basePage.goToURL(ABTASTY_LOGIN_PAGE);
        loginPage
                .enterPassword(PASSWORD)
                .clickEyeButton()
                .checkDisplayPassword();
    }

    @ParameterizedTest
    @ValueSource(strings = {INVALID_PASSWORD_NO_NUMBERS
                           ,INVALID_PASSWORD_LESS_8_CHARACTERS
                           ,INVALID_PASSWORD_NO_NUMBERS})
    @DisplayName("ID 8: Check Captcha triggering after 3 attempts to click the sign in button with an invalid password(s)")
    void checkCaptchaTriggering(String password) {
        basePage.goToURL(ABTASTY_LOGIN_PAGE);
        loginPage
                .enterEmail(EMAIL)
                .enterPassword(password)
                .clickSignInButton()
                .clickCheckBoxRecaptcha();
    }

    @Disabled
    @Test
    @DisplayName("NOT REQUIRED")
    void checkIn() {
        basePage.goToURL(ABTASTY_LOGIN_PAGE);
        loginPage
                .signInWithGoogleAccount()
                .checkInfo("AB Tasty - Experience Optimization Platform", visible);
    }
}
