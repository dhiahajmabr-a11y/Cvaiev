package pgdp.saleuines;

public class Species {
    private String name;
    private int maxDaysTillSpoiled;
    private int pricePerGram;

    public Species(String name, int maxDaysTillSpoiled, int pricePerGram) {
        this.name = name;
        this.maxDaysTillSpoiled = maxDaysTillSpoiled;
        this.pricePerGram = pricePerGram;
    }

    public String getName() {
        return name;
    }

    public int getMaxDaysTillSpoiled() {
        return maxDaysTillSpoiled;
    }

    public int getPricePerGram() {
        return pricePerGram;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxDaysTillSpoiled(int maxDaysTillSpoiled) {
        this.maxDaysTillSpoiled = maxDaysTillSpoiled;
    }

    public void setPricePerGram(int pricePerGram) {
        this.pricePerGram = pricePerGram;
    }

    @Override
    public String toString() {
        return "Species{" +
                "name='" + name + '\'' +
                ", maxDaysTillSpoiled=" + maxDaysTillSpoiled +
                ", pricePerGram=" + pricePerGram +
                '}';
    }
}
