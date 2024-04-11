mvn clean verify -pl modules/ui-functional-test -D"cucumber.filter.tags=@UI" -Dbrowser=chrome
mvn clean verify -pl modules/ui-functional-test -Dbrowser=chrome

    //    long threadId = Thread.currentThread().getId();
    //    System.out.println(threadId + ": Thread----------");
    //    System.out.println("hello");'
    mvn checkstyle:checkstyle