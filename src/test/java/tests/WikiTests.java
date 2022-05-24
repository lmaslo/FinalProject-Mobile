package tests;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

@Tag("selenide")
public class WikiTests extends TestBase {
    @Test
    void searchTest3() {
        //Онбординг первый шаг

        $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        $(MobileBy.id("org.wikipedia.alpha:id/secondaryTextView")).shouldHave(text("We’ve found the following on your device:"));

        //второй шаг онбординга
        $(MobileBy.xpath("//android.widget.LinearLayout/android.widget.LinearLayout[2]")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("New ways to explore"));
        $(MobileBy.id("org.wikipedia.alpha:id/secondaryTextView")).shouldHave(text("Dive down the Wikipedia rabbit hole with " +
                "a constantly updating Explore feed. Customize the feed to your interests – whether it’s learning about historical " +
                "events On this day, or rolling the dice with Random."));


        //третий шаг онбординга
        $(MobileBy.xpath("//android.widget.LinearLayout/android.widget.LinearLayout[3]")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Reading lists with sync"));
        $(MobileBy.id("org.wikipedia.alpha:id/secondaryTextView")).shouldHave(text("You can make reading lists from " +
                "articles you want to read later, even when you’re offline. Login to your Wikipedia account to sync your " +
                "reading lists. Join Wikipedia"));


        //четвертый
        $(MobileBy.xpath("//android.widget.LinearLayout/android.widget.LinearLayout[4]")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Send anonymous data"));
        $(MobileBy.id("org.wikipedia.alpha:id/secondaryTextView")).shouldHave(text("Help make the app better" +
                " by letting us know how you use it. Data collected is anonymous. Learn more"));


    }


    @Test
    void searchTest() {

        step("Skip information", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
        });

        step("Input text \"BrowserStack\" and Search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("BrowserStack");
        });

        step("Check results", () -> {
            $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(0));
        });

    }
}
