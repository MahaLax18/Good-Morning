class GoodMorningRunnable implements Runnable {
    public void run() {
        while(true) {
            System.out.println("Good Morning");
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
        }
    }
}

class HelloRunnable implements Runnable {
    public void run() {
        while(true) {
            System.out.println("Hello");
            try { Thread.sleep(2000); } catch (InterruptedException e) {}
        }
    }
}

class WelcomeRunnable implements Runnable {
    public void run() {
        while(true) {
            System.out.println("Welcome");
            try { Thread.sleep(3000); } catch (InterruptedException e) {}
        }
    }
}

public class ThreadExample2 {
    public static void main(String[] args) {
        new Thread(new GoodMorningRunnable()).start();
        new Thread(new HelloRunnable()).start();
        new Thread(new WelcomeRunnable()).start();
    }
}
