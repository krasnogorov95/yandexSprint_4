import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserRule extends ExternalResource {
    public WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @Override
    protected void before() throws Throwable {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://qa-scooter.praktikum-services.ru");
    }

    @Override
    protected void after() {
        driver.quit();
    }
}
