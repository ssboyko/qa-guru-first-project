package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPageWithPageObject {
    RegistrationPage registrationPage = new RegistrationPage();
    //String firstName = "Stepan";
    //String lastName = "Boyko";
    String userEmail = "test@gmail.com";
    String userPhoneNumber = "9171111111";
    String day = "28";
    String month = "April";
    String year = "1989";
    String language = "Eng";
    String address = "Some address 1";
    File file = new File("src/test/resources/test-image.jpeg");

    Faker faker = new Faker();
    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),

    mobile = faker.phoneNumber().subscriberNumber(10),

    yearOfBirth = "2004",

    subject = "Chemistry",

    picture = "1.png",
            currentAddress = faker.address().fullAddress(),
            state = "Uttar Pradesh",
            city = "Merrut";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGenderMale()
                .setPhoneNumber(mobile)
                .setBirthDate(day, month, year)
                .setLanguage(language)
                .setHobbie()
                .setCurrentAddress(currentAddress)
                .selectStateNCR()
                .selectCityNoida()
                .uploadFile(file)
                .clickSubmit();
        registrationPage.checkForm("Student Name", firstName + " " + lastName)
                .checkForm("Student Email", email)
                .checkForm("Gender", "Male")
                .checkForm("Mobile", mobile);

    }
}
