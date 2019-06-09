package puzzlers.puzzle27;

public class Solution {

    public static void main(String[] args) {
        if (args.length != 0) {
            int distance = 0;
            if ("int".equals(args[0])) distance = calculateForInt();
            if ("long".equals(args[0])) distance = calculateForLong();
            System.out.print(distance);
        }
    }

    private static int calculateForInt() {
        int distance = 0;
        for (int i = -1; i != 0; i <<= 1) {
            distance++;
        }
        return distance;
    }

    private static int calculateForLong() {
        int distance = 0;
        for (long i = -1; i != 0; i <<= 1) {
            distance++;
        }
        return distance;
    }
}