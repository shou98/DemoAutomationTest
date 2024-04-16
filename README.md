# DemoAutomationTest
Java-Selenium-Cucumber-Junit

Run test by tag feature of module

mvn clean verify -pl modules/ui-functional-test -D"cucumber.filter.tags=@UI" -Dbrowser=chrome

mvn clean verify -pl modules/api-functional-test -D"cucumber.filter.tags=@UI" -Dbrowser=chrome

Change @UI = your tag

-Dbrowser= = browser name 
example = -Dbrowser=chrome
Run all feature in module
mvn clean verify -pl modules/ui-functional-test -Dbrowser=chrome

Check style code by google: 
mvn checkstyle:checkstyle
generating-report: need "surefire-report:report" after command line
