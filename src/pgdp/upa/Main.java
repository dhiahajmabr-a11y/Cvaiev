package pgdp.upa;

public class Main {
    // This file is for you to try out stuff while developing.
    // As long as it compiles, it has no effect on your grade.
    public static void main(String[] args) {
        sanityCheck();
        System.out.println("You can try out stuff here!");
    }

    public static void sanityCheck() {
        // DO NOT CHANGE THIS METHOD!
        // This method does not do anything meaningful.
        // It is just here to make sure you get a compilation error locally if
        // you change a method signature or class name incorrectly.
        // This will prevent you from making mistakes that would lead to compilation failures on tests!
        Cake c1 = new Cake("chocolate", 3);
        String f = c1.getFlavor();
        c1.setFlavor("banana");
        int i = c1.getNumberOfPieces();
        c1.setNumberOfPieces(5);
        i = c1.practicality();
        i = c1.waste(3);

        Bakery b = new Bakery(new Cake[]{c1});
        Cake[] cs = b.getCakes();
        Cake c2 = b.findMostPracticalCake();
        c2 = b.findCakeFor(3);
        c2 = b.findBetterCake(c1, c2, 3);

        SheetCake sc = new SheetCake(new int[][]{{1}});
        double d = sc.averageTastiness();
        int t = sc.tastinessAround(0, 0, 1);

    }
}
