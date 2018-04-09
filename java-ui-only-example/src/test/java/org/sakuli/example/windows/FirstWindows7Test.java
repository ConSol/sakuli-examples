package org.sakuli.example.windows;

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
public class FirstWindows7Test extends AbstractSakuliWindowsTest {

    @Override
    protected TestCaseInitParameter getTestCaseInitParameter() throws Exception {
        //defines the resource folder for the screenshots
        return new TestCaseInitParameter("win7");
    }

    @Override
    protected String getWinIdentifier() {
        return "Windows 7";
    }

    @Test
    public void testNotepad() throws Exception {
        if (isTargetEnvironment()) {
            editor.open();
            screen.find("notepad") //.png is not needed
                    .setW(300).highlight()
                    .click()
                    .paste("Initial test passed. Sakuli, Sahi and Sikuli seem to work fine. Exiting...");

            //validate text
            screen.find("notepad_result.png").highlight();
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

            calcRegion.waitForImage("625.png", 5).highlight();
        }
    }
}