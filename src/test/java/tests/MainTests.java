package tests;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class MainTests extends TestBase {
    @Test
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
                    .sibling(new Random().nextInt(6))
                    .click();
        });
        step("Check course program is visible", () -> {
            $("#course-program").shouldBe(visible);
        });
    }

    @Test
    void newsSearchTest() {
        step("Open main page", () -> {
            open("");
        });
        step("Go to news page", () -> {
            $(".nav__item-link").hover();
            $(".nav-cat-wrap")
                    .$("[href=\"https://arenadata.tech/about/news/\"]")
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
    void showVacancyTest() {
        step("Open main page", () -> {
            open("");
        });
        step("Go to career page", () -> {
            $(".nav__item-link").hover();
            $(".nav-cat-wrap")
                    .$("[href=\"https://arenadata.tech/about/career/\"]")
                    .click();
        });
        step("Open vacancy", () -> {
            $(".job-wrap").$(withText("QA Lead")).click();
        });
        step("Check vacancy is opened", () -> {
            $("h1").shouldHave(text("QA Lead"));
        });
    }
}
