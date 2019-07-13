package drivers.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

/**
 * Created by dmitriy on 12/7/18.
 */


public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    protected BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,15);
    }

    protected WebElement waitForElementVisible(By elementBy) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    protected WebElement waitForOneOfElementsIsVisible(By elementBy, int timeout) throws InterruptedException {
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementBy));
        WebElement visibleElement = null;

        while (timeout > 0 && visibleElement == null) {
            visibleElement = elements.stream()
                    .filter(WebElement::isDisplayed)
                    .findFirst()
                    .orElse(null);
            timeout -= 2;
            Thread.sleep(1000);
        }

        if (visibleElement == null) {
            throw new WebDriverException("There was no visible element with selector " + elementBy.toString());
        } else {
            return visibleElement;
        }
    }

    protected boolean waitForElementInvisible(By elementBy) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(elementBy));
    }

    protected List<WebElement> waitForElemenstPresent(By elementBy) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementBy));
    }

    protected WebElement getElement(By elementBy) {
       return driver.findElement(elementBy);
    }

    protected List<WebElement> getElements(By elementBy) {
        return driver.findElements(elementBy);
    }

}