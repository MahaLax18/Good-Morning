class GoodMorningThread extends Thread {
    public void run() {
        while(true) {
            System.out.println("Good Morning");
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
        }
    }
}

class HelloThread extends Thread {
    public void run() {
        while(true) {
            System.out.println("Hello");
            try { Thread.sleep(2000); } catch (InterruptedException e) {}
        }
    }
}

class WelcomeThread extends Thread {
    public void run() {
        while(true) {
            System.out.println("Welcome");
            try { Thread.sleep(3000); } catch (InterruptedException e) {}
        }
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        new GoodMorningThread().start();
        new HelloThread().start();
        new WelcomeThread().start();
    }
}
