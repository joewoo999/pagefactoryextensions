package com.github.pfextentions.core.page.pageObject;

import com.github.pfextentions.core.page.pageObject.expectedCondtion.Condtion;
import com.github.pfextentions.core.page.pageObject.function.*;
import org.openqa.selenium.*;

import java.util.List;
import java.util.function.Supplier;

public interface PageElement extends WebElement {

    void click();

    void submit();

    void sendKeys(CharSequence... keysToSend);

    void clear();

    String getTagName();

    String getAttribute(String name);

    boolean isSelected();

    boolean isEnabled();

    String getText();

    List<WebElement> findElements(By by);

    WebElement findElement(By by);

    boolean isDisplayed();

    Rectangle getRect();

    Point getLocation();

    Dimension getSize();

    String getCssValue(String propertyName);

    <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException;

    /**
     * @see #getScreenshotAs(OutputType)
     * @param filePath the file to saved as
     */
    void getScreenshot(String filePath);

    /**
     * Performs a double-click at middle of the given element.
     *
     * @see org.openqa.selenium.interactions.Actions#doubleClick(WebElement)
     */
    void doubleClick();

    /**
     * Is this element present or not
     *
     * @return Whether or not the element is present
     */
    boolean isPresent();

    /**
     * Get the value of the given attribute("value") of the element.
     *
     * @return the attribute(value)'s value or null if the value is not set.
     */
    String getValue();

    /**
     * Get wrapped webelement
     *
     * @return wrapped element
     */
    WebElement getWebElement();

    /**
     * Upload file.
     * <p>
     * the given element's tag and type must be like:
     * </p>
     * '&lt;input type="file".../&gt;'
     *
     * @param filePath path of the file which to upload
     */
    void uploadFile(String filePath);

    /**
     * Assert element whether given condition is success or not.
     *
     * @param should the instance of {@link Condtion}
     * @param <V>    the return type
     * @return the return value of Functions
     * @throws AssertionError if the return value of Functions is null or false
     */
    <V> V should(Condtion<V> should);

    /**
     * Waiting until expected condition is success.
     * <p>
     * If the condition does not become success(not null or true) in a certain time,
     * throws {@link TimeoutException}
     *
     * @param should          the instance of {@link Condtion}
     * @param timeoutInSecond max waiting time
     * @param <V>             the return type
     * @return the return value of Functions
     */
    <V> V waitUntil(Condtion<V> should, int timeoutInSecond);

    /**
     * Waiting while expected condition is success.
     * <p>
     * If the condition does not become success(null or false) in a certain time,
     * throws {@link TimeoutException}
     *
     * @param should          the instance of {@link Condtion}
     * @param timeoutInSecond max waiting time
     * @param <V>             the return type
     * @return the return value of Functions
     */
    <V> V waitWhile(Condtion<V> should, int timeoutInSecond);

    /**
     * Perform simulate actions at this element.
     *
     * @param supplier the supplier of {@link ActionFunction}.
     */
    void perform(ActionSupplier supplier, Object... objects);

    /**
     * Select option or get attribute from given element.
     * <br/>
     * The given element should like:
     * <br/>
     * '&lt;select .../&gt;'
     *
     * @param supplier the supplier of {@link OptionFunction}.
     * @param <R>      the return type
     * @return the return value of Functions
     */
    <R> R select(SelectSupplier<R> supplier, Object... objects);

    /**
     * Select radio or get attribute from given element.
     * <br/>
     * The given element should like:
     * <br/>
     * '&lt;input type="radio" .../&gt;'
     *
     * @param supplier the supplier of {@link RadioGroupFunction}.
     * @param <R>      the return type
     * @return the return value of Functions
     */
    <R> R select(RadioGroupSupplier<R> supplier, Object... objects);

    /**
     * Set the element value by javascript
     *
     * @param value the value
     */
    void setValue(String value);

    /**
     * Click the element by javascript
     */
    void clickByJS();

    /**
     * Scroll page for the element in the middle of page by javascript
     */
    void scrollToCenter();

    /**
     * Execute given command
     *
     * @param supplier command supplier
     * @param objects  command parameters
     * @param <R>      the return type
     * @return the return value of Command
     */
    <R> R execute(Supplier<? extends Command> supplier, Object... objects);

}
