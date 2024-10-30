public enum Direction {
    LEFT (1),
    FORWARD (2),
    RIGHT (3);

    private Direction(final int index) {
        this.index = index;
    }

    private final int index;

    public int getIndex() {return index;}


}
