package b1leben;

public class PenguLib {
    /** Returns a random choice between two options.
     *
     * @param option1 the first option
     * @param option2 the second option
     * @return a random choice between the two options
     */
    static String randomChoice(String option1, String option2) {
        return Math.random() < 0.5 ? option1 : option2;
    }

    public void useAllMethods() {
        // DO NOT TOUCH THIS METHOD
        //
        // IT DOES NOT DO ANYTHING USEFUL,
        // OR NECESSARILY CALL THE METHODS IN A REASONABLE WAY
        //
        // ITS ONLY PURPOSE IS TO PREVENT YOU FROM ACCIDENTALLY
        // REMOVING OR CHANGING THE METHOD SIGNATURES
        // THAT WOULD LEAD TO NON-COMPILATION OF YOUR CODE WITH THE TESTS
        //
        // IF THIS METHOD DOES NOT COMPILE, YOUR CODE WILL NOT COMPILE
        // WITH THE TESTS
        Penguin penguin1 = new Penguin();
        Penguin penguin2 = new Penguin();
        Egg egg = penguin1.mate(penguin2);
        Egg egg2 = new Egg();
        Penguin penguin3 = egg.hatch();
        penguin1.setFavouriteFish("fish");
        String favouriteFish = penguin1.getFavouriteFish();
        int id = penguin1.getId();
        boolean isParent = penguin1.isParentOf(penguin2);
        boolean isChild = penguin1.isChildOf(penguin2);
        boolean isSibling = penguin1.isSiblingOf(penguin2);
        boolean isGrandParent = penguin1.isGrandParentOf(penguin2);
        Huddle huddle = penguin1.getHuddle();
        int size = huddle.getSize();
        penguin1.joinHuddle();
        penguin1.leaveHuddle();
    }
}
