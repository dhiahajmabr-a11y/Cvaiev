package pgdp.upa;

public class Penguin {

    private int stones = 0;
    private Item currentItem = null;

    public Penguin() {
    }

    public void findStones(int amount) {
        stones += amount;
    }

    public int getStones() {
        return stones;
    }

    public void findItem(Item item) {
        currentItem = item;
    }

    public boolean loseItem() {
        if (currentItem != null) {
            currentItem = null;
            return true;
        }
        return false;
    }

    public String currentItemKind() {
        if (currentItem == null) return null;
        return currentItem.getKind();
    }

    public boolean tradeWith(Penguin penguin) {
        boolean thisHasItem = this.currentItem != null;
        boolean otherHasItem = penguin.currentItem != null;

        if (thisHasItem == otherHasItem) {
            return false;
        }

        Penguin seller = thisHasItem ? this : penguin;
        Penguin buyer = thisHasItem ? penguin : this;

        Item itemForSale = seller.currentItem;

        int price = itemForSale.getPrice() + 1;

        if (buyer.stones < price) {
            return false;
        }

        buyer.stones -= price;
        seller.stones += price;

        itemForSale.setPrice(price);

        buyer.findItem(itemForSale);
        seller.loseItem();

        return true;
    }

    public int netWorth() {
        int worth = stones;
        if (currentItem != null) worth += currentItem.getPrice();
        return worth;
    }
}
