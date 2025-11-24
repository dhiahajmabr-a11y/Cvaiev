package pgdp;

/**
 * This is an example implementation for a penguin bar.
 * The methods may or may not be correct. Your tests should verify the correctness of these methods.
 * Note that this is just an example; do not assume that this exact implementation will be tested
 * or that this implementation is correct. Instead, your tests should cover various reasonable cases.
 * The real implementation is not known to you!
 */

public class PenguinBar {
    protected int currentNumberOfPenguins;
    protected boolean isOpen;

    protected static final int minimumAge = 5;
    protected static final int capacity = 10;
    protected static final int minimumAmountForParty = 3;
    protected static final String unwantedWord = "bear";

    protected String currentSong;

    public static void main(String[] args) {
        // You can use this main method for trying things out if needed
        // It has no effect on the grading as long as it compiles
        System.out.println("Hello, party penguins!");
    }

    public PenguinBar() {
        this.currentNumberOfPenguins = 0;
        this.isOpen = true;
    }

    public int getCurrentNumberOfPenguins() {
        return currentNumberOfPenguins;
    }

    public boolean isOpen() {
        return isOpen;
    }

    /**
     * Enters the penguin defined by the {@code Penguin} object into the bar.
     * {@code Penguin} contains a field with its age that you can access using {@code getAge()}
     * The method returns {@code true} when the penguin successfully entered the bar, otherwise {@code false}.
     */
    public boolean enterPenguin(Penguin penguin) {
        if (isOpen && currentNumberOfPenguins < capacity && penguin.getAge() >= minimumAge) {
            currentNumberOfPenguins++;
            return true;
        }
        return false;
    }

    /**
     * Remove 1 penguin from the bar. Returns {@code true} if successful and otherwise {@code false}
     */
    public boolean leavePenguin() {
        if (currentNumberOfPenguins > 0) {
            currentNumberOfPenguins--;
            if (currentNumberOfPenguins < minimumAmountForParty) {
                currentSong = null;
            }

            return true;
        }
        return false;
    }

    public void closeBar() {
        if (currentNumberOfPenguins == 0) {
            isOpen = false;
        }
        currentSong = null;
    }

    public void openBar() {
        isOpen = true;
    }

    public String getCurrentSong() {
        return currentSong;
    }

    /**
     * Start the Jukebox with the given song.
     */
    public void startJukebox(String song) {
        if (currentNumberOfPenguins < minimumAmountForParty) {
            return;
        }
        // Hint: Here is a mistake that your tests could catch!
        if (song.toLowerCase().contains(unwantedWord.toLowerCase())) {
            currentSong = null;
            return;
        }
        currentSong = song;
    }
}
