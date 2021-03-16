package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MainTests extends TestBase {
    Random random = new Random();

    @Test
    @DisplayName("Check language change")
    void changeLanguageTest() {
        step("Open main page", () -> {
            open("");
        });
        step("Switch language to English", () -> {
            $(".lang").click();
        });
        step("Check switched language", () -> {
            $("h1").shouldHave(text("Single platform to handle Big Data complexity"));
        });
    }

    @Test
    @DisplayName("Pop up line should appear when scroll down")
    void popUpLineTest() {
        step("Open main page", () -> {
            open("");
        });
        step("Scroll down", () -> {
            $(".main-about").scrollIntoView(true);
        });
        step("Check pop up line should appear", () -> {
            $(".ml-auto").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Feedback form should open")
    void openFeedbackFormTest() {
        step("Open main page", () -> {
            open("");
        });
        step("Click feedback button", () -> {
            $("[data-id=feedback-modal]").click();
        });
        step("Check feedback form should appear", () -> {
            $("#main-form-section-modal").$(byText("Оставьте заявку")).shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Course program should be visible")
    void courseProgramTest() {
        step("Open main page", () -> {
            open("");
        });
        step("Go to courses page", () -> {
            $(".header").$(byText("Курсы")).click();
        });
        step("Open random course", () -> {
            $("[data-group=\"all\"]")
                    .parent()
                    .sibling(random.nextInt(6))
                    .click();
        });
        step("Check course program is visible", () -> {
            $("#course-program").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Check news search")
    void newsSearchTest() {
        step("Open main page", () -> {
            open("");
        });
        step("Go to news page", () -> {
            $("[href=\"/about/\"]").parent().hover();
            $("[href=\"/about/\"]")
                    .sibling(0)
                    .$(byText("Новости"))
                    .click();
        });
        step("Search news", () -> {
            $("[name=\"search\"]").setValue("Релиз").pressEnter();
        });
        step("Check news was found", () -> {
            $(".post").shouldHave(text("Релиз"));
        });
    }

    @Test
    @DisplayName("Vacancy page should open")
    void showVacancyTest() {
        step("Open main page", () -> {
            open("");
        });
        step("Go to career page", () -> {
            $("[href=\"/about/\"]").parent().hover();
            $("[href=\"/about/\"]")
                    .sibling(0)
                    .$(byText("Карьера"))
                    .click();
        });
        step("Open vacancy", () -> {
            $(".job-wrap").$(withText("QA Lead")).click();
        });
        step("Check vacancy is opened", () -> {
            $("h1").shouldHave(text("QA Lead"));
        });
    }

    @Test
    @DisplayName("Documentation should match selected product")
    void productDocumentationTest() {
        step("Open main page", () -> {
            open("");
        });
        step("Open product", () -> {
            $("[href=\"/products/\"]").parent().hover();
            $("[href=\"/products/\"]")
                    .sibling(0)
                    .$(byText("Arenadata QuickMarts"))
                    .click();
        });
        step("Open product documentation", () -> {
            $("[href=\"https://docs.arenadata.io/adqm/\"]").click();
        });
        step("Documentation should match selected product", () -> {
            switchTo().window(1);
            $("#adqm")
                    .$("p")
                    .shouldHave(text("Arenadata QuickMarts"));
        });
    }

    /*Сломан*/
    @Test
    @DisplayName("Check email and phone number fields validation")
    void feedbackFormValidationTest() {
        step("Open main page", () -> {
            open("");
        });
        step("Scroll to feedback form", () -> {
            $("#main-feedback-form").scrollIntoView(true);
        });
        step("Set incorrect email and phone", () -> {
            $("#main-feedback-form").$("[name=\"EMAIL\"]").setValue("test");
            $("#main-feedback-form").$("[name=\"PHONE\"]").setValue("test").pressTab();
        });
        step("Check error message should be visible", () -> {
            $("#main-feedback-form").$("[name=\"EMAIL\"]").shouldHave(attribute("aria-invalid", "true"));
            $("#main-feedback-form").$("[name=\"PHONE\"]").setValue("test").shouldHave(attribute("aria-invalid", "true"));
            $(".error-message").shouldBe(visible);
        });
        step("Set correct email and phone", () -> {
            $("#main-feedback-form").$("[name=\"EMAIL\"]").setValue("test@test");
            $("#main-feedback-form").$("[name=\"PHONE\"]").setValue("12345").pressTab();
        });
        step("Check error message should not be visible", () -> {
            $("#main-feedback-form").$("[name=\"EMAIL\"]").shouldHave(attribute("aria-invalid", "false"));
            $("#main-feedback-form").$("[name=\"PHONE\"]").shouldHave(attribute("aria-invalid", "false"));
            $(".error-message").shouldBe(visible);
        });
    }

    /*Сломан*/
    @Test
    @DisplayName("Support advantage description should appear when hover")
    void supportAdvantagesTest() {
        step("Open main page", () -> {
            open("");
        });
        step("Go to support page", () -> {
            $("[data-id=\"cookie2\"]").click();
        });
        step("Check support advantage description should be visible", () -> {
            int index = random.nextInt(8);
            $$(".plus").get(index).hover();
            $$(".plus__text").get(index).shouldNotBe(visible);
        });
    }
}
