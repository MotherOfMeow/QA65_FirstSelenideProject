package com.scconto.stepDefinitions;

import com.codeborne.selenide.Selenide;
import com.sconto.pages.HomePage;
import com.sconto.pages.LoginPage;
import com.sconto.utils.PropertiesLoader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class HomePageSteps {
    HomePage home;
    LoginPage login;
    String url;

    @Given("User is on Home Page")
    public void is_on_HomePage() throws IOException  {
        url = PropertiesLoader.loadProperty("url");

        home = open(url, HomePage.class);
        getWebDriver().manage().window().maximize();
        home.acceptCookies();

    }

    @When("User click on Login icon")
    public void click_on_login_icon() {
        home.clickOnLoginIcon();
    }

    @Then("User verifies Login form is displayed")
    public void verify_login_form() {
        login = Selenide.page(LoginPage.class);
        login.verifyLoginTitle();
    }
}
