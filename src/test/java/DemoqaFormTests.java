import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaFormTests {
    File file = new File("src/test/resources/test-image.jpeg");
    static Logger logger = LoggerFactory.getLogger(DemoqaFormTests.class);
    @BeforeAll
    static void config() {
        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
    }

    @Test
    void selenideAutomationPracticeFormTest() {
        logger.info("Start test");
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Stepan");
        $("#lastName").setValue("Boyko");
        $("#userEmail").setValue("test@gmail.com");
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue("9171111111");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1989");
        $("[aria-label='Choose Friday, April 28th, 1989']").click();
        $("#subjectsInput").setValue("Eng").pressEnter();
        $("#hobbies-checkbox-2").parent().click();
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue("Some address");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Del").pressEnter();
        $("#submit").click();


        $(".table-responsive").shouldHave(text("Stepan Boyko"), text("test@gmail.com"),
                text("Male"), text("9171111111"), text("28 April,1989"), text("English"),
                text("Reading"), text("test-image.jpeg"), text("Some address"),
                text("NCR Delhi"));


    }
}
