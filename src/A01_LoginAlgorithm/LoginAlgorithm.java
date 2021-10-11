package A01_LoginAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginAlgorithm {

    public static int requiredSum = 380;
    public static int minValue = 48;
    public static int maxSum = 488;
    public static int inputLength = 4;

    /*
    NOT WORKING
     public static void main(String[] args) {

        int count = 30;
        int i = 0;
        while (i < count) {

            String key = keyGenerator(requiredSum);
            if (!keys.contains(key)) {
                keys.add(key);
            }
            System.out.println("Key: " + keys.get(i));
            System.out.println("Sum: " + sum(keys.get(i) + " login success? " + login(sum(keys.get(i))) + "\n\n"));
            i++;
        }
     */

    public static void main(String[] args) {

        String[] keys = new String[10];

        for (int i = 0; i < keys.length; i++) {
            keys[i] = keyGenerator(requiredSum);
            System.out.println("Sum: " + sum(keys[i]) + " login success? " + login(sum(keys[i])) + "\n\n");
        }

        /*
        while(true)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Bitte geben sie ihren Code ein: ");
            String input = sc.next();

            System.out.println("Sum: " + sum(input) + " login success? " + login(sum(input)) + "\n\n");
        }

         */
    }

    public static int sum(int num)
    {
        int sum = 0;

        if (Integer.toString(num).length() != inputLength) {
            System.out.println("Key consists of 4 characters. You entered " + Integer.toString(num).length());
            return -1;
        }
        for (int i = 0; i < Integer.toString(num).length(); i++) {
            sum += Integer.parseInt(Integer.toString(num).substring(i, i + 1));
        }

        return sum;

    }

    public static int sum(String input)
    {
        int sum = 0;

        char[] chars = input.toCharArray();

        if (input.length() != inputLength) {
            System.out.println("Key consists of 4 characters. You entered " + input.length());
            return -1;
        }
        for (int i = 0; i < input.length(); i++) {
            sum += chars[i];
        }

        return sum;
    }

    public static boolean login(int sum)
    {
        return (sum == requiredSum);
    }



    public static String keyGenerator(int sum)
    {
        //char[] chars = {'0','1','2','3','4','5','6','7','8','9','A','a','B','b','C','c','D','d','E','e','F','f','G','g','H','h','I','i','J','j','K','k','L','l','M','m','N','n','O','o','P','p','Q','q','R','r','S','s','T','t','U','u','V','v','W','w','X','x','Y','y','Z','z'};
        //48-122 ASCII

        int i = inputLength;
        String key = "";
        while (i > 1)
        {
            char c = (char)randomInt(48, 122);
            if (sum - c >= 48 * (i - 3))
            {
                i--;
                sum -= c;
                key += c;
            }
        }
        key += (char) sum;
        System.out.println(key);
        return key;
    }

    public static int randomInt(int min, int max)
    {
        int rnd = (int) (Math.random() * (max - min)) + (min);
        return rnd;
    }

}