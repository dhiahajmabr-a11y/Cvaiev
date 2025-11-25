package pgdp.upa;

public class Cake {
    private String flavor;
    private int numberOfPieces;

    public Cake(String flavor, int numberOfPieces) {
        this.flavor = flavor;
        this.numberOfPieces = numberOfPieces;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public int getNumberOfPieces() {
        return numberOfPieces;
    }

    public void setNumberOfPieces(int numberOfPieces) {
        this.numberOfPieces = numberOfPieces;
    }

    public int practicality() {
        // Here is a wrong answer, but if you cannot solve this exercise,
        // you can use it to test other parts of your code.
        // Replace this with your own implementation to get the correct answer.
        int wrongAnswer = flavor.length();
        if (flavor == null ) {
           wrongAnswer = 0 ;
        }
         wrongAnswer = flavor.length() / 2 ;

        return wrongAnswer;

    }

    public int waste(int numberEaters) {
        // Here is a wrong answer, but if you cannot solve this exercise,
        // you can use it to test other parts of your code.
        // Replace this with your own implementation to get the correct answer.
        return numberOfPieces;
    }

    @Override
    public String toString() {
        return "Cake[" + "flavor=" + this.flavor + ", " + "pieces=" + this.numberOfPieces + "]";
    }
}
