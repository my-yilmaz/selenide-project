package stepdefinitions;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.*;

public class CammonStepDefinitions {
    @Given("I set Configuration.screenshot to false")
    public void i_set_configuration_screenshot_to_false() {
        Configuration.screenshots = false;
    }

    @And("I capture the screenshot of the page")
    public void iCaptureTheScreenshotOfThePage() {
        String fileName = "homepage_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        screenshot(fileName);
        // screenshot("my_screenshot");
        //screenshot(new Date().toString());
        // SelenideElement.screenshot(new Date().toString());//giving a dynamic name
    }


    @Given("I open the {string} browser")
    public void iOpenTheBrowser(String browserType) {
        switch (browserType) {
            case "headless":
                Configuration.headless = true;
                break;
            case "firefox":
                Configuration.browser = "firefox";
                break;
            case "safari":
                Configuration.browser = "safari";
                break;
            case "edge":
                Configuration.browser = "edge";
                break;
            default:
                Configuration.browser = "chrome";
                break;
        }
    }
}
