package com.example.demo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class RegistrationPageTest {

    RegistrationPage mainPage = new RegistrationPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://localhost:8080/register");
    }

    @Test
    public void registration() {
        mainPage.registrationButton.click();
        assertTrue(mainPage.usernameError.isDisplayed());
        assertTrue(mainPage.emailError.isDisplayed());
        assertTrue(mainPage.passwordError.isDisplayed());
        assertTrue(mainPage.passwordConfirmError.isDisplayed());

        mainPage.usernameInputField.setValue("JohnyKroro");
        assertFalse(mainPage.usernameError.isDisplayed());

        mainPage.emailInputField.setValue("sdeffd");

        mainPage.emailError.shouldHave(Condition.exactText("The email address is not valid"));

        mainPage.emailInputField.setValue("sdef@gmail.com");

        mainPage.passwordInputField.setValue("Qwe!23");
        assertFalse(mainPage.passwordError.isDisplayed());

        assertFalse(mainPage.registrationButton.isEnabled());

        mainPage.passwordConfirmInputField.setValue("Qwe!23");
        assertFalse(mainPage.passwordConfirmError.isDisplayed());

        assertTrue(mainPage.registrationButton.isEnabled());
    }

    @Test
    public void signUpClick() {
        mainPage.signInButton.click();
        assertEquals(webdriver().driver().getCurrentFrameUrl(), "http://localhost:8080/login");
    }
}
