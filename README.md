# DemoAutomationTest
Java-Selenium-Cucumber-Junit

Run test by tag feature of module

UI functional 

mvn clean verify -pl modules/ui-functional-test -D"cucumber.filter.tags=@UI" -Dbrowser=chrome

API functional

mvn clean verify -pl modules/api-functional-test -D"cucumber.filter.tags=@API"

Change @UI or @API = your tag and change your modules/**-functional-test = your modules

-Dbrowser= = browser name 
example = -Dbrowser=chrome
Run all feature in module
mvn clean verify -pl modules/ui-functional-test -Dbrowser=chrome

Check style code by google: 
mvn checkstyle:checkstyle

If you want to generate report: need "surefire-report:report" after command line
