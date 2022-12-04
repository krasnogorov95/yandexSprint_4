import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import pom.MainPage;

@RunWith(Parameterized.class)
public class AccordionQuestion {

    @Rule
    public BrowserRule browserRule = new BrowserRule();
    //private WebDriver driver;
    private final By buttonLocator;
    private final By answerLocator;
    private final String expectedText;

    public AccordionQuestion(By buttonLocator, By answerLocator, String expectedText) {
        this.buttonLocator = buttonLocator;
        this.answerLocator = answerLocator;
        this.expectedText = expectedText;
    }

    /*@Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    } */

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {MainPage.buttonFirstQuestionInAccordion, MainPage.answerFirstQuestionInAccordion, MainPage.correctTextInFirstAnswerInAccordion},
                {MainPage.buttonSecondQuestionInAccordion, MainPage.answerSecondQuestionInAccordion, MainPage.correctTextInSecondAnswerInAccordion},
                {MainPage.buttonThirdQuestionInAccordion, MainPage.answerThirdQuestionInAccordion, MainPage.correctTextInThirdAnswerInAccordion},
                {MainPage.buttonFourthQuestionInAccordion, MainPage.answerFourthQuestionInAccordion, MainPage.correctTextInFourthAnswerInAccordion},
                {MainPage.buttonFifthQuestionInAccordion, MainPage.answerFifthQuestionInAccordion, MainPage.correctTextInFifthAnswerInAccordion},
                {MainPage.buttonSixthQuestionInAccordion, MainPage.answerSixthQuestionInAccordion, MainPage.correctTextInSixthAnswerInAccordion},
                {MainPage.buttonSeventhQuestionInAccordion, MainPage.answerSeventhQuestionInAccordion, MainPage.correctTextInSeventhAnswerInAccordion},
                {MainPage.buttonEighthQuestionInAccordion, MainPage.answerEighthQuestionInAccordion, MainPage.correctTextInEighthAnswerInAccordion},
        };
    }

    @Test
    public void checkAsnwerInQuestionsIsCorrect() {
        MainPage mainPage = new MainPage(browserRule.getDriver());
        browserRule.driver.get("https://qa-scooter.praktikum-services.ru");
        mainPage.ClickButtonQuestionOnAccordion(buttonLocator);
        Assert.assertEquals(expectedText, mainPage.getTextAnswerOnAccordion(answerLocator));
    }

    /*@After
    public void tearDown() {
        driver.quit();
    } */
}
