package pgdp.upa;

public class SheetCake {
    private int tastiness[][];

    public SheetCake(int[][] tastiness) {
        this.tastiness = tastiness;
    }

    public double averageTastiness() {
        return 0.0;
    }

    public int tastinessAround(int x, int y, int size) {
        return 0;
    }

    // Helper methods
    private int width() {
        return tastiness.length;
    }

    private int height() {
        return tastiness[0].length;
    }

    private int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    private int min(int a, int b) {
        if (a < b) {
            return a;
        }
        return b;
    }
}
