package drivers.base;

import org.openqa.selenium.*;

import java.util.List;

/**
 * Created by dmitriy on 7/11/19.
 */
public class BaseElement implements WebElement {
    protected WebElement element;

    public BaseElement(WebElement element) {
        this.element = element;
    }

    public WebElement getElement(){
        return this.element;
    }

    @Override
    public void click() {
        this.element.click();
    }

    @Override
    public void submit() {
        this.element.submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        this.element.sendKeys(charSequences);
    }

    @Override
    public void clear() {
        this.element.click();
    }

    @Override
    public String getTagName() {
        return this.element.getTagName();
    }

    @Override
    public String getAttribute(String attribute) {
        return this.element.getAttribute(attribute);
    }

    @Override
    public boolean isSelected() {
        return this.element.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return this.element.isEnabled();
    }

    @Override
    public String getText() {
        return this.element.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return this.element.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return this.element.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return this.element.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return this.element.getLocation();
    }

    @Override
    public Dimension getSize() {
        return this.element.getSize();
    }

    @Override
    public Rectangle getRect() {
        return this.element.getRect();
    }

    @Override
    public String getCssValue(String css) {
        return this.element.getCssValue(css);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return this.element.getScreenshotAs(outputType);
    }
}
