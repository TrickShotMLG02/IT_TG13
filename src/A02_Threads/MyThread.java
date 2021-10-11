package A02_Threads;

public class MyThread extends Thread {

    private String name;
    private int wait;
    private int count = 100;

    public MyThread(String name, int wait)
    {
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

    public int getWait() {
        return wait;
    }

    public int getCount() {
        return count;
    }
}
