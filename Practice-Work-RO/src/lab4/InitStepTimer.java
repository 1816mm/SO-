package lab4;

import java.util.TimerTask;

public class InitStepTimer extends TimerTask {
    @Override
    public void run() {

        System.out.println("[Processing started ...]");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
