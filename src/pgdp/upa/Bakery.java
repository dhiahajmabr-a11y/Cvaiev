package pgdp.upa;

public class Bakery {

    private Cake[] cakes;

    public Bakery(Cake[] cakes) {
        this.cakes = cakes;
    }
    
    public Cake[] getCakes() {
        return cakes;
    }

    public void setCakes(Cake[] cakes) {
        this.cakes = cakes;
    }
    
    public Cake findMostPracticalCake() {
        Cake mostpractical = cakes[0] ;
      for (int i = 0 ; i < cakes.length ; i++) {
          if (cakes[i].practicality() > mostpractical.practicality())
              mostpractical = cakes[i] ;
      }
        return mostpractical;
    }

    public Cake findBetterCake(Cake option1, Cake option2, int numberOfEaters) {
        return null;

    }

    public Cake findCakeFor(int numberOfEaters) {
        return null;
    }

    

}
