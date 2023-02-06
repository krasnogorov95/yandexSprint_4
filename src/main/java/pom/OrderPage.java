package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {

    private final WebDriver driver;

    //Локатор поля ввода имени на странице заполнения заявки
    private By firstNameField = By.xpath(".//input[@placeholder='* Имя']");
    //Локатор поля ввода фамилии на странице заполнения заявки
    private By lastNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //Локатор поля ввода адреса на странице заполнения заявки
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Локатор поля ввода станции метро на странице заполнения заявки
    private By metroField = By.xpath(".//input[@class='select-search__input']");
    //Локатор поля ввода номера телефона на странице заполнения заявки
    private By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Локатор кнопки для перехода на следующий этап заполнения заявки
    private By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Локатор поля ввода даты на странице заполнения звяки
    private By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Локатор списка выбора продолжительности аренды
    private By rentField = By.xpath(".//div[@class='Dropdown-placeholder']");
    //Локатор чекбокса цвета "Черная жемчужина"/
    private By blackColourCheckbox = By.xpath(".//label[@for ='black']");
    //Кнопка подтверждения создания заявки на странице заполнения заявки
    private By finalOrderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputFirstNameField(String name) {
        driver.findElement(firstNameField).sendKeys(name);
    }

    public void inputLastNameField(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void inputAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void selectMetro(String metro) { // метро сюда придет из тестовых данных
        driver.findElement(metroField).sendKeys(metro);
        selectMetroFromOptions(metro);
    }

    private void selectMetroFromOptions(String metro) {
        String metroOptionTemplate = ".//div[@class='select-search__select']//*[text()='%s']";
        String element = String.format(metroOptionTemplate, metro);
        driver.findElement(By.xpath(element)).click();
    }

    public void inputPhoneField(String phoneNumber) {
        driver.findElement(phoneField).sendKeys(phoneNumber);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void inputDateField(String date) {
        driver.findElement(dateField).sendKeys(date);
    }

    public void selectRentDuration() {
        driver.findElement(rentField).click();
        driver.findElement(By.xpath(".//div[text() = 'сутки']")).click();
    }

    public void selectColour() {
        driver.findElement(blackColourCheckbox).click();
    }

    public void clickFinalOrderButton() {
        driver.findElement(finalOrderButton).click();
    }
}
