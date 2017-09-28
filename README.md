# Sakuli Examples
This repository contains a bunch of example projects of the end-2-end testing and monitoring Framework **[Sakuli]**. By default, the examples use the JavaScript based testdefinition, see [Sakuli Documentation - Execution Types](http://consol.github.io/sakuli/v1.1.0-SNAPSHOT/index.html#execution-types).


* **[First Steps Tutorial](./tutorials/first-steps/first-steps.md)**
    * Learn how to write your first Sakuli tests.
    * Learn how to use the Sahi controller and recorder.

* **[Java Setup: End-2-End Testing with Sakuli](./java-example/README.md)**
    * System under test: [Citrus Integrationtesting Framework](http://www.citrusframework.org/)
    * Runtime environment: local developer machine ***or*** Docker host with Docker Compose based configuration
    * Java unit test with [TestNG](http://testng.org)
    * Integrated in Maven build system
    
   
* **[Java Setup: End-2-End Testing with Selenium & Sakuli (under developement)](./java-selenium-example/README.md)**
    * System under test: [Citrus Integrationtesting Framework](http://www.citrusframework.org/)
    * Runtime environment: local developer machine ***or*** Docker host with Docker Compose based configuration
    * Java unit test with [TestNG](http://testng.org)
    * Web test actions implemented with [Selenium](https://www.selenium.org) 
    * Integrated in Maven build system
    
    
* **[Tutorial: Sakuli & OMD](./omd-labs-sakuli/README.md)**
    * System under test: [Thruk Monitoring GUI](https://www.thruk.org/)
    * Runtime environment: Docker host with Docker Compose based configuration
    * Continuous end-2-end monitoring with [OMD Labs](https://labs.consol.de/omd/) (Nagios)
    * Configuration of OMD checks
    * Testing SSL secured websites
    
    
* **[Websitetesting OXID eShop](./oxid_ubuntu)**
    * System under test: [OXID eShop](https://oxidforge.org/en/)
    * Runtime environment: local machine with installed Sakuli
    * Example testsuite writen in JavaScript


* **[Containerized end-2-end test example](https://github.com/toschneck/sakuli-example-bakery-testing)**
    * See **Github repository: [toschneck/sakuli-example-bakery-testing](https://github.com/toschneck/sakuli-example-bakery-testing)**
    * System under test: microservice based Web-Application
    * Runtime environment: Docker host with Docker Compose based configuration
    * CI-Build with Jenkins
    * Continuous end-2-end monitoring with [OMD Labs](https://labs.consol.de/omd/) (Nagios)
    * Parallel execution of 4 tests through and PDF testing

[Sakuli]:https://github.com/ConSol/sakuli
