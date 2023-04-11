package pages.loginSSOPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.base.BasePage;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static constants.Constants.TestDataForLogInWithSSO.SSO_TITLE;

public class LoginSSOPage extends BasePage {

    private final SelenideElement title = $("title");
    private final SelenideElement inputSSOEmail = $x("//input[@type='email']");
    private final SelenideElement buttonSignIn = $x("//button[contains(text(),'Sign in')]");
    private final SelenideElement buttonArrowBack = $x("//a[contains(text(), 'Lear')]/preceding-sibling::*");

    /**
     * Enter an email
     * @param email is for SSO email
     */
    public LoginSSOPage enterSSOEmail(String email) {
        clearAndType(inputSSOEmail, email);
        return this;
    }

    /**
     * Click sign-in button on SSO page
     */
    public LoginSSOPage clickSignInButton() {
        buttonSignIn.shouldBe(Condition.visible).click();
        return this;
    }

    /**
     * Verify if we navigated to home page as SSO user
     */
    public LoginSSOPage checkLoginWithSSOTitle (){
        title.shouldHave(text(SSO_TITLE));
        return this;
    }

    /**
     * Click on the arrow button
     */
    public LoginSSOPage clickArrowBackButtonSSO (){
        buttonArrowBack.shouldBe(visible).click();
        return this;
    }
}
