Code quality: ![Maven Build](https://github.com/Nephty/calculator-cucumber-2024/actions/workflows/maven.yml/badge.svg)
![CodeQL](https://github.com/LicorneRose765/ClockSystem/actions/workflows/codeql.yml/badge.svg)

![ScoreCard](https://github.com/Nephty/calculator-cucumber-2024//actions/workflows/scorecard.yml/badge.svg )

[![OpenSSF Scorecard](https://api.securityscorecards.dev/projects/github.com/Nephty/calculator-cucumber-2024/badge)](https://securityscorecards.dev/viewer/?uri=github.com/Nephty/calculator-cucumber-2024)

Test coverage: ![Coverage](.github/badges/jacoco.svg)
![Branches](.github/badges/branches.svg)
[![codecov](https://codecov.io/gh/Nephty/calculator-cucumber-2024/branch/master/graph/badge.svg)](https://codecov.io/gh/Nephty/calculator-cucumber-2024)

[![Javadoc](https://img.shields.io/badge/JavaDoc-Online-green)](https://nephty.github.io/calculator-cucumber-2024/javadoc/)



# Calculating arithmetic expressions

## About

This repository contains Java code for computing arithmetic expressions. The base code was deliberately incomplete as it served to be the basis of all kinds of extensions, such as a more sophisticated Calculator application. The base code was written to be used for educational purposes at the University of Mons, Belgium in the context of the software evolution course. This fork is the implementation of four features added on top of the base code. These features are :

- support for complex numbers,
- support for rational numbers,
- support for real numbers and
- conversion of units.


### Unit testing and BDD

*  All tests can be found in the src\test directory. They serve as executable documentation of the source code.
*  The source code is accompanied by a set of JUnit 5 unit tests. These tests can be written and run in the usual way. If you are not familiar with unit testing or JUnit 5, please refer to https://junit.org/junit5/.
*  The source code is accompanied by a set of Cucumber BDD scenarios, also running in Junit. If you are not familiar with Cucumber and BDD, please refer to https://cucumber.io/docs/cucumber/.
The BDD scenarios are specified as .feature files in the src\test\resources directory. Some classes defined in src\test take care of converting these scenarios to executable JUnit tests.

### Prerequisites

*  You will need to have a running version of Java 21 on your machine in order to be able to compile and execute this code, although it is also backward compatible with earlier versions of Java.
*  You will need to have a running version of Maven, since this project is accompanied by a pom.xml file so that it can be installed, compiled, tested and run using Maven.

### Installation and testing instructions

*  Upon first use of the code in this repository, you will need to run "mvn clean install" to ensure that all required project dependencies (e.g. for Java, JUnit, Cucumber, and Maven) will be downloaded and installed locally.
*  Assuming you have a sufficiently recent version of Maven installed (the required versions are specified as properties in the POM file), you can compile the source code using "mvn compile"
*  Once the code is compiled, you can execute the main class of the Java code using "mvn javafx:run" 
*  The tests and BDD scenarios are executable with Maven using "mvn test"
*  Note that the tests are also executed when you do a "mvn install". It is possible to skip those tests by providing an extra parameter. For details of more advanced uses of Maven, please refer to its official documentation https://maven.apache.org/guides/.

### Test coverage and JavaDoc reporting

*  In addition to testing the code, "mvn test" will also generate a test coverage report (in HTML format) using JaCoCo. This test coverage is generated in target/site/jacoco.
*  When packaging the code using "mvn package" the JavaDoc code documentation will be generated and stored in target/site/apidocs.

## Built With

*  [Maven](https://maven.apache.org/) - an open source build automation and dependency management tool
*  [JUnit5](https://junit.org/junit5/) - a unit testing framework for Java
*  [Cucumber](https://cucumber.io/docs/cucumber/) - a tool for Behaviour-Driven Development
*  [JaCoCo](https://www.jacoco.org) - a code coverage library for Java
*  [JavaDoc](https://docs.oracle.com/en/java/javase/17/javadoc/javadoc.html) - a code documentation tool for Java

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/tommens/calculator-cucumber/tags). 

## Base Contributors

* Tom Mens
* Gauvain Devillez @GauvainD
* Damien Legay @DamienLegay

## Contributors of this fork

* Thomas Bernard
* Moreau Arnaud
* Moreau Cyril
* Vion François

## Licence

This code is licensed as CC BY-SA 4.0 (Creative Commons Attribution-ShareAlike 4.0 International)
https://creativecommons.org/licenses/by-sa/4.0/

## Acknowledgments

* Software Engineering Lab, Faculty of Sciences, University of Mons, Belgium.
