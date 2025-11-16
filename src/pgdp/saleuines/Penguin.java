package pgdp.saleuines;

public class Penguin {
    private Stock backpack = null;
    private Stock stomachContent = null;
    private double totalWeightSold = 0;
    private int totalMoneyMade = 0;
    private int currentMoney = 0;

    private static final double DELTA = 0.001;
    private static final double MAX_DAYS_TILL_SPOILED = 100;

    public boolean buy(Penguin seller, String species, double desiredWeight) {
        Stock sellerStock = seller.findStock(species);
        if (sellerStock == null) { return false; }
        if (!canAccept(sellerStock)) { return false; }
        double weight = sellableWeight(desiredWeight, sellerStock, currentMoney);
        if (weight < DELTA) { return false; }
        int pricePerGram = sellerStock.getSpecies().getPricePerGram();
        int price = (int) weight * pricePerGram;
        sellerStock.setWeight(sellerStock.getWeight() - weight);
        seller.totalMoneyMade += price;
        seller.totalWeightSold += weight;
        seller.currentMoney += price;
        seller.filterStock();
        currentMoney -= price;
        store(new Stock(sellerStock.getSpecies(), weight, sellerStock.getAgeInDays()));
        return true;
    }

    public boolean store(Stock s) {
        s = filterEmptyOrSpoiled(s);
        if (s == null) {
            return false;
        }
        if (canMerge(backpack, s)) {
            mergeStocks(backpack, s.getWeight(), s.getAgeInDays());
            return true;
        } else if (canMerge(stomachContent, s)) {
            mergeStocks(stomachContent, s.getWeight(), s.getAgeInDays());
            return true;
        } else if (backpack == null) {
            backpack = new Stock(s.getSpecies(), s.getWeight(), s.getAgeInDays());
            return true;
        } else if (stomachContent == null) {
            stomachContent = new Stock(s.getSpecies(), s.getWeight(), s.getAgeInDays());
            return true;
        }
        return false;
    }

    public void removeStomachContent() {
        stomachContent = null;
    }

    public void removeBackpack() {
        backpack = null;
    }

    private void mergeStocks(Stock fromBuyer, double weight, int age) {
        fromBuyer.setSpecies(fromBuyer.getSpecies());
        fromBuyer.setWeight(fromBuyer.getWeight() + weight);
        fromBuyer.setAgeInDays(Math.min(fromBuyer.getAgeInDays(), age));
    }

    private double sellableWeight(double want, Stock have, int budget) {
        double maxCanAfford =
                (double) budget / have.getSpecies().getPricePerGram();
        return Math.min(Math.min(want, have.getWeight()), maxCanAfford);
    }

    private boolean canAccept(Stock stock) {
        return backpack == null
                || canMerge(backpack, stock)
                || stomachContent == null
                || canMerge(stomachContent, stock);
    }

    private boolean canMerge(Stock a, Stock b) {
        return a != null
                && b != null
                && a.getSpecies().getName().equals(b.getSpecies().getName())
                && a.getSpecies().getMaxDaysTillSpoiled() == b.getSpecies().getMaxDaysTillSpoiled();
    }

    private Stock findStock(String name) {
        if (backpack != null && name != null
                && name.equals(backpack.getSpecies().getName())) {
            return backpack;
        }
        if (stomachContent != null && name != null
                && name.equals(stomachContent.getSpecies().getName())) {
            return stomachContent;
        }
        return null;
    }

    public void nextDay() {
        if (backpack != null) {
            backpack.setAgeInDays(backpack.getAgeInDays() + 1);
        }
        if (stomachContent != null) {
            stomachContent.setAgeInDays(stomachContent.getAgeInDays() + 1);
        }
        filterStock();
    }

    private static int idCounter = 0;
    private int id = idCounter++;
    public int getId() {
        return id;
    }

    private Stock filterEmptyOrSpoiled(Stock s) {
        boolean badStock = s == null
                || s.getWeight() < DELTA
                || s.getAgeInDays() > s.getSpecies().getMaxDaysTillSpoiled()
                || s.getAgeInDays() > MAX_DAYS_TILL_SPOILED;
        if (badStock) {
            return null;
        } else {
            return s;
        }
    }

    private void filterStock() {
        backpack = filterEmptyOrSpoiled(backpack);
        stomachContent = filterEmptyOrSpoiled(stomachContent);
    }

    public Stock getBackpack() {
        return backpack;
    }

    public Stock getStomachContent() {
        return stomachContent;
    }

    public double getTotalWeightSold() {
        return totalWeightSold;
    }

    public double getCurrentWeight() {
        double weight = 0;
        if (backpack != null) {
            weight += backpack.getWeight();
        }
        if (stomachContent != null) {
            weight += stomachContent.getWeight();
        }
        return weight;
    }

    public int getTotalMoneyMade() {
        return totalMoneyMade;
    }

    public int getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(int currentMoney) {
        this.currentMoney = currentMoney;
    }

    @Override
    public String toString() {
        return "Penguin{" +
                "backpack=" + backpack +
                ", stomachContent=" + stomachContent +
                ", totalWeightSold=" + totalWeightSold +
                ", currentWeight=" + getCurrentWeight() +
                ", totalMoneyMade=" + totalMoneyMade +
                ", currentMoney=" + currentMoney +
                ", id=" + id +
                '}';
    }
}
