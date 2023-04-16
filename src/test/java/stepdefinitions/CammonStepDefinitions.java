package stepdefinitions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.util.Date;

import static com.codeborne.selenide.Selenide.screenshot;

public class CammonStepDefinitions {
    @Given("I set Configuration.screenshot to false")
    public void i_set_configuration_screenshot_to_false() {
        Configuration.screenshots = false;
    }

    @And("I capture the screenshot of the page")
    public void iCaptureTheScreenshotOfThePage() {
       // screenshot("my_screenshot");
       screenshot(new Date().toString());
        //SelenideElement.screenshot(new Date().toString());//giving a dynamic name
    }
}
