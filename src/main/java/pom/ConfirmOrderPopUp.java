package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmOrderPopUp {
    private final WebDriver driver;

    //Локатор кнопки "Да" в всплывающем окне при подтверждении заказа в конце заполнения заявки
    private static final By confirmOrderButton = By.xpath(".//button[text()='Да']");
    //Локатор заголовка всплывающего окна, подтверждающий успешное создание заявки
    private static final By confirmHeader = By.xpath(".//div[text()='Заказ оформлен']");

    public ConfirmOrderPopUp(WebDriver driver) {
        this.driver = driver;
    }

    public void clickConfirmOrderButton() {
        driver.findElement(confirmOrderButton).click();
    }
    public String getTextConfirmHeader() {
        return driver.findElement(confirmHeader).getText();
    }
}
