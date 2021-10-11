package A02_Threads;

public class StartMyThread {

    public static void main(String[] args) {
        System.out.println("Mainthread running");

        /*
        MyThread a = new MyThread("a", 20);
        MyThread b = new MyThread("b", 20);

        a.start();
        b.start();
        */

        MyThreadInterface a = new MyThreadInterface("a", 20);
        MyThreadInterface b = new MyThreadInterface("b", 20);

        a.start();
        b.start();

        System.out.println("Mainthread ended");
    }

}
