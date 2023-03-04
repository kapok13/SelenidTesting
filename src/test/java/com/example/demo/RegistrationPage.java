package com.example.demo;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.element;

public class RegistrationPage {

    public SelenideElement registrationButton = element("input[id='register']");

    public SelenideElement passwordInputField = element("input[id='password']");

    public SelenideElement passwordConfirmInputField = element("input[id='confirm']");

    public SelenideElement passwordError = element("html > body > main > div:nth-of-type(2) > div > div:nth-of-type(2) > form > div:nth-of-type(3) > small:nth-of-type(1)");

    public SelenideElement passwordConfirmError
            = element(
                    "html > body > main > div:nth-of-type(2) > div > div:nth-of-type(2) > form > div:nth-of-type(4) > small:nth-of-type(1)"
    );

    public SelenideElement emailInputField = element("input[id='email']");

    public SelenideElement emailError = element("small[data-bv-result='INVALID']");

    public SelenideElement usernameInputField = element("input[id='username']");

    public SelenideElement usernameError = element("small[data-bv-for='username']");

    public SelenideElement signInButton = element("div[class='panel-footer'] a");

}
