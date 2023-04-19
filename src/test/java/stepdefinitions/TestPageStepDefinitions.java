package stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Text;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.TestPage;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class TestPageStepDefinitions {
    TestPage testPage = new TestPage();

    @Given("I enter username")
    public void i_enter_username() {
        testPage.username.setValue("techproed");
    }

    @Given("I enter password")
    public void i_enter_password() {
        testPage.password.setValue("SuperSecretPassword");
    }

    @Given("I enter submit button")
    public void i_enter_submit_button() {
        testPage.submitButton.click();
    }

    @Given("I click on logout link")
    public void i_click_on_logout_link() {

        testPage.logOutLink.click();
    }

    @Then("I hold the browser opento {string}")
    public void i_hold_the_browser_opento(String string) {

    }

    //Checkbox_Radio

    @Given("I click on {string} if not already selected")
    public void i_click_on_if_not_already_selected(String string) {
        switch (string) {
            case "Checkbox 1":
                if (!testPage.checkbox1.isSelected()) {
                    testPage.checkbox1.click();
                    testPage.checkbox1.shouldBe(Condition.checked);
                }
                break;
            case "Checkbox 2":
                if (!testPage.checkbox2.isSelected()) {
                    testPage.checkbox2.click();
                    testPage.checkbox2.shouldBe(Condition.checked);
                }
                break;
            case "Red":
                if (!testPage.red.isSelected()) {
                    testPage.red.click();
                    testPage.red.shouldBe(Condition.checked);
                }
                break;
            case "Yellow":
                if (!testPage.yellow.isSelected()) {
                    testPage.yellow.click();
                    testPage.yellow.shouldBe(Condition.checked);
                }
                break;
            case "Football":
                if (!testPage.football.isSelected()) {
                    testPage.football.click();
                    testPage.football.shouldBe(Condition.checked);
                }
                break;
            default:
                System.out.println("Gecersiz secenek");
                break;
        }
    }

    //  DROPDOWN

    @Given("I select the year as {int}")
    public void i_select_the_year_as(Integer int1) {
        testPage.year.selectOptionByValue(String.valueOf(int1)); //selecting by value

    }

    @Given("I select the months as {string}")
    public void i_select_the_months_as(String string) {
        testPage.month.selectOption(string); //selecting by visible text
    }

    @Given("I select the day as {int}")
    public void i_select_the_day_as(Integer int1) {
        testPage.day.selectOption(int1 - 1); // index starts at 0
    }

    @Given("I get the list of US states and click on {string}")
    public void i_get_the_list_of_us_states_and_click_on(String string) {
        for (SelenideElement myState : testPage.allState
        ) {
            if (myState.getText().equals(string)) {
                myState.click();
                break;
            }
        }
    }

//    ALERTS

    @Given("I click on alert prompt")
    public void i_click_on_alert_prompt() {
        testPage.jsPromptButton.click();
    }

    @Given("I enter {string} and click OK")
    public void i_enter_and_click_ok(String string) {
        switchTo().alert().sendKeys(string);
        switchTo().alert().accept();

    }

    @Then("I verify the result contains {string}")
    public void i_verify_the_result_contains(String string) {
        testPage.result.shouldHave(Condition.text(string));
    }

    //  iframe
    @Given("I verify the page header contains {string}")
    public void i_verify_the_page_header_contains(String string) {
        testPage.pageHader.shouldHave(Condition.text(string));
    }

    @Given("I switch to the frame {int}")
    public void i_switch_to_the_frame(Integer int1) {
        switchTo().frame(int1 - 1);
    }

    @Given("I click on Back to TechProEducation.com")
    public void i_click_on_back_to_tech_pro_education_com() {
        testPage.backToTechpro.click();
    }

    // switching window
    @When("I switch to window {int}")
    public void i_switch_to_window(Integer int1) {
        switchTo().window(int1 - 1);
    }

    @Then("I get the URL of the page and verify it contains {string}")
    public void i_get_the_url_of_the_page_and_verify_it_contains(String string) {
        System.out.println("url: " + url());
        Assert.assertTrue(url().contains(string));
    }

    // ACTIONS

    @When("I drag the source in the target")
    public void i_drag_the_source_in_the_target() {
        // actions().dragAndDrop(testPage.source, testPage.target).build().perform();
        //OR
//        actions()
//                .clickAndHold(testPage.source)
//                .moveToElement(testPage.target)
//                .build()
//                .perform();
        //OR
        actions().dragAndDropBy(testPage.source, 154, 44).build().perform();

    }

    @Given("I scroll the page down")
    public void i_scroll_the_page_down() {
        actions().sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.ARROW_UP).build().perform();
    }
// EXPILICIT WAIT

    @Given("I click on start button")
    public void i_click_on_start_button() {
        testPage.startButton.click();

    }

    @Then("verify the Hello World! text is displayed")
    public void verify_the_hello_world_text_is_displayed() {
        // FAILS WITH NOT WAIT
        // HANDLE WITH WebDriverWait CLASS
//        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.visibilityOf(testPage.helloWorld));

        // SELENIDE WAIT
        testPage.helloWorld.should(visible, Duration.ofSeconds(20));

        //Assert.assertEquals("Hello World!", testPage.helloWorld.getText());
        testPage.helloWorld.shouldHave(Condition.text("Hello World!!"));
    }

    @Given("I try to upload the file on this path {string}")
    public void i_try_to_upload_the_file_on_this_path(String string) {
        //        Getting the file path
//                    USER DIRECTORY               + FILE PATH = FULL PATH
        String path = System.getProperty("user.home") + string;
        System.out.println(path);
        File fullPath = new File(path);
//        Selecting the file
        $(By.id("file-upload")).uploadFile(fullPath);
//        click upload button
        $(By.id("file-submit")).click();
    }

    @Then("I verify the file is uploaded")
    public void i_verify_the_file_is_uploaded() {
        $(By.xpath("//h3")).shouldHave(Condition.text("File Uploaded!"));
    }

    @And("I scroll down to footer section")
    public void iScrollDownToFooterSection() {
        executeJavaScript("arguments[0].scrollIntoView(true);", testPage.amazonFooter);
    }

    @And("I click on {string} by js on amazon table")
    public void iClickOnByJsOnAmazonTable(String string) {
        // $(By.xpath("//table[@class='navFooterMoreOnAmazon']//*[contains(text(),'Amazon Music')]"));
        SelenideElement element = $(By.xpath("//table[@class='navFooterMoreOnAmazon']//*[contains(text(),'" + string + "')]"));
        executeJavaScript("arguments[0].click();", element);
    }
}
