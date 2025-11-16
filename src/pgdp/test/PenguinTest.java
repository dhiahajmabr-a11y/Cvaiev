package pgdp.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pgdp.saleuines.Penguin;
import pgdp.saleuines.Species;
import pgdp.saleuines.Stock;

import static org.junit.jupiter.api.Assertions.*;

public class PenguinTest {

    public Penguin newPenguin() {
        return new Penguin();
    }
    //fsdhuifghoer

    private Species salmon;
    private Species trout;

    @BeforeEach
    void setUp() {
        salmon = new Species("Salmon", 10, 5);
        trout = new Species("Trout", 20, 3);
    }

    private Stock stock(Species s, double w, int a) {
        return new Stock(s, w, a);
    }

    @Test
    void sellerBookkeepingSingleSale() {
        Penguin buyer = newPenguin();
        Penguin seller = newPenguin();
        seller.store(stock(salmon, 100.0, 0));
        int m = seller.getCurrentMoney();
        double w = seller.getCurrentWeight();
        boolean r = buyer.buy(seller, "Salmon", 40.0);
        assertTrue(r);
        assertEquals(40.0, seller.getTotalWeightSold(), 1e-6);
        assertEquals(seller.getCurrentMoney() - m, seller.getTotalMoneyMade());
        assertEquals(w - 40.0, seller.getCurrentWeight(), 1e-6);
    }

    @Test
    void sellerBookkeepingMultipleSalesAndNoChangeWhenBuying() {
        Penguin a = newPenguin();
        Penguin b = newPenguin();
        Penguin c = newPenguin();
        b.store(stock(trout, 100.0, 0));
        a.buy(b, "Trout", 30.0);
        double s1 = b.getTotalWeightSold();
        int m1 = b.getTotalMoneyMade();
        c.buy(b, "Trout", 20.0);
        assertEquals(50.0, b.getTotalWeightSold(), 1e-6);
        assertTrue(b.getTotalMoneyMade() > m1);
        b.buy(a, "Trout", 5.0);
        assertEquals(50.0, b.getTotalWeightSold(), 1e-6);
    }

    @Test
    void buyerBookkeepingAfterBuy() {
        Penguin buyer = newPenguin();
        Penguin seller = newPenguin();
        seller.store(stock(salmon, 80.0, 0));
        int m = buyer.getCurrentMoney();
        double w = buyer.getCurrentWeight();
        int tm = buyer.getTotalMoneyMade();
        double tw = buyer.getTotalWeightSold();
        boolean r = buyer.buy(seller, "Salmon", 30.0);
        assertTrue(r);
        assertEquals(w + 30.0, buyer.getCurrentWeight(), 1e-6);
        assertTrue(buyer.getCurrentMoney() < m);
        assertEquals(tm, buyer.getTotalMoneyMade());
        assertEquals(tw, buyer.getTotalWeightSold(), 1e-6);
    }

    @Test
    void mergeStocksKeepsMaxAgeAndSpeciesOnStore() {
        Penguin p = newPenguin();
        p.store(stock(salmon, 60.0, 7));
        p.store(stock(salmon, 40.0, 2));
        Stock b = p.getBackpack();
        assertNotNull(b);
        assertEquals(100.0, b.getWeight(), 1e-6);
        assertEquals(7, b.getAgeInDays());
        assertEquals("Salmon", b.getSpecies().getName());
        assertEquals(10, b.getSpecies().getMaxDaysTillSpoiled());
    }

    @Test
    void mergeStocksOnBuyIntoExistingBuyerStock() {
        Penguin buyer = newPenguin();
        Penguin seller = newPenguin();
        buyer.store(stock(salmon, 30.0, 5));
        seller.store(stock(salmon, 50.0, 2));
        boolean r = buyer.buy(seller, "Salmon", 40.0);
        assertTrue(r);
        Stock b = buyer.getBackpack();
        assertNotNull(b);
        assertTrue(b.getWeight() >= 70.0 - 1e-6);
        assertEquals(5, b.getAgeInDays());
        assertEquals("Salmon", b.getSpecies().getName());
    }

    @Test
    void mergingNeverChangesSpeciesNameOrSpoilDays() {
        Species h1 = new Species("Herring", 5, 1);
        Species h2 = new Species("Herring", 5, 100);
        Penguin buyer = newPenguin();
        Penguin seller = newPenguin();
        buyer.store(stock(h1, 20.0, 1));
        seller.store(stock(h2, 30.0, 2));
        buyer.buy(seller, "Herring", 10.0);
        assertEquals("Herring", h1.getName());
        assertEquals(5, h1.getMaxDaysTillSpoiled());
        assertEquals("Herring", h2.getName());
        assertEquals(5, h2.getMaxDaysTillSpoiled());
    }

