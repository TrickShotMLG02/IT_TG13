package _Test;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        List<String> l = new ArrayList<String>();
        String[] arr = new String[10];

        l.forEach(System.out::println);
        Arrays.stream(arr).forEach(System.out::println);

        Arrays.stream(arr).sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        }).distinct().forEach(System.out::println);







        for (int i = 0; i == 0; i += 0)
            System.out.println("Hammer lässt grüssen xD");




    }

}
