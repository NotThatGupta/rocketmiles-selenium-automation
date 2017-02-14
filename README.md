Rocketmiles Automation Exercise
==============

Overview
--------------
Selenium 3.0 +TestNg Maven Sample Testing Suite for Rocketmiles

Configurable to run tests locally or remotely using GRID with various browsers and various environments

Set driver executables location in initTestSuite() method of BaseTest class

Maven Profiles
--------------
The 3 profile groups are environment, browser, and grid.

For example, to run all tests locally in the prod environment using chrome,

    mvn clean test -Pprod,chrome,nogrid
