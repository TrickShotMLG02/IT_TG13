package A02_Threads;

public class MyThreadInterface implements Runnable {

    private String name;
    private int wait;
    private int count = 100;
    private Thread t;

    public MyThreadInterface(String name, int wait)
    {
        t = new Thread(this);
        this.name = name;
        this.wait = wait;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < count; i++) {
            System.out.println(name + ": " + i);
            try {
                Thread.sleep(wait);
            }
            catch (Exception e)
            {
                System.out.println(e.getStackTrace());
            }
        }
    }

    public void start()
    {
        t.start();
    }

    public int getWait() {
        return wait;
    }

    public int getCount() {
        return count;
    }

    public Thread getThread() { return t; }
}
