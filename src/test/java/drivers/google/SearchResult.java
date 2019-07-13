package drivers.google;


import drivers.base.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class SearchResult extends BaseElement {
    public SearchResult(WebElement element) {
        super(element);
    }

    public WebElement searchTitle(){
        return this.element.findElement(By.cssSelector("span[dir='ltr']"));
    }

    public String getLinkValue(){
        return this.element.findElement(By.cssSelector("a[href]")).getAttribute("href");
    }
}
