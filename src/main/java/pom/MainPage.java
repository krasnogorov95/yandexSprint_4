package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private final WebDriver driver;

    //Локатор кнопки "Заказать", которая находится в шапке страницы
    public static final By orderHeaderButton = By.xpath(".//button[@class='Button_Button__ra12g']");

    //Локатор кнопки "Заказать", которая находится внутри страницы
    public static final By orderPageButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Локатор кнопки первого вопроса в элементе аккордеон
    public static final By buttonFirstQuestionInAccordion = By.xpath(".//div[@id='accordion__heading-0']");

    //Локатор открывающейся панели после нажатия на кнопку первого вопроса в элементе аккордеон
    public static final By answerFirstQuestionInAccordion = By.xpath(".//div[@id='accordion__panel-0']");

    //Строка с корректным текстом, который должен находится в панели первого вопроса в элементе аккордеон
    public static final String correctTextInFirstAnswerInAccordion = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";

    //Локатор кнопки второго вопроса в элементе аккардеон
    public static final By buttonSecondQuestionInAccordion = By.xpath(".//div[@id='accordion__heading-1']");

    //Локатор открывающейся панели после нажатия на кнопку второго вопроса в элементе аккордеон
    public static final By answerSecondQuestionInAccordion = By.xpath(".//div[@id='accordion__panel-1']");

    //Строка с корректным текстом, который должен находится в панели второго вопроса в элементе аккордеон
    public static final String correctTextInSecondAnswerInAccordion = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";

    //Локатор кнопки третьего вопроса в элементе аккардеон
    public static final By buttonThirdQuestionInAccordion = By.xpath(".//div[@id='accordion__heading-2']");

    //Локатор открывающейся панели после нажатия на кнопку третьего вопроса в элементе аккордеон
    public static final By answerThirdQuestionInAccordion = By.xpath(".//div[@id='accordion__panel-2']");

    //Строка с корректным текстом, который должен находится в панели третьего вопроса в элементе аккордеон
    public static final String correctTextInThirdAnswerInAccordion = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";

    //Локатор кнопки четвертого вопроса в элементе аккардеон
    public static final By buttonFourthQuestionInAccordion = By.xpath(".//div[@id='accordion__heading-3']");

    //Локатор открывающейся панели после нажатия на кнопку четвертого вопроса в элементе аккордеон
    public static final By answerFourthQuestionInAccordion = By.xpath(".//div[@id='accordion__panel-3']");

    //Строка с корректным текстом, который должен находится в панели четвертого вопроса в элементе аккордеон
    public static final String correctTextInFourthAnswerInAccordion = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";

    //Локатор кнопки пятого вопроса в элементе аккардеон
    public static final By buttonFifthQuestionInAccordion = By.xpath(".//div[@id='accordion__heading-4']");

    //Локатор открывающейся панели после нажатия на кнопку пятого вопроса в элементе аккордеон
    public static final By answerFifthQuestionInAccordion = By.xpath(".//div[@id='accordion__panel-4']");

    //Строка с корректным текстом, который должен находится в панели пятого вопроса в элементе аккордеон
    public static final String correctTextInFifthAnswerInAccordion = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";

    //Локатор кнопки шестого вопроса в элементе аккардеон
    public static final By buttonSixthQuestionInAccordion = By.xpath(".//div[@id='accordion__heading-5']");

    //Локатор открывающейся панели после нажатия на кнопку шестого вопроса в элементе аккордеон
    public static final By answerSixthQuestionInAccordion = By.xpath(".//div[@id='accordion__panel-5']");

    //Строка с корректным текстом, который должен находится в панели шестого вопроса в элементе аккордеон
    public static final String correctTextInSixthAnswerInAccordion = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";

    //Локатор кнопки седьмого вопроса в элементе аккардеон
    public static final By buttonSeventhQuestionInAccordion = By.xpath(".//div[@id='accordion__heading-6']");

    //Локатор открывающейся панели после нажатия на кнопку седьмого вопроса в элементе аккордеон
    public static final By answerSeventhQuestionInAccordion = By.xpath(".//div[@id='accordion__panel-6']");

    //Строка с корректным текстом, который должен находится в панели седьмого вопроса в элементе аккордеон
    public static final String correctTextInSeventhAnswerInAccordion = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";

    //Локатор кнопки восьмого вопроса в элементе аккардеон
    public static final By buttonEighthQuestionInAccordion = By.xpath(".//div[@id='accordion__heading-7']");

    //Локатор открывающейся панели после нажатия на кнопку восьмого вопроса в элементе аккордеон
    public static final By answerEighthQuestionInAccordion = By.xpath(".//div[@id='accordion__panel-7']");

    //Строка с корректным текстом, который должен находится в панели восьмого вопроса в элементе аккордеон
    public static final String correctTextInEighthAnswerInAccordion = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonQuestionOnAccordion(By elementLocator) {
        WebElement element = driver.findElement(elementLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public String getTextAnswerOnAccordion(By elementLocator) {
        return driver.findElement(elementLocator).getText();
    }

    public void clickOrderButton(By elementLocator) {
        WebElement element = driver.findElement(elementLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }


}

