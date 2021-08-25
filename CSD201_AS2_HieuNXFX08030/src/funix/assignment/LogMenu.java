package funix.assignment;

public class LogMenu {
    private static final String[] options = {
        "Choose one of this options:",
        "1. Load data from file and display",
        "2. Input & add to the end.",
        "3. Display data",
        "4. Save product list to file.",
        "5. Search by ID",
        "6. Delete by ID",
        "7. Sort by ID.",
        "8. Convert to Binary",
        "9. Load to stack and display",
        "10. Load to queue and display.",
        "0. Exit"
    };
    static void logMenuOptions() {
        for (String option : options) {
            System.out.println(option);
        }
    }

    static void createShortBreakLine() {
        System.out.println("---------------");
    }

    static void createBreakLine() {
        System.out.println("==================================");
    }

    static void log(String text) {
        System.out.println(text);
    }

}
