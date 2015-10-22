_dynamicInclude($includeFolder);
var testCase = new TestCase(60, 70);
var env = new Environment();
var screen = new Region();

try {	 

	 //Anmeldung am Shop
	 _assertExists(_link("Anmelden"));
	 _assert(_isVisible(_link("Anmelden")));
	 _click(_link("Anmelden"));
	 _click(_textbox("lgn_usr[1]"));
	 _setValue(_textbox("lgn_usr[1]"), "sahimon.itoring@googlemail.com");
	 _highlight(_password("lgn_pwd"));
	 _click(_password("lgn_pwd"));
	 _setValue(_password("lgn_pwd"), "sahimon");
	 
	 _highlight(_submit("Anmelden"));
	 _click(_submit("Anmelden"));
	 
	testCase.endOfStep("Login", 10);

	 //gehe zum Warenbkorb
	 _highlight(_link("Warenkorb"));
	 _click(_link("Warenkorb"));

	 //wenn Warenkorb nicht leer -> löschen
	 if (! (_condition(_exists(_div("Der Warenkorb ist leer."))))) {
		 _highlight(_checkbox("checkAll"));
		 _click(_checkbox("checkAll"));
		 _highlight(_submit("entfernen"));
		 _click(_submit("entfernen"));
	 }
	testCase.endOfStep("Warenkorb leeren", 10);
	 // gehe zur Startseite
	 _assertExists(_link("Startseite"));
	 _highlight(_link("Startseite"));
	 _click(_link("Startseite"));



	 // Artikel 1 ========================================
	 // suche Artikel 
	 _highlight(_textbox("searchparam"));
	 _click(_textbox("searchparam"));
	 _setValue(_textbox("searchparam"), "1301");
	 _highlight(_submit("searchSubmit"));
	 _click(_submit("searchSubmit"));

	 // prüfe Beschreibung
	 _highlight(_link("Kiteboard RRD TOXIC WAVE2"));
	 _assert(_isVisible(_link("Kiteboard RRD TOXIC WAVE2")));
	 _click(_link("Kiteboard RRD TOXIC WAVE2"));

	 // bestellen 
	 _highlight(_textbox("am"));
	 _click(_textbox("am"));
	 _setValue(_textbox("am"), "2");
	 _highlight(_submit("in den Warenkorb"));
	 _click(_submit("in den Warenkorb"));

	 
	 // Artikel 2 ===============================================
	 // suche Artikel 
	 _highlight(_textbox("searchparam"));
	 _click(_textbox("searchparam"));
	 _setValue(_textbox("searchparam"), "1505");
	 _highlight(_submit("searchSubmit"));
	 _click(_submit("searchSubmit"));
	 // prüfe Beschreibung
	 _highlight(_link("Helm AHM 5000"));
	 _assertExists(_link("Helm AHM 5000"));
	 _assert(_isVisible(_link("Helm AHM 5000")));
	 _click(_link("Helm AHM 5000"));
	 // bestellen
	 _highlight(_textbox("am"));
	 _setValue(_textbox("am"), "3");
	 _highlight(_submit("in den Warenkorb"));
	 _click(_submit("in den Warenkorb"));
	 _click(_image("x.png"));
	 testCase.endOfStep("Artikel Bestellung", 60)
	 
	 
	 // prüfe Warenkorb-Inhalt ====================================
	 _assertExists(_link("Warenkorb"));
	 _assert(_isVisible(_link("Warenkorb")));
	 _assertEqual("Warenkorb", _getText(_link("Warenkorb")));
	 _assertContainsText("Warenkorb", _link("Warenkorb"));
	 _highlight(_link("Warenkorb"));
	 _click(_link("Warenkorb"));
	 // prüfe Summe
	 _highlight(_cell("1.153,00 €[1]"));
	 _assert(_isVisible(_cell("1.153,00 €[1]")));

	  testCase.endOfStep("Warenkorb Check", 10);
	 
	 //Bestellung drucken
	 screen.type("p", Key.CTRL);
	 
	
	 screen.waitForImage("print2file",20);
	 env.type(Key.TAB);
	 env.sleep(1);
	 env.type(Key.TAB);
	 env.sleep(1);
	 
	 //Dateiname mit Timestamp
	 var name = "sakuli_test_" + Date.now(); 
	 env.sleep(1);
	 screen.type(name);
	 screen.waitForImage("sakuli_test",10);
	 screen.waitForImage("print",5).click();
	 testCase.endOfStep("PDF generieren", 20);
    env.sleep(4);
    
    //PDF anzeigen
	 var pdfviewer = new Application("/usr/bin/evince");
	 pdfviewer.open();
	 env.type("o", Key.CTRL);
	 var f_type = screen.exists("type",3);
	 if (f_type == null) {
	    screen.find("pen").click();
	 }
	 env.sleep(1);
	 env.paste("/home/e2e/sakuli/" + name).type(Key.ENTER);
	 
	 testCase.endOfStep("PDF anzeigen", 20);

  
    
	// Logout ========================================
	_highlight(_link("Logout"));
	_click(_link("Logout"));
	_assertExists(_link("Anmelden"));
	_assert(_isVisible(_link("Anmelden")));

} catch (e) {
    testCase.handleException(e);
} finally {
	 pdfviewer.close();
    testCase.saveResult();
    
}
