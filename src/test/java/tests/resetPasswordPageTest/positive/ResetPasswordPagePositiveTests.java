package tests.resetPasswordPageTest.positive;

import commonActions.Listener;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import tests.base.BaseTest;


import static com.codeborne.selenide.Condition.visible;
import static constants.Constants.DOMAINS_URL.ABTASTY_LOGIN_PAGE;
import static constants.Constants.TestDataForSigningIn.*;
import static constants.Docs.TEST_CASES_URL;

@Link(name = "test cases", url = TEST_CASES_URL)
@Story("A positive scenario")
@ExtendWith(Listener.class)
@Execution(ExecutionMode.CONCURRENT)

public class ResetPasswordPagePositiveTests extends BaseTest {

    @Test
    @DisplayName("ID 7: Check the display of confirmation message for password reset")
    void checkSignInWithSSO() {
        basePage
                .goToURL(ABTASTY_LOGIN_PAGE);
        loginPage
                .clickForgotYourPasswordLink();
        resetPasswordPage
                .enterEmail(EMAIL)
                .clickPasswordResetLinkButton()
                .checkDisplayOfResetConfirmationMessage();
    }

    @Test
    @DisplayName("ID 16: Check arrow back button on Reset password page")
    void checkArrowButtonOfRPP() {
        basePage
                .goToURL(ABTASTY_LOGIN_PAGE);
        loginPage
                .clickForgotYourPasswordLink();
        resetPasswordPage
                .clickArrowBackButtonPasswordResetPage()
                .checkInfo(LOGIN_PAGE_TITLE_TEXT, visible);
    }
}
