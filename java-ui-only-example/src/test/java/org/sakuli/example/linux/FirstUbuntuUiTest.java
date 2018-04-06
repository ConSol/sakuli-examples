package org.sakuli.example.linux;

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


    @Test()
    public void testGedit() throws Exception {
        if (isTargetEnvironment()) {
            //TODO add testcode and pictures under src/test/resources/org/sakuli/example/linux/ubuntu_ui_test
        }
    }
}