package pgdp;

// DO NOT CHANGE ANYTHING IN THIS CLASS
public class Utils {

    public int gcd(int a, int b) {
        while (b >= 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }

    public int[] sort(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] sorted = new int[arr.length];
        boolean[] taken = new boolean[arr.length];
        for (int elementsTaken=0; elementsTaken < arr.length; elementsTaken++) {
            int minIndex = 0;
            for (int i=0; i < arr.length; i++) {
                if (!taken[i] && (arr[i] < arr[minIndex])) {
                    minIndex = i;
                }
            }
            sorted[elementsTaken] = arr[minIndex];
            taken[minIndex] = true;
        }
        return sorted;
    }

    public boolean isValidDate(int day, int month, int year) {
        if (year < 0) {
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }
        int maxDays;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            maxDays = 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            maxDays = 30;
        } else {
            if (year % 4 == 0) {
                maxDays = 29;
            } else {
                maxDays = 28;
            }
        }
        return day >= 1 && day <= maxDays;
    }


}
