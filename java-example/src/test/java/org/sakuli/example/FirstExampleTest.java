package org.sakuli.example;

import net.sf.sahi.client.ElementStub;
import org.sakuli.actions.environment.Environment;
import org.sakuli.actions.screenbased.Key;
import org.sakuli.actions.screenbased.Region;
import org.sakuli.javaDSL.AbstractSakuliTest;
import org.sakuli.javaDSL.TestCaseInitParameter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Test the website of the Citrus integration testing framework.
 *
 * @author tschneck
 *         Date: 12/2/15
 */
public class FirstExampleTest extends AbstractSakuliTest {

    private static final String CITRUS_URL = "http://www.citrusframework.org/";
    private Environment env;
    private Region screen;

    @BeforeClass
    @Override
    public void initTC() throws Exception {
        super.initTC();
        env = new Environment();
        screen = new Region();
        browser.open();
    }

    @Override
    protected TestCaseInitParameter getTestCaseInitParameter() throws Exception {
        return new TestCaseInitParameter("test_citrus");
    }

    @Test
    public void testCitrusPictures() throws Exception {
        browser.navigateTo(CITRUS_URL);
        env.setSimilarity(0.8);
        screen.find("citrus_logo.png").highlight();
        env.type(Key.END);
        screen.find("consol_logo.png").highlight();
    }

    @Test
    public void testCitrusHtmlContent() throws Exception {
        browser.navigateTo(CITRUS_URL);
        ElementStub heading1 = browser.paragraph("Citrus Integration Testing");
        heading1.highlight();
        assertTrue(heading1.isVisible());

        ElementStub download = browser.link("/Download v.*/");
        download.highlight();
        assertTrue(download.isVisible());
        download.click();

        ElementStub downloadLink = browser.cell("2.6.1");
        downloadLink.highlight();
        assertTrue(downloadLink.isVisible());
    }

}