import java.util.Scanner;

/**
 * The controller for this game.
 * All other objects communicate with each other via this centralized
 * controller, which decides which other object(s) to communicate with.
 */
public class GameController {
    private int health = 100;
    private final Scanner input = new Scanner(System.in);

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int run() {
        System.out.println("Welcome to my Adventure game!");

        int num = 3; // RIGHT
        String val = Direction.getValueFromCorrespondingNumber(num);
        System.out.format("Direction number: %d = Direction %s%n", num, val);

        Direction nextDirection = getNewDirection();
        System.out.println("You chose " + nextDirection);

        nextDirection = getNewDirectionFromAbbreviation();
        System.out.format("You chose %s%n", nextDirection);
        if (nextDirection.equals(Direction.QUIT)) {
            System.out.println("Thanks for playing");
            return 0;
        }
        return 1;
    }

    private Direction getNewDirectionFromAbbreviation() {
        Direction dir;
        // the following is a Java equivalent of Python's while True:
        do {
            try {
                System.out.format("What direction [%s]?> ", getDisplayableDirectionValues());
                String response = input.nextLine();
                // only care about the first character, which is hopefully l, L, r, R, F or f.
                dir = Direction.getDirectionFromAbbreviation(response.charAt(0));
                if (dir == null) {
                    throw new Exception("Invalid direction. Try again.");
                }
                return dir;
            } catch (Exception ex) {
                System.out.format("Invalid direction!  Valid directions are %s%n", getDisplayableDirectionValues());
            }

        } while(true);
    }

    public static String getDisplayableDirectionValues(){
        StringBuilder sbr = new StringBuilder();
        for (Direction d: Direction.values()) {
            sbr.append(d.toString())
               .append("(")
               .append(d.getIndex())
               .append("), ");
        }
        String s = sbr.toString();
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
        // the following is a Java equivalent of Python's while True:
        do {
            try {
                System.out.format("What direction [%s]?> ", getDisplayableDirectionValues());
                String response = input.nextLine();
                // if user gave us a number, try to convert it to its equivalent enum
                if (isANumber(response)) {
                    int idx = Integer.parseInt(response);
                    dir = Direction.getDirectionFromNumber(idx); // Math.sqrt(44);
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
