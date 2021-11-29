package A04_HammingCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HammingCode {

    static List<Character> arr = new ArrayList<Character>();
    static String input = "00011010";
    static final int offset = 1;
    static final Character PARITYBIT = 'X';
    static int paritybitCount = 0;

    public static void main(String[] args) {

        //Add P and numbers to list
        arr = populateList(arr);
        //Remove first index with value N
        arr = normalizeList(arr);


        //calculateParityBits(arr);
        arr = calculateParityBits(arr);



        //Print list
        //Arrays.stream(arr.toArray()).forEach(System.out::println);
    }

    public static List<Character> populateList(List<Character> list)
    {
        int numPos = 0;
        list.add('N');

        for (int i = 1; i < 12 + offset; i++)
        {
            if (isSequence(i, 2))
            {
                list.add(PARITYBIT);
                paritybitCount++;
            }
            else
            {
                list.add(input.charAt(numPos));
                numPos++;
            }
        }
        return list;
    }

    public static List<Character> calculateParityBits(List<Character> list)
    {
        int tmp = 0;
        int length = 0;
        int pos = 0;

        for (int i = 0; i < paritybitCount; i++) {

            tmp = 0;
            length = (int) Math.pow(2, i);

            for (int j = 0; j < list.size(); j += 2* length) {
                for (int k = 0; k < length; k++) {

                    pos = j + length - 1 + k;

                    //Try-Catch
                    if (pos < list.size() && list.get(pos) == '1')
                    {
                        tmp++;
                    }
                }
            }
            //write 0 / 1 into array parity
            {
                int ppos = (int) Math.pow(2, i);
                list.set(ppos-1, Integer.toString((tmp % 2)).charAt(0));
                System.out.println("p" + i + " = " + (tmp % 2));
            }

        }
        
        return list;
    }

    public static List<Character> normalizeList(List<Character> list)
    {
        list.remove(0);
        return list;
    }

    public static boolean isSequence(int num, int base)
    {
        for (int i = 0; i < input.length(); i++) {
            if (Math.pow(base, i) == num)
                return true;
        }
        return false;
    }
}