    @Test
    void sellerReducesCorrectStockAndKeepsOtherSpecies() {
        Penguin buyer = newPenguin();
        Penguin seller = newPenguin();
        seller.store(stock(salmon, 70.0, 0));
        seller.store(stock(trout, 50.0, 0));
        boolean r = buyer.buy(seller, "Trout", 20.0);
        assertTrue(r);
        Stock s = seller.getStomachContent();
        assertNotNull(s);
        assertEquals("Trout", s.getSpecies().getName());
        assertEquals(30.0, s.getWeight(), 1e-6);
        Stock b = seller.getBackpack();
        assertNotNull(b);
        assertEquals("Salmon", b.getSpecies().getName());
        assertEquals(70.0, b.getWeight(), 1e-6);
    }

    @Test
    void sellerDoesNotSellWrongSpecies() {
        Penguin buyer = newPenguin();
        Penguin seller = newPenguin();
        seller.store(stock(salmon, 100.0, 0));
        boolean r = buyer.buy(seller, "Trout", 30.0);
        assertFalse(r);
        assertEquals(0.0, buyer.getCurrentWeight(), 1e-6);
        assertEquals(100.0, seller.getCurrentWeight(), 1e-6);
    }

    @Test
    void buyReturnsFalseIfNoMatchingSpecies() {
        Penguin buyer = newPenguin();
        Penguin seller = newPenguin();
        seller.store(stock(salmon, 50.0, 0));
        boolean r = buyer.buy(seller, "Trout", 10.0);
        assertFalse(r);
    }

    @Test
    void buyReturnsTrueOnPartialSaleIfSellerHasTooLittleFish() {
        Penguin buyer = newPenguin();
        Penguin seller = newPenguin();
        seller.store(stock(salmon, 20.0, 0));
        boolean r = buyer.buy(seller, "Salmon", 50.0);
        assertTrue(r);
        assertEquals(0.0, seller.getCurrentWeight(), 1e-6);
        assertEquals(20.0, buyer.getCurrentWeight(), 1e-6);
    }

    @Test
    void buyReturnsTrueOnPartialSaleIfBuyerHasTooLittleMoney() {
        Penguin buyer = newPenguin();
        Penguin seller = newPenguin();
        Penguin donor = newPenguin();
        donor.store(stock(trout, 100.0, 0));
        buyer.buy(donor, "Trout", 50.0);
        seller.store(stock(trout, 1000.0, 0));
        boolean r = buyer.buy(seller, "Trout", 1000.0);
        assertTrue(r);
        assertTrue(buyer.getCurrentWeight() > 0.0);
        assertTrue(buyer.getCurrentWeight() < 1000.0);
    }

    @Test
    void priceIsRoundedInFavorOfCustomer() {
        Penguin buyer = newPenguin();
        Penguin seller = newPenguin();
        Species c = new Species("Caviar", 30, 10);
        seller.store(stock(c, 2.0, 0));
        Penguin donor = newPenguin();
        donor.store(stock(c, 5.0, 0));
        buyer.buy(donor, "Caviar", 2.0);
        int mb = buyer.getCurrentMoney();
        int ms = seller.getCurrentMoney();
        boolean r = buyer.buy(seller, "Caviar", 1.9999);
        assertTrue(r);
        int d1 = mb - buyer.getCurrentMoney();
        int d2 = seller.getCurrentMoney() - ms;
        assertEquals(d1, d2);
        assertTrue(d1 <= 19);
    }

    @Test
    void nextDayRemovesOnlySpoiledStockAndKeepsFresh() {
        Penguin p = newPenguin();
        p.store(stock(salmon, 40.0, 10));
        p.store(stock(trout, 60.0, 19));
        p.nextDay();
        Stock b = p.getBackpack();
        Stock s = p.getStomachContent();
        if (b != null && "Salmon".equals(b.getSpecies().getName())) fail();
        if (s != null && "Salmon".equals(s.getSpecies().getName())) fail();
        if (b != null && "Trout".equals(b.getSpecies().getName())) assertEquals(20, b.getAgeInDays());
        if (s != null && "Trout".equals(s.getSpecies().getName())) assertEquals(20, s.getAgeInDays());
    }

    @Test
    void nextDayRemovesStocksOlderThanHundredDays() {
        Penguin p = newPenguin();
        p.store(stock(trout, 30.0, 100));
        p.nextDay();
        assertNull(p.getBackpack());
        assertNull(p.getStomachContent());
        assertEquals(0.0, p.getCurrentWeight(), 1e-6);
    }


}

















