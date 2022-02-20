package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import java.awt.*;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    // components
    private CalendarComponent calendarComponent = new CalendarComponent();


    // locators
    private SelenideElement
            headerTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderMale = $("#gender-radio-1"),
            phoneNumberInput = $("#userNumber"),
            dateOfBirth = $("#dateOfBirthInput"),
            languageInput = $("#subjectsInput"),
            hobbie = $("#hobbies-checkbox-2"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            stateCity = $("#city"),
            submit = $("#submit"),
            uploadFile = $("#uploadPicture"),
            resultsTable = $(".table-responsive");

    // actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setUserEmail (String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public RegistrationPage setGenderMale(){
        genderMale.parent().click();
        return this;
    }

    public RegistrationPage setPhoneNumber (String phoneNumber) {
        phoneNumberInput.setValue(phoneNumber);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirth.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setLanguage (String language) {
        languageInput.setValue(language).pressEnter();
        return this;
    }

    public RegistrationPage setHobbie(){
        hobbie.parent().click();
        return this;
    }

    public RegistrationPage setCurrentAddress (String address) {
        currentAddress.setValue(address);
        return this;
    }

    public RegistrationPage selectStateNCR (){
        state.scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        return this;
    }

    public RegistrationPage selectCityNoida (){
        stateCity.click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        return this;
    }

    public RegistrationPage clickSubmit (){
        submit.click();
        return this;
    }

    public RegistrationPage uploadFile (File file){
        uploadFile.uploadFile(file);
        return this;
    }

    public RegistrationPage checkForm(String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }
}
