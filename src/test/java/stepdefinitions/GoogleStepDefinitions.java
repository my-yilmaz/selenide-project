package stepdefinitions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.GooglePage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class GoogleStepDefinitions {
    GooglePage googlePage = new GooglePage();

    @Given("I navigate to {string}")
    public void i_navigate_to(String string) {
        open(string);
        sleep(5000);
    }

    @Given("I wait for {int} seconds")
    public void i_wait_for_seconds(Integer int1) {
        sleep(int1 * 1000);
    }

    @Given("I navigate back")
    public void i_navigate_back() {
        back();
    }

    @Given("I navigate forward")
    public void i_navigate_forward() {
        forward();
    }

    @Given("I refresh the page")
    public void i_refresh_the_page() {
        refresh();
    }

    @Then("I hold the browser open")
    public void i_hold_the_browser_open() {
        Configuration.holdBrowserOpen = true;
    }

    @When("I search for {string}")
    public void i_search_for(String string) {
        googlePage.googleSearchBox.setValue(string).pressEnter();
    }

    @Then("verify page source contains {string}")
    public void verify_page_source_contains(String string) {
        Assert.assertTrue(WebDriverRunner.source().contains(string));
    }

    @Then("verify the result should contain {string} keyword")
    public void verify_the_result_should_contain_keyword(String string) {
        //  Assert.assertTrue(googlePage.resultSection.toString().contains(string));
        googlePage.resultSection.shouldHave(text(string));
        googlePage.resultSection.shouldNotHave(text("MERCEDES"));
        googlePage.resultSection.shouldBe(visible);
        //googlePage.resultSection.shouldHave(exactText("Yaklaşık 672.000.000 sonuç bulundu"));


    }

    @Then("the first result in the page sections should contain {string}")
    public void the_first_result_in_the_page_sections_should_contain(String string) {
        googlePage.getAllSections.get(0).shouldHave(text(string));
    }

}
