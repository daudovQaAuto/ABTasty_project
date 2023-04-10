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

   public ResetPasswordPage enterEmail(String email){
       clearAndType(inputEmail, email);
       return this;
   }

    public ResetPasswordPage clickPasswordResetLinkButton (){
       buttonSendMeThePasswordResetLink.shouldBe(visible).click();
       return this;
    }

    public ResetPasswordPage checkDisplayOfResetConfirmationMessage (){
        passwordResetConfirmationMessage.shouldBe(visible);
       return this;
    }

    public ResetPasswordPage clickArrowBackButtonPasswordResetPage (){
        buttonArrowBack.shouldBe(visible).click();
        return this;
    }

}
