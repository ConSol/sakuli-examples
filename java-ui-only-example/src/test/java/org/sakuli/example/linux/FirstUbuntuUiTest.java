package org.sakuli.example.linux;

import org.sakuli.actions.screenbased.Key;
import org.sakuli.actions.screenbased.Region;
import org.sakuli.javaDSL.TestCaseInitParameter;
import org.testng.annotations.Test;

/**
 * Test the website of the Citrus integration testing framework.
 *
 * @author tschneck
 * Date: 12/2/15
 */
public class FirstUbuntuUiTest extends AbstractSakuliLinuxTest {


    @Override
    protected TestCaseInitParameter getTestCaseInitParameter() throws Exception {
        //defines the resource folder for the screenshots
        return new TestCaseInitParameter("ubuntu_ui_test");
    }

    @Override
    protected String getDistroName() {
        return "Ubuntu";
    }

    @Test
    public void testGedit() throws Exception {
        if (isTargetEnvironment()) {
            editor.open();
            screen.find("gedit") //.png is not needed
                    .setW(300).highlight()
                    .click()
                    .paste("Initial test passed. Sakuli, Sahi and Sikuli seem to work fine. Exiting...");

            //validate text
            screen.find("gedit_result").highlight();
        }
    }

    @Test
    public void testCalculator() {
        if (isTargetEnvironment()) {
            calculator.open();

            screen.waitForImage("calculator.png", 5).highlight()
                    .mouseMove();

            Region calcRegion = calculator.getRegion().highlight();
            calcRegion.type("525")
                    .type(Key.ADD)
                    .type("100")
                    .type(Key.ENTER);

            screen.waitForImage("625", 5).highlight();
        }
    }
}