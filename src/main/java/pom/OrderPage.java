package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.Utils.generateCurrentDate;
import static utils.Utils.generateRandomCharacter;


public class OrderPage {

    // URL страницы c информацией о клиенте
    private final String url = "https://qa-scooter.praktikum-services.ru/order";

    //заголовок секции о клиенте
    private final By titleOfSectionAboutClient = By.className("Order_Header__BZXOb");

    //заголовок секции об аренде
    private final By titleOfSectionAboutRent = By.className("Order_Header__BZXOb");

    //Имя клиента
    private final By inputClientName = By.cssSelector("[placeholder='* Имя']");
    //Фамилия клиента
    private final By inputSurname = By.cssSelector("[placeholder='* Фамилия']");

    //Адрес заказа доставки самоката
    private final By inputClientAddress = By.cssSelector("[placeholder='* Адрес: куда привезти заказ']");

    //Станция метро
    private final By inputMetroStation = By.cssSelector("[placeholder='* Станция метро']");

    //Телефон клиента
    private final By inputClientPhone = By.cssSelector("[placeholder='* Телефон: на него позвонит курьер']");

    //кнопка далее
    private final By nextButton = By.xpath(".//button[text()='Далее']");

    //дата аренды
    private final By rentDate = By.cssSelector("[placeholder='* Когда привезти самокат']");

    //срок аренды
    private final By rentalPeriod = By.className("Dropdown-arrow");


    //варианты выбора для срока аренды
    private final By rentalPeriodTypes = By.xpath(".//div[text() = 'четверо суток']");

    // черный цвет самоката
    private final By blackColorOfScooter = By.id("black");

    //Комментарий для курьера
    private final By commentForCourier = By.cssSelector("[placeholder='Комментарий для курьера']");

    //кнопка заказать вверху страницы
    private final By orderCreateUpButton = By.className("Button_Button__ra12g");

    //кнопка заказать внизу страницы
    private final By buttonDownCreateOrder = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[2]");

    //кнопка заказать внизу страницы
    private final By buttonYeas = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text() = 'Да']");

    //сообщение об успешном создании заказа
    private final By messageAboutSuccessfulCreationOfOrder = By.className("Order_ModalHeader__3FDaJ");


    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderPage waitForLoadTitleOfSectionAboutClient() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(titleOfSectionAboutClient));
        return this;
    }

    public OrderPage waitForLoadTitleOfSectionAboutRent() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(titleOfSectionAboutRent));
        return this;
    }

    public OrderPage inputClientName(String text) {
        driver.findElement(inputClientName).sendKeys(text);
        return this;
    }

    public OrderPage moveToElement(By by) {
        new Actions(driver)
                .moveToElement(driver.findElement(by))
                .perform();
        return this;
    }

    public OrderPage moveToInputSurname() {
        moveToElement(inputSurname);
        return this;
    }

    public OrderPage inputSurname(String text) {
        driver.findElement(inputSurname).sendKeys(text);
        return this;
    }

    public OrderPage inputClientAddress(String text) {
        driver.findElement(inputClientAddress).sendKeys(text);
        return this;
    }

    public OrderPage inputMetroStation() {
        new Actions(driver)
                .moveToElement(driver.findElement(inputMetroStation))
                .click()
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
        return this;
    }

    public OrderPage inputClientPhone() {
        driver.findElement(inputClientPhone).sendKeys("89084563695");
        return this;
    }

    public OrderPage clickNextButton() {
        driver.findElement(nextButton).click();
        return this;
    }

    public OrderPage inputRentDate(String text) {
        driver.findElement(rentDate).sendKeys(text);
        return this;
    }

    public OrderPage clickRentPeriod() {
        driver.findElement(rentalPeriod).click();
        return this;
    }

    public OrderPage waitForLoadRentPeriodTypes() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(drv -> (drv.findElement(rentalPeriodTypes).getText() != null && !drv.findElement(rentalPeriodTypes).getText().isEmpty()));
        return this;
    }

    public OrderPage clickRentPeriodTypes() {
        driver.findElement(rentalPeriodTypes).click();
        return this;
    }

    public OrderPage selectBlackColorOfScooter() {
        driver.findElement(blackColorOfScooter).click();
        return this;
    }

    public OrderPage inputCommentForCourier(String text) {
        driver.findElement(commentForCourier).sendKeys(text);
        return this;
    }

    public OrderPage clickOrderCreateDownButton() {
        driver.findElement(buttonDownCreateOrder).click();
        return this;
    }

    public OrderPage clickButtonYes() {
        driver.findElement(buttonYeas).click();
        return this;
    }

    public String getMessageAboutSuccessfulCreationOfOrder() {
        return driver.findElement(messageAboutSuccessfulCreationOfOrder).getText();
    }

    public OrderPage fillOrderCreationForm() {
        inputClientName(generateRandomCharacter(14))
                .inputSurname(generateRandomCharacter(14))
                .inputClientAddress(generateRandomCharacter(14))
                .inputMetroStation()
                .inputClientPhone()
                .clickNextButton()
                .waitForLoadTitleOfSectionAboutRent()
                .inputRentDate(generateCurrentDate())
                .clickRentPeriod()
                .waitForLoadRentPeriodTypes()
                .clickRentPeriodTypes()
                .selectBlackColorOfScooter()
                .inputCommentForCourier(generateRandomCharacter(50))
                .clickOrderCreateDownButton()
                .clickButtonYes();
        return this;
    }


}
