package pgdp.upa;

public class Item {
    private String kind;
    private int price;

    private static int mostExpensivePrice = 0;

    public Item(String kind, int price) {
        this.kind = kind;
        setPrice(price);
    }

    public void setPrice(int price) {
        this.price = price;
        if (price > mostExpensivePrice) {
            mostExpensivePrice = price;
        }
    }

    public int getPrice() {
        return price;
    }

    public String getKind() {
        return kind;
    }

    public static int getMostExpensivePrice() {
        return mostExpensivePrice;
    }

    @Override
    public String toString() {
        return "Item " + kind + " costs " + price;
    }
}
