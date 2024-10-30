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

        // the following is an example of Python's while True:
        do {
            try {
                System.out.format("What direction [%s]?> ", getDisplayableDirectionValues());
                String response = input.nextLine();
                // if user gave us a number, try to convert it to its equivalent enum
                if (responseIsANumber(response) ) {
                    int idx = Integer.parseInt(response);
                    // Since direction numbers are 1-based, not zero-based, subtract 1 to the index
                    response = String.valueOf(Direction.values()[idx - 1]);
                }
                Direction dir = Direction.valueOf(response.toUpperCase());
                return dir;
            } catch (Exception ex) {
                System.out.format("Invalid direction!  Valid directions are %s%n", getDisplayableDirectionValues());
            }

        } while(true);
    }

    private boolean responseIsANumber(String response) {
        try {
            Integer.parseInt(response);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
