package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SauceDemoPage {
    public SelenideElement loginLogo = $(By.className("login_logo"));
    public SelenideElement username = $(By.id("user-name"));
    public SelenideElement password = $(By.id("password"));

    public SelenideElement loginButton = $(By.id("login-button"));
    public SelenideElement appLogo = $(By.className("app_logo"));
}
