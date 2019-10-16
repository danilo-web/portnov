import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Flights {
    WebDriver driver;

    @AfterTest
    public void testName() {
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\danie\\IdeaProjects\\portnov\\src\\test\\resources\\drivers\\geckodriver.exe");

        openBrowser();
        navigateToMainPage();
        radioTypeTrip();
        dropDownPassengers();
        dropDownDeparting();
        dropDownMonth();
        setCheckBox();
        submitSearch();
        assertResultPage();
    }
    private void assertResultPage() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String selector = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[1]/td/p/font/b/font[3" +
                "]/font[2]/font";
        WebElement webElement = driver.findElement(By.xpath(selector));
        String message = webElement.getText();
        System.out.println(message);
        String expectedMessage = "Please press your browser's back button to return to the previous page or click the \"BACK TO HOME\" icon below " +
                "to go to the homepage.";
        Assert.assertEquals(message, expectedMessage);
        }
    private void submitSearch() throws InterruptedException {
        Thread.sleep(5000);
        String selector = "findFlights";
        driver.findElement(By.name(selector)).click();
    }
    private void setCheckBox() {
        String selector = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody" +
                "/tr[9]/td[2]/font/font/input[2]";
        driver.findElement(By.xpath(selector)).click();
    }
    private void dropDownMonth () {
        String selector = "fromMonth";
        Select month = new Select(driver.findElement(By.name(selector)));
        month.selectByIndex(1);
    }
    private void dropDownDeparting () {
        String selector = "fromPort";
        Select city = new Select(driver.findElement(By.name(selector)));
        city.selectByVisibleText("New York");
    }
    private void dropDownPassengers() {
        String selector = "passCount";
        Select count = new Select(driver.findElement(By.name(selector)));
        count.selectByValue("3");
    }
    private void radioTypeTrip() {
        String selector = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody" +
                "/tr[2]/td[2]/b/font/input[2]";
        driver.findElement(By.xpath(selector)).click();
    }
    private void navigateToMainPage() {
        String url = "http://demo.guru99.com/test/newtours/reservation.php";
        driver.get(url);
    }
    private void openBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}