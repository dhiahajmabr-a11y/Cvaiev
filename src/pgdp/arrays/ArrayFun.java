package pgdp.arrays;

import org.w3c.dom.ls.LSOutput;

public class ArrayFun {
    public static void print(int[] a) {
        // TODO
        if (a.length == 0 ) {
            System.out.println("{}");
        return ; }
        System.out.print("{");
        for (int i = 0; i < a.length-1; i++) {
            System.out.print(a[i]+ ", ");
        }
        System.out.print(a[a.length-1] + "}");
    }

    public static void minAndMax(int[] a) {
        // TODO
        if (a.length == 0 ) {
            return ;
        }
        int Minimum = a[0];
        int Maximum = a[0];
        for (int i = 0 ; i < a.length ; i++) {
            if (a[i] < Minimum) Minimum = a[i];
            if (a[i] > Maximum) Maximum = a[i];
        }
        System.out.println("Minimum = " + Minimum + ", Maximum = " + Maximum);
    }

    public static int[] invert(int[] a) {
        // TODO
        if (a.length == 0) return a;
        int [] result = new int[a.length];
        int x = 0;
        for (int i = a.length-1 ; i >= 0 ; i--) {
            result[x] = a[i];
            x++ ;
        }
        return result;
    }

    public static int[] cut(int[] a, int length) {
        // TODO
        if (length <= 0 ) return new int[0];
        int [] result = new int[length];
        int toCopy = Math.min(a.length, length);
        for (int i = 0 ; i < toCopy ; i++) {
            result[i] = a[i];
        }
        return result;
    }

    public static int[] linearize(int[][] a) {
        // TODO
        int len = 0 ;
        for (int i = 0; i < a.length; i++) {
            len+= a[i].length ;
        }
        int [] result = new int[len];
        int x= 0 ;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length ; j++) {
                result[x] = a[i][j];
                x++;
            }
        }
        return result;
    }
}
