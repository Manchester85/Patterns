package ru.netology.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.BACK_SPACE;
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
        $("[data-test-id=date] [placeholder='Дата встречи']").doubleClick().sendKeys(BACK_SPACE);
        $("[data-test-id=date] [placeholder='Дата встречи']").setValue(when(false));
        $("[data-test-id=name] [name=name]").setValue(Data.getName());
        $("[data-test-id=phone] .input__control").setValue(Data.getPhone("ru"));
        $("[data-test-id=agreement]>.checkbox__box").click();
        $(".grid-col .button__text").click();
        $(".notification__content").shouldBe(visible, Duration.ofSeconds(15)).shouldHave(text("Встреча успешно забронирована на " + when(false)));
        $("[data-test-id=date] [placeholder='Дата встречи']").doubleClick().sendKeys(BACK_SPACE);
        $("[data-test-id=date] [placeholder='Дата встречи']").setValue(when(true));
        $(".grid-col .button__text").click();
        $(".notification__content").shouldBe(visible, Duration.ofSeconds(15)).shouldHave(text( "Встреча успешно забронирована на " + when(true)));
    }
}


