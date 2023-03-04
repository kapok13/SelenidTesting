package com.example.demo;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    public SelenideElement loginButton = element("input[id='login']");

    public SelenideElement passwordInputField = element("input[id='password']");

    public SelenideElement usernameInputField = element("input[id='username']");

    public SelenideElement signUpButton = element("div[class='panel-footer'] a");

    public SelenideElement forgotPasswordButton = element("a[class='forgot-password']");

  }
