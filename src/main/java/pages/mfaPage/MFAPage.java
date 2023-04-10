package pages.mfaPage;

import com.codeborne.selenide.SelenideElement;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pages.base.BasePage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static constants.Constants.TestDataForSigningIn.*;


public class MFAPage extends BasePage {

    private final SelenideElement inputSMSField = $x("HERE'S XPATH OF INPUT IN MFA FRAME");
    private final SelenideElement button_OK_For_SMS_Code = $x("HERE'S XPATH OF OK BUTTON IN MFA FRAME");
    private final SelenideElement checkBoxForTick = $x("HERE'S XPATH OF CHECKBOX FOR TICK IN MFA FRAME");
    private final SelenideElement buttonArrowBack = $x("HERE'S ARROW BACK BUTTON IN MFA FRAME");
    private final SelenideElement buttonRenvoyerLeCode = $x("HERE'S XPATH OF RESENDING NEW SMS CODE LINK IN MFA FRAME");


    /**
     * Getting MFA code from SMS and clicking OK button
     */
    public MFAPage setConfirmationCodeSms(String urlSms, String userEmail) {
        JsonPath jsonPath = RestAssured
                .when()
                .get(urlSms + userEmail)
                .then()
                .extract().jsonPath();
        inputSMSField.sendKeys(jsonPath.get("[0].otp").toString());
        return this;
    }

    /**
     * Getting MFA code from SMS and clicking OK button
     */
    public MFAPage setConfirmationInvalidCodeSms() {
        clearAndType(inputSMSField, INVALID_SMS_CODE);
        return this;
    }

    /**
     * Getting MFA code from SMS and clicking OK button
     */
    public MFAPage clickOkButton() {
        button_OK_For_SMS_Code.shouldBe(visible).click();
        return this;
    }

    /**
     * Getting MFA code from SMS and clicking OK button
     */
    public MFAPage clickOkButtonIfCheckBoxSelected() {
        if (checkBoxForTick.isSelected()) {
            button_OK_For_SMS_Code.shouldBe(visible).click();
        }
        return this;
    }


    /**
     * Getting MFA code from SMS and clicking OK button
     */
    public MFAPage clickCheckBoxForTick() {
        checkBoxForTick.shouldBe(enabled).click();
        return this;
    }

    /**
     * Getting MFA code from SMS and clicking OK button
     */
    public MFAPage clickArrowBackButton() {
        buttonArrowBack.shouldBe(enabled).click();
        return this;
    }

    /**
     * Getting MFA code from SMS and clicking OK button
     */
    public MFAPage clickRenvoyerLeCode() {
        buttonRenvoyerLeCode.shouldBe(enabled).click();
        return this;
    }
}
