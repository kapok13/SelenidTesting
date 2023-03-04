package com.example.demo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class ForgotPageTest {
    ForgotPage mainPage = new ForgotPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://localhost:8080/forgot");
    }

    @Test
    public void sendEmail() {
        mainPage.submitButton.click();
        assertTrue(mainPage.emailErrorInvalid.isDisplayed());
        assertFalse(mainPage.submitButton.isEnabled());

        mainPage.emailInputField.setValue("12");
        assertTrue(mainPage.emailErrorInvalid.isDisplayed());

        mainPage.emailInputField.setValue("123@gmail.com");
        assertTrue(mainPage.submitButton.isEnabled());
    }

    @Test
    public void signUpClick() {
        mainPage.signInButton.click();
        assertEquals(webdriver().driver().getCurrentFrameUrl(), "http://localhost:8080/login");
    }
}
