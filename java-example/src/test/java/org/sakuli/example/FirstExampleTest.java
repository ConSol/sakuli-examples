package org.sakuli.example;

import net.sf.sahi.client.ElementStub;
import org.sakuli.actions.environment.Environment;
import org.sakuli.javaDSL.AbstractSakuliTest;
import org.sakuli.javaDSL.TestCaseInitParameter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * @author tschneck
 *         Date: 12/2/15
 */
public class FirstExampleTest extends AbstractSakuliTest {

    Environment env;

    @BeforeClass
    @Override
    public void initTC() throws Exception {
        super.initTC();
        env = new Environment();
    }

    @Override
    protected TestCaseInitParameter getTestCaseInitParameter() throws Exception {
        return new TestCaseInitParameter("test1");
    }

//    @Override
//    protected String getSahiFolder() {
//        return "/home/tschneck/git-files/sakuli/sahi";
//    }

    @Test
    public void testCitrus() throws Exception {
        browser.open();
        browser.navigateTo("http://www.citrusframework.org/");

        ElementStub heading1 = browser.heading1("Citrus Integration Testing");
        heading1.highlight();
        assertTrue(heading1.isVisible());

        ElementStub download = browser.link("/Download Citrus.*/");
        download.highlight();
        assertTrue(download.isVisible());
        download.click();

        ElementStub downloadLink = browser.listItem("citrus-2.4-release (zip/tar.gz)");
        downloadLink.highlight();
        assertTrue(downloadLink.isVisible());

//        new Region().find("search").click().type("HALLO");
//        env.sleep(999);
//        new Region().takeScreenShot("/home/tschneck/git-files/sakuli-examples/java-example/test.png");
    }
}