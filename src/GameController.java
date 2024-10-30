import java.util.Scanner;

public class GameController {
    private int health = 100;
    private Scanner input = new Scanner(System.in);

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void run() {
        System.out.println("Welcome to my Adventure game!");

        int num = 3; // RIGHT
        String val = Direction.getValueFromCorrespondingNumber(num);
        System.out.format("Direction number: %d = Direction %s%n", num, val);

        Direction nextDirection = getNewDirection();
        System.out.println("You chose " + nextDirection);
    }

    public static String getDisplayableDirectionValues(){
        String s = "";
        for (Direction d: Direction.values()) {
            s += d.toString() + "(" + d.getIndex() + "), ";
        }

        // trim off the trailing comma and extra space character
        int idx = s.lastIndexOf(",");
        s = s.substring(0, idx);
        return s;
    }

    /** Prompt user for a valid direction
     * @return a valid Direction enumerated value (see Direction.java)
     */
    public Direction getNewDirection() {
        Direction dir;
        // the following is an example of Python's while True:
        do {
            try {
                System.out.format("What direction [%s]?> ", getDisplayableDirectionValues());
                String response = input.nextLine();
                // if user gave us a number, try to convert it to its equivalent enum
                if (isANumber(response) ) {
                    int idx = Integer.parseInt(response);
                    dir = Direction.getDirectionFromNumber(idx);
                } else {
                    dir = Direction.valueOf(response.toUpperCase());
                }
                return dir;
            } catch (Exception ex) {
                System.out.format("Invalid direction!  Valid directions are %s%n", getDisplayableDirectionValues());
            }

        } while(true);
    }

    private boolean isANumber(String possibleWholeNumber) {
        try {
            Integer.parseInt(possibleWholeNumber);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
