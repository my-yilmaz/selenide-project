package stepdefinitions;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class GoogleStepDefinitions {

    @Given("I navigate to {string}")
    public void ı_navigate_to(String string) {
        open(string);
        sleep(5000);
    }

    @Given("I wait for {int} seconds")
    public void ı_wait_for_seconds(Integer int1) {
        sleep(int1 * 1000);
    }

    @Given("I navigate back")
    public void ı_navigate_back() {
        back();
    }

    @Given("I navigate forward")
    public void ı_navigate_forward() {
        forward();
    }

    @Given("I refresh the page")
    public void ı_refresh_the_page() {
        refresh();
    }

    @Then("I hold the browser open")
    public void ı_hold_the_browser_open() {
        Configuration.holdBrowserOpen = true;
    }

}
