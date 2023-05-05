package stepdefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import pages.SauceDemoPage;

public class SauceDemoStepDefinitions {

    SauceDemoPage sauceDemoPage = new SauceDemoPage();

    @Then("Verify login_logo")
    public void verify_login_logo() {
        sauceDemoPage.loginLogo.shouldHave(Condition.text("Swag Labs"));
    }

    @Then("Verify the username box are enabled")
    public void verify_the_username_box_are_enabled() {
        sauceDemoPage.username.shouldBe(Condition.enabled);
    }

    @Then("Verify the password box are enabled")
    public void verify_the_password_box_are_enabled() {
        sauceDemoPage.password.shouldBe(Condition.enabled);
    }

    @Then("I enter username {string}")
    public void i_enter_username(String string) {
        sauceDemoPage.username.setValue(string);
    }

    @Then("I enter password {string}")
    public void i_enter_password(String string) {
        sauceDemoPage.password.setValue(string);
    }

    @Then("I click on login button")
    public void i_click_on_login_button() {
        sauceDemoPage.loginButton.click();
    }

    @Then("Verify app_logo")
    public void verify_app_logo() {
        sauceDemoPage.appLogo.shouldHave(Condition.text("Swag Labs"));
    }
}
