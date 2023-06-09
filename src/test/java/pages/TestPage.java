package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class TestPage {

//    public SelenideElement username(){
//        return $(By.id("exampleInputEmail1"));
//    }

    public SelenideElement username = $(By.id("exampleInputEmail1"));
    public SelenideElement password = $("#exampleInputPassword1");
    public SelenideElement submitButton = $(By.xpath("//button[@type='submit']"));
    public SelenideElement logOutLink = $(By.partialLinkText("Logout"));

    // LOCATING CHECKBOXES
    public SelenideElement checkbox1 = $(By.id("box1"));
    public SelenideElement checkbox2 = $(By.id("box2"));

    // LOCATING RADIOS

    public SelenideElement red = $(By.id("red"));
    public SelenideElement yellow = $(By.id("yellow"));
    public SelenideElement football = $(By.id("football"));

    // LOCATING DROPDOWN

    public SelenideElement year = $(By.id("year"));
    public SelenideElement month = $(By.id("month"));
    public SelenideElement day = $(By.id("day"));
    public ElementsCollection allState = $$(By.xpath("//select[@id='state']//option"));

    // LOCATING ALERT ELEMENTS
    public SelenideElement jsPromptButton = $(By.xpath("//button[@onclick='jsPrompt()']"));
    public SelenideElement result = $(By.id("result"));

    //    FRAMES
    public SelenideElement pageHader = $(By.xpath("//h3"));

    public SelenideElement backToTechpro = $(By.xpath("//a[@type='button']"));

    // ACTIONS
    public SelenideElement source = $(By.id("draggable"));
    public SelenideElement target = $(By.id("droppable"));
    public SelenideElement droppedText = $(By.xpath("//p[text()=\"Dropped!\"]"));

    // EXPILICIT WAIT
    public SelenideElement startButton = $(By.xpath("//div[@id='start']//button"));
    public SelenideElement helloWorld = $(By.xpath("//div[@id='finish']//h4"));

    // SCREENSHOT
    public SelenideElement upcomingPrograms = $(By.id("MjI4NDoxMDk1-1"));

    // JS EXECUTOR

    public SelenideElement amazonFooter = $(By.xpath("//table[@class='navFooterMoreOnAmazon']"));


}
