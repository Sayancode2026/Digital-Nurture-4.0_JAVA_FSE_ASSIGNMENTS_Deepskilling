public class SingletonPatternExample {

    private static class Logger {
        private static Logger instance;
        private Logger() {}
        public static synchronized Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }
        public void displayMesg(String message) {
            System.out.println("[LOG] " + message);
        }
    }
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        System.out.println("logger1 hashCode: " + logger1.hashCode());
        System.out.println("logger2 hashCode: " + logger2.hashCode());
        if (logger1 == logger2) {
            System.out.println("Only one Logger instance exists.");
        } else {
            System.out.println("Different instances exist! Singleton failed.");
        }
        logger1.displayMesg("This is a test message.");
    }
}