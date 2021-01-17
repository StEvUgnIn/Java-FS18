package Greeting;

import java.lang.Thread;

public class GreetingThreadRunner {
    public static void main (String[] args) {
        Runnable r = new GreetingRunnable("Hello, world!");
        Thread t = new Thread(r);
        t.start();
    }
}
