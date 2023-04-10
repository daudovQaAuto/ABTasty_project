package tests.loginPage.negative;

import commonActions.CommonActions;
import commonActions.Listener;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
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
@Story("A negative scenario")
@ExtendWith(Listener.class)
@Execution(ExecutionMode.CONCURRENT)



public class LoginPageNegativeTests extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {INVALID_EMAIL_MISSED_AT_SIGN
                           ,INVALID_EMAIL_MISSED_DOMAIN
                           ,INVALID_EMAIL_WITH_INVALID_CHARACTERS
                           ,INVALID_EMAIL_WITH_CYRILLIC_LETTERS})
    @DisplayName("ID 2: Verify that an error message is displayed with invalid emails")
    void checkLogInWithInvalidEmails(String email) {
        basePage.goToURL(ABTASTY_LOGIN_PAGE);
        loginPage
                .enterEmail(email)
                .enterPassword(PASSWORD)
                .clickSignInButton()
                .checkInfo(ERROR_MESSAGE,visible);
    }


    @ParameterizedTest
    @ValueSource(strings = {INVALID_PASSWORD_LESS_8_CHARACTERS
                           ,INVALID_PASSWORD_MORE_64_CHARACTERS
                           ,INVALID_PASSWORD_NO_SYMBOLS})
    @DisplayName("ID 3: Verify that an error message is displayed with invalid password")
    void checkSignInWithInvalidPassword(String password) {
        basePage.goToURL(ABTASTY_LOGIN_PAGE);
        loginPage
                .enterEmail(EMAIL)
                .enterPassword(password)
                .clickSignInButton();
            loginPage.checkInfo(ERROR_MESSAGE, visible);
            CommonActions.clearBrowserCookiesAndStorage();
    }
}
