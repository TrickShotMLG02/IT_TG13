package A03_ThreadsGui;

import javax.swing.*;
import TrickShotAPI.userinterface.notifications;

public class MyThread extends Thread {

    private String name;
    private int wait;
    private int count = 0;



    public MyThread(String name, int wait)
    {
        this.name = name;
        this.wait = wait;
    }

    @Override
    public void run()
    {
        while (true)
        {
            if (this.isInterrupted())
                break;
            count += 1;
            GUI._Instance.lbl.setText("count: " + count);
            System.out.println(count);
            notifications.showText("SAS", "SAS");
            try {
                Thread.sleep(wait);
            } catch (InterruptedException e) {
                interrupt();
            }

        }
    }

    public int getWait() {
        return wait;
    }
    public void setWait(int wait)
    {
        this.wait = wait;
    }
    public int getCount() {
        return count;
    }
}
