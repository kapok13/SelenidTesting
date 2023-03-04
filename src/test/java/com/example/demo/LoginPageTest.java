package com.example.demo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class LoginPageTest {
    LoginPage mainPage = new LoginPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://localhost:8080/");
    }

    @Test
    public void loginWithEmptyUsernameAndPassword() {
        assertFalse(element("small[data-bv-for='username']").isDisplayed());
        assertFalse(element("small[data-bv-for='password']").isDisplayed());
        mainPage.loginButton.click();
        assertTrue(element("small[data-bv-for='username']").isDisplayed());
        assertTrue(element("small[data-bv-for='password']").isDisplayed());
    }

    @Test
    //TODO
    public void login() {
        mainPage.passwordInputField.setValue("Qwe!23");
        mainPage.usernameInputField.setValue("123@gmail.com");
        mainPage.loginButton.click();
        assertNotEquals(webdriver().driver().getCurrentFrameUrl(), "http://localhost:8080/profile");
    }

    @Test
    public void signUpClick() {
        mainPage.signUpButton.click();
        assertEquals(webdriver().driver().getCurrentFrameUrl(), "http://localhost:8080/register");
    }

    @Test
    public void forgotPasswordClick() {
        mainPage.forgotPasswordButton.click();
        assertEquals(webdriver().driver().getCurrentFrameUrl(), "http://localhost:8080/forgot");
    }
    @Test
    public void privacyPolicyClick() {
        mainPage.passwordInputField.setValue("Qwe!23");
        mainPage.usernameInputField.setValue("xyz@xyz.com");
        mainPage.loginButton.click();
    }
}
