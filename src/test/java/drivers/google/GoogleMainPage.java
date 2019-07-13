package drivers.google;

import drivers.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.stream.Collectors;



public class GoogleMainPage extends BasePage {
    public GoogleMainPage(WebDriver driver) {
        super(driver);
    }

    public WebElement search_input(){
       return super.waitForElementVisible(By.cssSelector("input[type='text']"));
    }

    public List<SearchResult> get_search_results(){
        return super.getElements(By.className("rc"))
                .stream()
                .map(SearchResult::new)
                .collect(Collectors.toList());
    }
}