package lab4;

import java.util.Timer;
import java.util.TimerTask;

public class Print3D {

    StringBuilder result = new StringBuilder();
    String image;

    public Print3D(String image) {
        this.image = image;
    }


    public void init() {
        System.out.println("\n[Drawing...]\n");

        Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(image);
                    System.out.println(result);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }, 3000);
    }

}
