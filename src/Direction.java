public enum Direction {
    LEFT (1),
    FORWARD (2),
    RIGHT (3);

    private Direction(final int angle) {
        this.angle = angle;
    }

    private int angle;

    public int getAngle() {return angle;}


}
