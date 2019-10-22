package herokuapp;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BasicAuth {
    WebDriver driver;

    @Test
    public void test001() {
        System.setProperty("webdriver.gecko.driver" , "C:\\Users\\danie\\IdeaProjects\\portnov\\src\\test\\resources\\drivers\\geckodriver.exe");

        openBrowser();
        openPage();
//        focusPopUp();
//        typeWrongLoginPassword();
//        submitLogin();
//        veryfyBadLoginPage();
//        goBackToLoginWindow();
//        typeCorrectLoginPassword();
//        veryfyCorrectLoginPage();

    }

    private void typeWrongLoginPassword() {
        String wrongLogin = "admin1";
        String wrongPass = "admin2";

    }

    private void focusPopUp() {
        driver.switchTo().alert().getText();
        Alert alert = driver.switchTo().alert();
    }

    private void openPage() {
        String webelement = "//*[@id=\"content\"]/ul/li[3]/a";
        driver.findElement(By.xpath(webelement)).click();

    }

    private void openBrowser() {
        driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/");
    }

}
