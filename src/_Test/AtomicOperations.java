package _Test;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicOperations {

    //Just some useless code for testing purposes
    

    public static AtomicInteger atomicInteger = new AtomicInteger(1_231_245);
    public static volatile AtomicInteger i = new AtomicInteger(Integer.MAX_VALUE);

    public static void main(String[] args) {
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.get());
        System.out.println("\n\n");


        //atomic volatile synchronized operation to prevent data-mismatches between multiple threads accessing one variable
        System.out.println(increment(i));
        System.out.println(i.get());
    }

    public static synchronized int increment(AtomicInteger aInt)
    {
        return aInt.getAndIncrement();
    }
}
