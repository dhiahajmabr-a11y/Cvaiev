package pgdp.upa;

public class Main {
    public static void main(String[] args) {
        System.out.println("Add stuff here to try out your code!");
        sanityCheck();
    }

    private static void sanityCheck() {
        // This method is to help you make sure, that your code compiles.
        // It runs all public methods of Penguin and Item to check if anything is wrong with the signatures.
        // If your code does not compile on artemis, you will not get any points!
        Penguin alice = new Penguin();
        Penguin bob = new Penguin();
        Item sword = new Item("Stick");
        sword.setPrice(10);

        bob.getStones();
        alice.findStones(5);
        bob.findItem(sword);
        alice.tradeWith(bob);
        alice.currentItemKind();
        bob.loseItem();
    }
}














