import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import pom.ConfirmOrderPopUp;
import pom.MainPage;
import pom.OrderPage;

@RunWith(Parameterized.class)
public class OrderPositiveTest {

    @Rule
    public BrowserRule browserRule = new BrowserRule();
    private final By button;
    private final String name;
    private final String lastName;
    private final String address;
    private final String metro;
    private final String phoneNumber;
    private final String date;


    public OrderPositiveTest(By button, String name, String lastName, String address, String metro, String phoneNumber, String date) {
        this.button = button;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.metro = metro;
        this.phoneNumber = phoneNumber;
        this.date = date;
    }

    @Parameterized.Parameters()
    public static Object[][] getData() {
        return new Object[][] {
                {MainPage.orderHeaderButton, "Иван", "Иваанов", "Иванова 15", "Черкизовская", "88005553535", "05.12.2022"},
                {MainPage.orderPageButton, "Сидр", "Сидоров", "улица Сидорова, дом 4", "Сокольники", "+78005553535", "12.12.2022"},
        };
    }

    @Test
    public void orderSubmissionPositivePathTest(){
        MainPage mainPage = new MainPage(browserRule.getDriver());
        OrderPage orderPage = new OrderPage(browserRule.getDriver());
        ConfirmOrderPopUp confirmOrderPopUp = new ConfirmOrderPopUp(browserRule.getDriver());
        mainPage.clickOrderButton(button);
        orderPage.inputFirstNameField(name);
        orderPage.inputLastNameField(lastName);
        orderPage.inputAddressField(address);
        orderPage.selectMetro(metro);
        orderPage.inputPhoneField(phoneNumber);
        orderPage.clickNextButton();
        orderPage.selectRentDuration();
        orderPage.inputDateField(date);
        orderPage.selectColour();
        orderPage.clickFinalOrderButton();
        confirmOrderPopUp.clickConfirmOrderButton();

        String actualText = confirmOrderPopUp.getTextConfirmHeader();
        String expectedText = "Заказ оформлен";
        Assert.assertTrue(String.format("Ожидаемый успешный заголовок должен содержать: '%s'", expectedText), actualText.contains(expectedText));
    }
}
