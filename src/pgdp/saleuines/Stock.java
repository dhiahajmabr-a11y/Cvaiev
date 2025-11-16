package pgdp.saleuines;

public class Stock {
    private Species species;
    private double weight;
    private int ageInDays;

    public Stock(Species species, double weight, int ageInDays) {
        this.species = species;
        this.weight = weight;
        this.ageInDays = ageInDays;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAgeInDays() {
        return ageInDays;
    }

    public void setAgeInDays(int ageInDays) {
        this.ageInDays = ageInDays;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "species=" + species +
                ", weight=" + weight +
                ", daysLeftTillSpoiled=" + ageInDays +
                '}';
    }
}
