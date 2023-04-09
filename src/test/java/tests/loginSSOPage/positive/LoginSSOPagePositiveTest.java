package tests.loginSSOPage.positive;

import commonActions.Listener;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.visible;
import static constants.Constants.DOMAINS_URL.ABTASTY_LOGIN_PAGE;
import static constants.Constants.TestDataForSigningIn.EMAIL_SSO;
import static constants.Constants.TestDataForSigningIn.TITLE_TEXT;
import static constants.Docs.TEST_CASES_URL;


@Link(name = "test cases", url = TEST_CASES_URL)
@Story("A positive scenario")
@ExtendWith(Listener.class)
@Execution(ExecutionMode.CONCURRENT)

public class LoginSSOPagePositiveTest extends BaseTest {

    /* Delete @Disabled annotation after getting valid credentials (EMAIL_SSO)
       and writing text from the title of home page to "TITLE_TEXT" in Constants */
    @Disabled
    @Test
    @DisplayName("Authorization, client with valid SSO credentials")
    void checkSignInWithSSO() {
        basePage
                .goToURL(ABTASTY_LOGIN_PAGE);
        loginPage
                .clickSignInWithSSO();
        logInWithSSOPage
                .enterSSOEmail(EMAIL_SSO)
                .clickSignInButton()
                .checkInfo(TITLE_TEXT, visible);

    }

}
