package pages.loginPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.base.BasePage;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {

    private final SelenideElement inputEmail = $x("//input[@id='email']");
    private final SelenideElement inputPassword = $x("//input[@id='password']");
    public final SelenideElement buttonEye = $x("(//*[name()='svg'])[2]");
    public final SelenideElement linkForgotYourPassword = $x("//a[contains(text(),'Forgot')]");
    private final SelenideElement buttonSignIn = $x("//div[@class='FormButtonRow__buttonRow___vri7h']/button");
    private final SelenideElement buttonGoogleLogIn = $x("//div[@id='container']");
    private final SelenideElement buttonSSOSignIn = $x("//button[@type='button']");
    public final SelenideElement checkBoxRecaptcha = $x("//div[@class='recaptcha-checkbox-checkmark']");
    public final SelenideElement invitationToUseSSOLogin = $x("HERE'S THE XPATH OF THE LINK");


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
        buttonSignIn.shouldBe(Condition.visible).click();
        return this;
    }

    /**
     * Click Sign in button
     */
    public LoginPage clickEyeButton() {
        buttonEye.shouldBe(Condition.visible).click();
        return this;
    }

    public LoginPage checkDisplayPassword() {
        inputPassword.shouldHave(attribute("type", "text"));
        return this;
    }


    public LoginPage checkSignInButton(Condition condition) {
        buttonSignIn.shouldBe(condition);
        return this;
    }

    /**
     * Click Sign in with Google Account
     */
    public LoginPage signInWithGoogleAccount() {
        buttonGoogleLogIn.shouldBe(Condition.visible).click();
        return this;
    }

    /**
     * Checking the display of invitation to use the SSO link below
     */
    public LoginPage checkSSOLinkInvitation() {
        invitationToUseSSOLogin.shouldBe(Condition.visible);
        return this;
    }

    /**
     * Click Sign in with SSO
     */
    public LoginPage clickSignInWithSSO() {
        buttonSSOSignIn.shouldBe(Condition.visible).click();
        return this;
    }

    /**
     * Check the visibility of recaptcha after 3 invalid inputs
     */
    public LoginPage clickCheckBox(String email, String password) {
        int counter = 0;

        enterEmail(email);
        //сюда нужно передать параметризированные данные
        enterPassword(password);
        clickSignInButton();

        while (counter < 3) {
            if (checkBoxRecaptcha.exists()) {
                checkBoxRecaptcha.click();
                break;
            } else {
                counter++;
                clickSignInButton();
            }
        }
        return this;
    }

    public boolean checkCheckBoxDisplay(){
        return checkBoxRecaptcha.exists() && checkBoxRecaptcha.isDisplayed();
    }


}