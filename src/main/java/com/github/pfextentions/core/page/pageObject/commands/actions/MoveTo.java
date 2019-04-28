package com.github.pfextentions.core.page.pageObject.commands.actions;

import com.github.pfextentions.core.driverContext.DriverContext;
import com.github.pfextentions.core.page.pageObject.function.ActionFunction;
import org.openqa.selenium.support.pagefactory.ElementLocator;

public class MoveTo implements ActionFunction {
    private ElementLocator locator;

    @Override
    public void accept(ElementLocator locator) {
        this.locator = locator;

        DriverContext.getActions().moveToElement(locator.findElement()).perform();
    }

    @Override
    public String toString() {
        return String.format("(ActionFunction)Move to element:%s.", locator);
    }
}