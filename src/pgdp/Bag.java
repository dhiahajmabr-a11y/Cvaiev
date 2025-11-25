package pgdp;

// DO NOT CHANGE ANYTHING IN THIS CLASS
public class Bag {
    private int[] items;
    private int size;

    public Bag() {
        items = new int[3];
        size = 0;
    }

    public boolean add(int item) {
        if (size < items.length) {
            items[size] = item;
            return true;
        } else {
            return false;
        }
    }

    public boolean contains(int item) {
        for (int i = 0; i < size; i++) {
            if (items[i] == item) {
                return true;
            }
        }
        return false;
    }

    public boolean remove(int item) {
        for (int i = 0; i < size; i++) {
            if (items[i] == item) {
                items[i] = items[size - 1]; // Replace with last item
                size--;
                return true;
            }
        }
        return false;
    }
}
