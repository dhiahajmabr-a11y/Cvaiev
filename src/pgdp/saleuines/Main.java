package pgdp.saleuines;

public class Main {

    // Hier kannst Du ausprobieren, wie man mit `Penguin` arbeiten kann.
    // Solange die Datei kompiliert, hat sie keinen Einfluss auf die
    // Tests auf Artemis.
    public static void main(String[] args) {
        Penguin anton = new Penguin();
        anton.setCurrentMoney(1_000);

        Penguin giesela = new Penguin();
        giesela.store(new Stock(
                new Species("salmon", 7, 1),
                2, 3));

        anton.buy(giesela, "salmon", 0.5);

        System.out.println("Anton: " + anton);
        System.out.println("Giesela: " + giesela);
    }

}
