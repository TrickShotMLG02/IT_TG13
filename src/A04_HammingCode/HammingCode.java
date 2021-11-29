package A04_HammingCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HammingCode {

    //public static String input = "00011010";
    public static String input = "000110101101010";
    public static List<Character> arr = new ArrayList<Character>();
    public static final int offset = 1;
    public static final Character PARITYBIT = 'X';
    public static int paritybitCount = 0;

    public static void main(String[] args)
    {
        System.out.println(calculateListLength(16));

        arr = populateList(arr);
        //Remove first index with value N
        arr = normalizeList(arr);
        //calculateParityBits(arr);
        arr = calculateParityBits(arr);

        //Print list
        Arrays.stream(arr.toArray()).forEach(System.out::print);
    }

    /**
     * Add binary input number to array and add parity bits in between
     * @param list
     * @return ArrayList of type Character
     */
    public static List<Character> populateList(List<Character> list)
    {
        int numPos = 0;
        list.add('N');
        //for (int i = 1; i < 12 + offset; i++)
        for (int i = 1; i < calculateListLength(input.length()) + offset; i++)
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

    /**
     * Calculate Paritybits and replace the placeholders
     * @param list
     * @return ArrayList populated with all calculated Paritybits
     */
    public static List<Character> calculateParityBits(List<Character> list)
    {
        int pos = 0;
        for (int i = 0; i < paritybitCount; i++) {
            int tmp = 0;
            int length = (int) Math.pow(2, i);
            for (int j = 0; j < list.size(); j += 2 * length) {
                for (int k = 0; k < length; k++) {
                    pos = j + length - 1 + k;
                    if (pos < list.size() && list.get(pos) == '1') {
                        tmp++;
                    }
                }
            }
            int ppos = (int) Math.pow(2, i);
            list.set(ppos - 1, Integer.toString((tmp % 2)).charAt(0));
            System.out.println("p" + i + " = " + (tmp % 2));
        }
        return list;
    }

    /**
     * Remove first index of List to normalize it
     * @param list
     * @return shortened list
     *
     */
    public static List<Character> normalizeList(List<Character> list)
    {
        list.remove(0);
        return list;
    }

    /**
     * Checks if the given value num is part of the exponential row with the base base
     * @param num
     * @param base
     * @return true if num is part of the exponential row
     */
    public static boolean isSequence(int num, int base)
    {
        for (int i = 0; i < input.length(); i++) {
            if (Math.pow(base, i) == num)
                return true;
        }
        return false;
    }

    public static int calculateListLength(int length)
    {
        // calculate log2 N indirectly
        // using log() method
        return (int)(Math.log(length) / Math.log(2)) + length + 1;
    }
}
