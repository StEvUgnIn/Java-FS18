package Greeting;

import java.time.LocalDateTime;

public class GreetingRunnable implements Runnable {
    public GreetingRunnable(String greeting) {
        this.greeting = greeting;
    }

    private String greeting;

    @Override
    public void run () {
        System.out.printf("%s %s", LocalDateTime.now(), greeting);
    }
}
