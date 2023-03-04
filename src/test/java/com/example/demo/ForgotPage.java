package com.example.demo;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.element;

public class ForgotPage {

    public SelenideElement submitButton = element("input[id='forgot']");

    public SelenideElement signInButton = element("div[class='panel-footer'] a");

    public SelenideElement emailInputField = element("input[id='email']");

    public SelenideElement emailErrorInvalid = element("small[data-bv-result='INVALID']");
    public SelenideElement emailErrorEmpty = element("small[data-bv-result='VALID']");
}
