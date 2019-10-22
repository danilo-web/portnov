package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Checkboxes {
    WebDriver driver;
    WebElement checkbox1;
    WebElement checkbox2;

    @Test
    public void test0001() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\danie\\IdeaProjects\\portnov\\src\\test\\resources\\drivers\\geckodriver.exe");

        openBrowserAndPage();
        findCheckBoxSelectors();
        veifyQuantityOfcheckBoxes();
        verifyCheckboxesByDefault();
        checkCheckboxes();
        verifyNewValue();

        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.quit();

    }

    private void verifyNewValue() {
        Assert.assertEquals(checkbox1.getAttribute("checked"), "true", "checkbox 1 is not checked: ");
        Assert.assertEquals(checkbox2.getAttribute("checked"), null, "checkbox 2 is checked: ");
    }

    private void checkCheckboxes() {
        checkbox1.click();
        checkbox2.click();
    }

    private void verifyCheckboxesByDefault() {
        Assert.assertEquals(checkbox1.getAttribute("checked"), null, "checkbox 1 is not checked: ");
        Assert.assertEquals(checkbox2.getAttribute("checked"), "true", "checkbox 2 is checked: ");
        //Assert.assertEquals(checkbox2.getAttribute("checked"), true); //true is not true!!! BUT null is not false!!!

    }

    private void veifyQuantityOfcheckBoxes() {
        List<WebElement> listOfCheckBoxes = driver.findElements(By.tagName("input"));
        Assert.assertEquals(listOfCheckBoxes.size(), 2, "Quantity of checkboxes expected 2: ");
    }

    private void findCheckBoxSelectors() {
        List<WebElement> listOfCheckBoxes = driver.findElements(By.tagName("input"));
        checkbox1 = listOfCheckBoxes.get(0);
        checkbox2 = listOfCheckBoxes.get(1);
    }

    private void openBrowserAndPage() {
        driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }
}