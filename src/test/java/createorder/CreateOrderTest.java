package createorder;

import main.BrowserRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pom.MainPage;

import java.util.function.Function;

import static main.Utils.generateCurrentDate;
import static main.Utils.generateRandomCharacter;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class CreateOrderTest {
    private final Function<MainPage, MainPage> scenarioStart;

    public CreateOrderTest(MainPage.ScenarioStart scenarioStart) {
        switch (scenarioStart) {
            case UP_BUTTON:
                this.scenarioStart = MainPage::clickOrderCreateUpButton;
                break;
            case DOWN_BUTTON:
                this.scenarioStart = MainPage::clickOrderCreateDownButton;
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Parameterized.Parameters
    public static Object[][] getScenario() {
        return new Object[][] {
                { MainPage.ScenarioStart.UP_BUTTON },
                { MainPage.ScenarioStart.DOWN_BUTTON },
        };
    }

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void createOrder() {
        MainPage mainPage = new MainPage(browserRule.getDriver());

        scenarioStart.apply(mainPage.open())
                .orderPage().waitForLoadTitleOfSectionAboutClient()
                .inputClientName(generateRandomCharacter(14))
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

        String actualAnswer = mainPage.orderPage().getMessageAboutSuccessfulCreationOfOrder();
        String expectedAnswerRegex = "^Заказ оформлен\n" +
                "Номер заказа: [0-9]{1,7}.  Запишите его:\n" +
                "пригодится, чтобы отслеживать статус$";

        assertTrue("Заказ не оформлен", actualAnswer.matches(expectedAnswerRegex));
    }

}