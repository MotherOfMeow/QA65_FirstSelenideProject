package com.sconto.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    @FindBy(css = ".existingAccount__headline")
    WebElement loginTitle;

    public SelenideElement verifyLoginTitle() {
        return $(loginTitle).shouldHave(text("Anmelden"));
    }

    @FindBy(id = "loginEmail")
    WebElement emailField;

    @FindBy(id = "loginPassword")
    WebElement passwordField;

    public LoginPage enterData(String email, String password) {
        $(emailField).val(email);
        $(passwordField).val(password);

        return Selenide.page(this);
    }

    @FindBy(id = "login-submit")
    WebElement loginButton;

    public HomePage clickOnAnmeldem() {
        $(loginButton).click();

        return Selenide.page(HomePage.class);
    }

    @FindBy(css = ".titleHeadline")
    WebElement nameTitle;

    public SelenideElement verifyName(String name) {
        return $(nameTitle).shouldHave(text(name));
    }
}
