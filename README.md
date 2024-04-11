# DemoAutomationTest
Java-Selenium-Cucumber-Junit

Run test by tag feature of module

mvn clean verify -pl modules/ui-functional-test -D"cucumber.filter.tags=@UI" -Dbrowser=chrome
mvn clean verify -pl modules/api-functional-test -D"cucumber.filter.tags=@UI" -Dbrowser=chrome

-Dbrowser= what browser you using for testing
Run all feature in module
mvn clean verify -pl modules/ui-functional-test -Dbrowser=chrome

Check style code by google

mvn checkstyle:checkstyle

    //    long threadId = Thread.currentThread().getId();
    //    System.out.println(threadId + ": Thread----------");
    //    System.out.println("hello");'
