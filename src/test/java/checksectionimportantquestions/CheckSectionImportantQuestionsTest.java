package checksectionimportantquestions;

import utils.BrowserRule;
import org.junit.Rule;
import org.junit.Test;
import pom.MainPage;

import static org.junit.Assert.assertEquals;

public class CheckSectionImportantQuestionsTest {

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void checkFirstAnswer() {
        MainPage mainPage = new MainPage(browserRule.getDriver());

        mainPage.open()
                .scrollToFirstQuestion()
                .clickFirstQuestion()
                .waitForLoadFirstAnswer();


        String expectedAnswer = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";

        String actualAnswer = mainPage.getTextFirstAnswer();

        assertEquals("Ответ не соответствует", expectedAnswer, actualAnswer);
    }

    @Test
    public void checkSecondAnswer() {
        MainPage mainPage = new MainPage(browserRule.getDriver());

        mainPage.open()
                .scrollToSecondQuestion()
                .clickSecondQuestion().
                waitForLoadSecondAnswer();

        String expectedAnswer = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";

        String actualAnswer = mainPage.getTextSecondAnswer();

        assertEquals("Ответ не соответствует вопросу", expectedAnswer, actualAnswer);
    }

    @Test
    public void checkThirdAnswer() {
        MainPage mainPage = new MainPage(browserRule.getDriver());

        mainPage.open()
                .scrollToThirdQuestion()
                .clickThirdQuestion()
                .waitForLoadThirdAnswer();

        String expectedAnswer = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";

        String actualAnswer = mainPage.getTextThirdAnswer();

        assertEquals("Ответ не соответствует вопросу", expectedAnswer, actualAnswer);
    }

    @Test
    public void checkFourthAnswer() {
        MainPage mainPage = new MainPage(browserRule.getDriver());

        mainPage.open()
                .scrollToFourthQuestion()
                .clickFourthQuestion()
                .waitForLoadFourthAnswer();

        String expectedAnswer = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";

        String actualAnswer = mainPage.getTextFourthAnswer();

        assertEquals("Ответ не соответствует вопросу", expectedAnswer, actualAnswer);
    }

    @Test
    public void checkFifthAnswer() {
        MainPage mainPage = new MainPage(browserRule.getDriver());

        mainPage
                .open()
                .scrollToFifthQuestion()
                .clickFifthQuestion()
                .waitForLoadFifthAnswer();

        String expectedAnswer = "Пока что нет! " +
                "Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";

        String actualAnswer = mainPage.getTextFifthAnswer();

        assertEquals("Ответ не соответствует вопросу", expectedAnswer, actualAnswer);
    }

    @Test
    public void checkSixthAnswer() {
        MainPage mainPage = new MainPage(browserRule.getDriver());

        mainPage.open()
                .scrollToSixthQuestion()
                .clickSixthQuestion()
                .waitForLoadSixthAnswer();

        String expectedAnswer = "Самокат приезжает к вам с полной зарядкой. " +
                "Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. " +
                "Зарядка не понадобится.";

        String actualAnswer = mainPage.getTextSixthAnswer();

        assertEquals("Ответ не соответствует вопросу", expectedAnswer, actualAnswer);
    }

    @Test
    public void checkSeventhAnswer() {
        MainPage mainPage = new MainPage(browserRule.getDriver());

        mainPage.open()
                .scrollToSeventhQuestion()
                .clickSeventhQuestion()
                .waitForLoadSeventhAnswer();

        String expectedAnswer = "Да, пока самокат не привезли. " +
                "Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";

        String actualAnswer = mainPage.getTextSeventhAnswer();

        assertEquals("Ответ не соответствует вопросу", expectedAnswer, actualAnswer);
    }

    @Test
    public void checkEighthAnswer() {
        MainPage mainPage = new MainPage(browserRule.getDriver());

        mainPage.open()
                .scrollToEighthQuestion()
                .clickEighthQuestion()
                .waitForLoadEighthAnswer();

        String expectedAnswer = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

        String actualAnswer = mainPage.getTextEighthAnswer();

        assertEquals("Ответ не соответствует вопросу", expectedAnswer, actualAnswer);
    }

}
