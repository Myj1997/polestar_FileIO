package com.polestar.progressBar;

public class DecreaseThread implements Runnable {
    private INotification iNotification;

    public DecreaseThread(INotification iNotification){
        this.iNotification = iNotification;
    }


    @Override
    public void run() {
        System.out.println("DecreaseThread.run");
        if(iNotification != null){
            for(int i = 0; i < 100; i++ ){
                iNotification.decreaseNotificationCalled();
                System.out.println("하락하는중 " + i);

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
