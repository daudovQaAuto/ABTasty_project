package pages.loginPage;

import com.codeborne.selenide.*;
import pages.base.BasePage;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {
    private final SelenideElement inputEmail = $x("//input[@id='email']");
    private final SelenideElement inputPassword = $x("//input[@id='password']");
    public final SelenideElement buttonEye = $x("(//*[name()='svg'])[2]");
    public final SelenideElement linkForgotYourPassword = $x("//a[contains(text(),'Forgot')]");
    private final SelenideElement buttonSignIn = $x("//div[@class='FormButtonRow__buttonRow___vri7h']/button");
    private final SelenideElement buttonSSOSignIn = $x("//button[@type='button']");
    public final SelenideElement checkBoxRecaptcha = $x("//div[@class='recaptcha-checkbox-checkmark']");
    public final SelenideElement invitationToUseSSOLogin = $x("HERE'S THE XPATH OF THE LINK");
    private final SelenideElement buttonGoogleLogIn = $x("//div[@id='container']");

    /**
     * Enter an email
     * @param email is for email
     */
    public LoginPage enterEmail(String email) {
        clearAndType(inputEmail, email);
        return this;
    }

    /**
     * Enter a password
     * @param password is for password
     */
    public LoginPage enterPassword(String password) {
        clearAndType(inputPassword, password);
        return this;
    }

    /**
     * Click Sign in button
     */
    public LoginPage clickSignInButton() {
        buttonSignIn.shouldBe(visible).click();
        return this;
    }

    /**
     * Click Eye/strikethrough button
     */
    public LoginPage clickEyeButton() {
        buttonEye.shouldBe(visible).click();
        return this;
    }

    /**
     * Click "Forgot your password?" link
     */
    public LoginPage clickForgotYourPasswordLink() {
        linkForgotYourPassword.shouldBe(visible).click();
        return this;
    }

    /**
     * Check if password is visible
     */
    public LoginPage checkDisplayPassword() {
        inputPassword.shouldHave(attribute("type", "text"));
        return this;
    }

    /**
     * Verify that the sign-in button can be(visible,enabled etc.)
     * @param condition for expected condition
     */
    public LoginPage checkSignInButton(Condition condition) {
        buttonSignIn.shouldBe(condition);
        return this;
    }

    /**
     * Click Sign in with Google Account
     */
    public LoginPage signInWithGoogleAccount() {
        buttonGoogleLogIn.shouldBe(visible).click();
        return this;
    }

    /**
     * Checking the display of invitation to use the SSO link
     */
    public LoginPage checkSSOLinkInvitation() {
        invitationToUseSSOLogin.shouldBe(visible);
        return this;
    }

    /**
     * Click Sign in with SSO account
     */
    public LoginPage clickSignInWithSSO() {
        buttonSSOSignIn.shouldBe(visible).click();
        return this;
    }

    /**
     * Check the visibility of recaptcha after 3 invalid inputs
     */
    public LoginPage clickCheckBoxRecaptcha() {
        if (checkBoxRecaptcha.exists() && checkBoxRecaptcha.isDisplayed()) {
            checkBoxRecaptcha.click();
        }
        return this;
    }
}