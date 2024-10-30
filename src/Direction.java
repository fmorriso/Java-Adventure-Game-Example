/**
 * An advanced enumeration in which each enumerated name as a specific whole number value.
 */
public enum Direction {
    LEFT (1),
    FORWARD (2),
    RIGHT (3);

    private Direction(final int index) {
        this.index = index;
    }

    private final int index;

    public int getIndex() {return index;}

    /**
     * @param i - a whole number that is the numeric value of one of the enumerations.
     * @return - String containing the name of the corresponding enumerations
     */
    public static String getValueFromCorrespondingNumber(int i){
        for(Direction d : Direction.values()){
            if(d.getIndex() == i){
                return d.name();
            }
        }
        return "** NOT FOUND **";
    }

    /** Look up an enumeration based on its corresponding numeric value
     * @param num - a number that equals one of the enumerated value's corresponding whole number value.
     * @return - a Direction enumerated value.
     */
    public static Direction getDirectionFromNumber(int num){
        return Direction.valueOf(getValueFromCorrespondingNumber(num));
    }
}
