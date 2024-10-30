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

    /** Return a string representation of one of the enumerated values based on a
     * corresponding numeric value.
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

    /** Look up the enumeration using a one-character abbreviation.
     * @param abbreviation - a single character that we expect to match the first
     *                     letter of one of the enumeration values.
     * @return - a value from this enumeration or null if not found.
     */
    public static Direction getDirectionFromAbbreviation(char abbreviation){
        for(Direction d : Direction.values()){
            if(d.name().charAt(0) == abbreviation){
                return d;
            }
        }
        return null;
    }
}
