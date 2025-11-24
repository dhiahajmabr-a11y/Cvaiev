package pgdp;
/**
 * Penguin objects can enter {@code PenguinBar}s - but only if they are old enough.
 */
public class Penguin {
    private final int age;

    public Penguin(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

}

// Skander