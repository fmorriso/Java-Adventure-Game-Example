public class Main {
    public static void main(String[] args) {
        System.out.format("Adventure game using java %s%n", getJavaVersion());

        GameController gc = new GameController();
        gc.run();
    }


    /** Return the version of Java running the current program.
     * @return String containing the version of Java used to execute the program.
     */
    private static String getJavaVersion()
    {
        Runtime.Version runTimeVersion = Runtime.version();
        return String.format("%s.%s.%s.%s", runTimeVersion.feature(), runTimeVersion.interim(), runTimeVersion.update(), runTimeVersion.patch());
    }

}