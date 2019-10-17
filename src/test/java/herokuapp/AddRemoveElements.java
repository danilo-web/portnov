package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

// On test page we should create 2 new elements (click twice on button "create element"),
// verify if its created and then delete it and verify again.

public class AddRemoveElements {
    WebDriver driver;

    @Test
    public void test02AddRemoveElements() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\danie\\IdeaProjects\\portnov\\src\\test\\resources\\drivers\\geckodriver.exe");

        startBrowserAndOpenPage();
        addElements();
        verifyNewElements();
        deleteElements();
        verifyNewElementsDeleted();
        closeBrowser();
    }

    private void closeBrowser() {
        driver.quit();
    }

    private void verifyNewElementsDeleted() {
        List<WebElement> listOfElements = driver.findElements(By.className("added-manually"));
        int actualResult = listOfElements.size();
        int expectedResult = 0;
        Assert.assertEquals(actualResult, expectedResult, "verify quantity new elements,should be " + expectedResult);
    }

    private void deleteElements() {
        List<WebElement> listOfElements = driver.findElements(By.className("added-manually"));

        for (int i = 0; i < listOfElements.size(); i++) {
            listOfElements.get(i).click();
        }
    }

    private void verifyNewElements() {
        List<WebElement> listOfElements = driver.findElements(By.className("added-manually"));
        int actualResult = listOfElements.size();
        int expectedResult = 2;
        Assert.assertEquals(actualResult, expectedResult, "verify quantity new elements, should be " + expectedResult);
    }

    private void addElements() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#content > div > button")).click();  // created new element
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();  // created new element (2)

    }

    public void startBrowserAndOpenPage() {
        driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
    }
}
