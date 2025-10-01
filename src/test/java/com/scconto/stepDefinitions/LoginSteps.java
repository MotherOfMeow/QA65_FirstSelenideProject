package com.scconto.stepDefinitions;

import com.codeborne.selenide.Selenide;
import com.sconto.pages.HomePage;
import com.sconto.pages.LoginPage;
import com.sconto.utils.PropertiesLoader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class LoginSteps {
    HomePage home;
    LoginPage login;
    String name;
    String validEmail;
    String invalidEmail;
    String password;
    String errorText;

    @And("User enter valid data")
    public void enter_valid_data() throws IOException {
        validEmail = PropertiesLoader.loadProperty("valid.email");
        password = PropertiesLoader.loadProperty("valid.password");

        login = Selenide.page(LoginPage.class);
        login.enterData(validEmail, password);
    }

    @And("User clicks on Anmelden button")
    public void click_on_anmelden_button() {
        login.clickOnAnmeldem();
    }

    @And("User click on User icon")
    public void click_on_user_icon() {
        home = Selenide.page(HomePage.class);
        home.clickOnStatusIcon();
    }

    @Then("User verifies his name")
    public void verify_user_name() throws IOException {
        name = PropertiesLoader.loadProperty("user.name");
        login.verifyName(name);
    }

    @And("User enter invalid data")
    public void enter_invalid_data() throws IOException {
        invalidEmail = PropertiesLoader.loadProperty("invalid.email");

        login = Selenide.page(LoginPage.class);
        login.enterData(invalidEmail, password);
    }

    @Then("User verifies incorrect email prompt")
    public void verify_incorrect_email_prompt() throws IOException {
        errorText = PropertiesLoader.loadProperty("error.text");

        login = Selenide.page(LoginPage.class);
        login.verifyIncorrectPrompt(errorText);
    }
}
