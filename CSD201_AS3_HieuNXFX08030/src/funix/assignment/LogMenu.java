package funix.assignment;

public class LogMenu {
    private static final String[] options = {
        "Choose one of this options:",
        "1. Insert a new Person.",
        "2. Inorder traverse.",
        "3. Breadth-First Traversal traverse",
        "4. Search by Person ID.",
        "5. Delete by Person ID.",
        "6. Balancing Binary Search Tree ",
        "7. DFS_Graph",
        "8. Dijkstra",
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
