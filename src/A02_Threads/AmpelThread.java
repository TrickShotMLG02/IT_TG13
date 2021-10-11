package A02_Threads;

import java.util.ArrayList;
import java.util.List;

public class AmpelThread implements Runnable {

    String[] zs = {"rot", "rot-gelb", "grün", "gelb"};
    int[] time = {5,2,5,2};
    String name;
    int wait;
    Thread t;

    AmpelThread(String name, int wait)
    {
        t = new Thread(this);
        this.wait = wait;
        this.name = name;
    }

    @Override
    public void run() {
        while (true)
        {
            for (int i = 0; i < zs.length; i++) {
                System.out.println(name + ": " + zs[i]);
                try
                {
                    Thread.sleep(time[i] * wait);
                }
                catch (Exception e)
                {

                }
            }
        }
    }

    public void start()
    {
        t.start();
    }

    public void interrupt()
    {
        t.interrupt();
    }
}
