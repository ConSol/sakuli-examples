_dynamicInclude($includeFolder);
var testCase = new TestCase(20, 30);
var env = new Environment();
var screen = new Region();

try {
    // our code
    env.sleep(1000000);
    _navigateTo("https://omd/demo/");
} catch (e) {
    testCase.handleException(e);
} finally {
    testCase.saveResult();
}
