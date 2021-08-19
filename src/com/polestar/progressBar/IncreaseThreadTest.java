package com.polestar.progressBar;

public class IncreaseThreadTest implements Runnable{
    private INotification notification;

    public IncreaseThreadTest(INotification notification) {
        this.notification = notification;
    }

    @Override
    public void run() {
        System.out.println("IncreaseThreadTest.run");
        if (notification != null) {
            for (int i=0; i < 10; i++) {
                notification.notificationCalled();
                System.out.println("상승 하는중 " + i);

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
