package pages.resetPasswordPage;

import com.codeborne.selenide.SelenideElement;
import pages.base.BasePage;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ResetPasswordPage extends BasePage {
    private final SelenideElement inputEmail = $x("//input[@name='email']");
    private final SelenideElement buttonSendMeThePasswordResetLink = $x("//button");
    private final SelenideElement passwordResetConfirmationMessage = $x("//*[contains(text(),'sent an email')]");
    private final SelenideElement buttonArrowBack = $x("//a[contains(text(), 'Return')]");

    /**
     * Enter email on reset password page
     */
    public ResetPasswordPage enterEmail(String email) {
        clearAndType(inputEmail, email);
        return this;
    }

    /**
     * Click on password reset link
     */
    public ResetPasswordPage clickPasswordResetLinkButton() {
        buttonSendMeThePasswordResetLink.shouldBe(visible).click();
        return this;
    }

    /**
     * Check if the reset confirmation message is displayed
     */
    public ResetPasswordPage checkDisplayOfResetConfirmationMessage() {
        passwordResetConfirmationMessage.shouldBe(visible);
        return this;
    }

    /**
     * Click on an arrow back button
     */
    public ResetPasswordPage clickArrowBackButtonPasswordResetPage() {
        buttonArrowBack.shouldBe(visible).click();
        return this;
    }
}
