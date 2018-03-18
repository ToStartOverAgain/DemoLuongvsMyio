package demo;

public class DemoThread {

    public static void main(String[] args) throws InterruptedException {

        Account acc = new Account();
        acc.setBalance(0);

        Thread guitien = new Thread() {
            @Override
            public synchronized void run() {
                try {
                    sleep(5 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                acc.deposit(20000);
                notifyAll();
                System.out.println(this.getName() + " - deposit success.");
            }
        };

        Thread ruttien1 = new Thread() {
            @Override
            public void run() {
                while (!acc.withdraw(7000)) {
                    System.out.println(this.getName() + " - withdraw fails.");
                    try {
                        sleep(2 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(this.getName() + " - withdraw success.");
                System.out.println(this.getName() + " - account balance: " + acc.getBalance());
            }
        };

        Thread ruttien2 = new Thread() {
            @Override
            public void run() {
                while (!acc.withdraw(7000)) {
                    System.out.println(this.getName() + " - withdraw fails.");
                    try {
                        sleep(2 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(this.getName() + " - withdraw success.");
                System.out.println(this.getName() + " - account balance: " + acc.getBalance());
            }
        };
        ruttien1.setName("Rút tiền 1");
        ruttien2.setName("Rút tiền 2");
        guitien.setName("Gửi tiền");
        ruttien1.start();
        ruttien2.start();
        guitien.start();

        ruttien1.join();
        ruttien2.join();
        guitien.join();

        System.out.println(acc.getBalance());
    }

}
