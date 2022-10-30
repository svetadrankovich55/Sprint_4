package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage {

    // URL главной страницы
    private final String url = "https://qa-scooter.praktikum-services.ru/";

    //кнопка заказать вверху страницы
    private final By orderCreateUpButton = By.className("Button_Button__ra12g");

    //кнопка заказать внизу страницы
    private final By orderCreateDownButton = By.xpath(".//div[@class = 'Home_FinishButton__1_cWm']/button[text() = 'Заказать']");

    //вопрос 1
    private final By firstQuestion = By.id("accordion__heading-0");

    //вопрос 2
    private final By secondQuestion = By.id("accordion__heading-1");

    //вопрос 3
    private final By thirdQuestion = By.id("accordion__heading-2");

    //вопрос 4
    private final By fourthQuestion = By.id("accordion__heading-3");

    //вопрос 5
    private final By fifthQuestion = By.id("accordion__heading-4");

    //вопрос 6
    private final By sixthQuestion = By.id("accordion__heading-5");

    //вопрос 7
    private final By seventhQuestion = By.id("accordion__heading-6");

    //вопрос 8
    private final By eighthQuestion = By.id("accordion__heading-7");

    //ответ 1
    private final By firstAnswer = By.id("accordion__panel-0");

    //ответ 2
    private final By secondAnswer = By.id("accordion__panel-1");

    //ответ 3
    private final By thirdAnswer = By.id("accordion__panel-2");

    //ответ 4
    private final By fourthAnswer = By.id("accordion__panel-3");

    //ответ 5
    private final By fifthAnswer = By.id("accordion__panel-4");

    //ответ 6
    private final By sixthAnswer = By.id("accordion__panel-5");

    //ответ 7
    private final By seventhAnswer = By.id("accordion__panel-6");

    //ответ 8
    private final By eighthAnswer = By.id("accordion__panel-7");

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public By getOrderCreateUpButton() {
        return orderCreateUpButton;
    }

    public By getOrderCreateDownButton() {
        return orderCreateDownButton;
    }

    public By getFirstQuestion() {
        return firstQuestion;
    }

    public By getSecondQuestion() {
        return secondQuestion;
    }

    public By getThirdQuestion() {
        return thirdQuestion;
    }

    public By getFourthQuestion() {
        return fourthQuestion;
    }

    public By getFifthQuestion() {
        return fifthQuestion;
    }

    public By getSixthQuestion() {
        return sixthQuestion;
    }

    public By getSeventhQuestion() {
        return seventhQuestion;
    }

    public By getEighthQuestion() {
        return eighthQuestion;
    }

    public By getFirstAnswer() {
        return firstAnswer;
    }

    public By getSecondAnswer() {
        return secondAnswer;
    }

    public By getThirdAnswer() {
        return thirdAnswer;
    }

    public By getFourthAnswer() {
        return fourthAnswer;
    }

    public By getFifthAnswer() {
        return fifthAnswer;
    }

    public By getSixthAnswer() {
        return sixthAnswer;
    }

    public By getSeventhAnswer() {
        return seventhAnswer;
    }

    public By getEighthAnswer() {
        return eighthAnswer;
    }

    public MainPage open() {
        driver.get(url);
        return this;
    }

    public MainPage clickOrderCreateUpButton() {
        driver.findElement(orderCreateUpButton).click();
        return this;
    }

    public MainPage clickOrderCreateDownButton() {
        scrollToOrderCreateDownButton();
        driver.findElement(orderCreateDownButton).click();
        return this;
    }

    public MainPage clickFirstQuestion() {
        driver.findElement(firstQuestion).click();
        return this;
    }

    public MainPage clickSecondQuestion() {
        driver.findElement(secondQuestion).click();
        return this;
    }

    public MainPage clickThirdQuestion() {
        driver.findElement(thirdQuestion).click();
        return this;
    }

    public MainPage clickFourthQuestion() {
        driver.findElement(fourthQuestion).click();
        return this;
    }

    public MainPage clickFifthQuestion() {
        driver.findElement(fifthQuestion).click();
        return this;
    }

    public MainPage clickSixthQuestion() {
        driver.findElement(sixthQuestion).click();
        return this;
    }

    public MainPage clickSeventhQuestion() {
        driver.findElement(seventhQuestion).click();
        return this;
    }

    public MainPage clickEighthQuestion() {
        driver.findElement(eighthQuestion).click();
        return this;
    }

    public String getTextFirstAnswer() {
        return driver.findElement(firstAnswer).getText();

    }

    public String getTextSecondAnswer() {
        return driver.findElement(secondAnswer).getText();

    }

    public String getTextThirdAnswer() {
        return driver.findElement(thirdAnswer).getText();

    }

    public String getTextFourthAnswer() {
        return driver.findElement(fourthAnswer).getText();

    }

    public String getTextFifthAnswer() {
        return driver.findElement(fifthAnswer).getText();

    }

    public String getTextSixthAnswer() {
        return driver.findElement(sixthAnswer).getText();

    }

    public String getTextSeventhAnswer() {
        return driver.findElement(seventhAnswer).getText();

    }

    public String getTextEighthAnswer() {
        return driver.findElement(eighthAnswer).getText();

    }

    private void scrollToElement(By by) {
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(drv -> (drv.findElement(by).isDisplayed()));
    }

    public MainPage scrollToFirstQuestion() {
        scrollToElement(firstQuestion);
        return this;
    }

    public MainPage scrollToOrderCreateDownButton() {
        scrollToElement(orderCreateDownButton);
        return this;
    }

    public MainPage scrollToSecondQuestion() {
        scrollToElement(secondQuestion);
        return this;
    }

    public MainPage scrollToThirdQuestion() {
        scrollToElement(thirdQuestion);
        return this;
    }

    public MainPage scrollToFourthQuestion() {
        scrollToElement(fourthQuestion);
        return this;
    }

    public MainPage scrollToFifthQuestion() {
        scrollToElement(fifthQuestion);
        return this;
    }

    public MainPage scrollToSixthQuestion() {
        scrollToElement(sixthQuestion);
        return this;
    }

    public MainPage scrollToSeventhQuestion() {
        scrollToElement(seventhQuestion);
        return this;
    }

    public MainPage scrollToEighthQuestion() {
        scrollToElement(eighthQuestion);
        return this;
    }


    public void waitForLoadElement(By by) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(drv -> (drv.findElement(by).getText() != null && !drv.findElement(by).getText().isEmpty()));
    }


    public MainPage waitForLoadFirstAnswer() {
        waitForLoadElement(firstAnswer);
        return this;
    }

    public MainPage waitForLoadSecondAnswer() {
        waitForLoadElement(secondAnswer);
        return this;
    }

    public MainPage waitForLoadThirdAnswer() {
        waitForLoadElement(thirdAnswer);
        return this;
    }

    public MainPage waitForLoadFourthAnswer() {
        waitForLoadElement(fourthAnswer);
        return this;
    }

    public MainPage waitForLoadFifthAnswer() {
        waitForLoadElement(fifthAnswer);
        return this;
    }

    public MainPage waitForLoadSixthAnswer() {
        waitForLoadElement(sixthAnswer);
        return this;
    }

    public MainPage waitForLoadSeventhAnswer() {
        waitForLoadElement(seventhAnswer);
        return this;
    }

    public MainPage waitForLoadEighthAnswer() {
        waitForLoadElement(eighthAnswer);
        return this;
    }

    public OrderPage orderPage() {
        return new OrderPage(driver);
    }

    public enum ScenarioStart {
        UP_BUTTON,
        DOWN_BUTTON
    }
}
