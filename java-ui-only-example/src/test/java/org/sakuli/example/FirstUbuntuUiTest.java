package org.sakuli.example;

import org.sakuli.actions.environment.Application;
import org.sakuli.actions.environment.Environment;
import org.sakuli.actions.screenbased.Region;
import org.sakuli.javaDSL.AbstractSakuliTest;
import org.sakuli.javaDSL.TestCaseInitParameter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Optional;

/**
 * Test the website of the Citrus integration testing framework.
 *
 * @author tschneck
 * Date: 12/2/15
 */
public class FirstUbuntuUiTest extends AbstractSakuliTest {

    private Environment env;
    private Region screen;
    private Application gedit;

    @BeforeClass
    @Override
    public void initTC() throws Exception {
        super.initTC();
        env = new Environment();
        screen = new Region();
        gedit = new Application("gedit");
    }

    @Override
    protected TestCaseInitParameter getTestCaseInitParameter() throws Exception {
        //defines the resource folder for the screenshots
        return new TestCaseInitParameter("ubuntu_ui_test");
    }

    @AfterMethod
    public void closeApp() throws Exception {
        gedit.kill(true);
    }

    @Test
    public void testGedit() throws Exception {
        gedit.open();
        screen.find("gedit") //.png is not needed
                .setW(300).highlight()
                .click()
                .paste("Initial test passed. Sakuli, Sahi and Sikuli seem to work fine. Exiting...");

        //validate text
        screen.find("gedit_result");
    }

}