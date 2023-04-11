package pages.base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BasePage {

    /**
     * Navigate to a specific URL
     */
    public void goToURL(String URL) {
        open(URL);
    }

    /**
     * Clean the element of the text and enters the desired text
     * @param element Selenide Element
     * @param value text
     */
    protected void clearAndType(SelenideElement element, String value) {
        while (!element.getAttribute("value").equals(""))
            element.sendKeys(Keys.BACK_SPACE);
            element.setValue(value);
    }

    /**
     * @param message (for example you can write here the title from the home page after registration)
     */
    public void checkInfo(String message, Condition condition) {
        $(byText(message)).shouldBe(condition);
    }
}
