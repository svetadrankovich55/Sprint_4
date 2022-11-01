package createorder;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pom.MainPage;
import utils.BrowserRule;

import java.util.function.Function;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class CreateOrderTest {
    private final Function<MainPage, MainPage> scenarioStart;
    @Rule
    public BrowserRule browserRule = new BrowserRule();

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

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] getScenario() {
        return new Object[][]{{MainPage.ScenarioStart.UP_BUTTON}, {MainPage.ScenarioStart.DOWN_BUTTON},};
    }

    @Test
    public void createOrder() {
        MainPage mainPage = new MainPage(browserRule.getDriver());

        scenarioStart.apply(mainPage.open()).orderPage().waitForLoadTitleOfSectionAboutClient().fillOrderCreationForm();

        String actualAnswer = mainPage.orderPage().getMessageAboutSuccessfulCreationOfOrder();
        String expectedAnswerRegex = "^Заказ оформлен\n" + "Номер заказа: [0-9]{1,7}. {2}Запишите его:\n" + "пригодится, чтобы отслеживать статус$";

        assertTrue("Заказ не оформлен", actualAnswer.matches(expectedAnswerRegex));
    }

}