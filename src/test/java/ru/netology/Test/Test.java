package ru.netology.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static ru.netology.Test.Data.when;

public class Test {
    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Should successful book and reschedule a meeting")
    void shouldSuccessfulBookAndRescheduleAMeeting() {
        $("[data-test-id=city] .input__control").setValue(Data.getCity());
        $("[data-test-id=date] [placeholder='Дата встречи']").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE, when(false));
        $("[data-test-id=name] [name=name]").setValue(Data.getName());
        $("[data-test-id=phone] input").setValue(Data.getPhone());
        $("[data-test-id=agreement]>.checkbox__box").click();
        $(".grid-col .button__text").click();
        $("div.notification__content").shouldBe(visible, exactText("Встреча успешно запланирована на " + Data.when(false)));
        $("[data-test-id=date] [placeholder='Дата встречи']").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE, when(true));
        $(".grid-col .button__text").click();
        $("[data-test-id='replan-notification'] .button__text").click();
        $("div.notification__content").shouldBe(visible, exactText("Встреча успешно запланирована на " + Data.when(true)));
    }
}


