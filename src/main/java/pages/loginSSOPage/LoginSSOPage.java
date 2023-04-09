package pages.loginSSOPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.base.BasePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static constants.Constants.TestDataForLogInWithSSO.SSO_TITLE;

public class LoginSSOPage extends BasePage {

    private final SelenideElement title = $("title");
    private final SelenideElement inputSSOEmail = $x("//input[@type='email']");
    private final SelenideElement buttonSignIn = $x("//button[contains(text(),'Sign in')]");


    /**
     * Enter an email
     * @param email is for SSO email
     */
    public LoginSSOPage enterSSOEmail(String email) {
        clearAndType(inputSSOEmail, email);
        return this;
    }

    public LoginSSOPage clickSignInButton() {
        buttonSignIn.shouldBe(Condition.visible).click();
        return this;
    }

    public LoginSSOPage checkLoginWithSSOTitle (){
        title.shouldHave(text(SSO_TITLE));
        return this;
    }


    /*public MainLoginPage enterEmailSSO(String emailSSO) {
        clearAndType(inputEmail, emailSSO);
        return this;
    }
    /
     */
}
