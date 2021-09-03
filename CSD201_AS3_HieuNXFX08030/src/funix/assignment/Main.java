package funix.assignment;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int selectOption = 1;
        String id, name, birthPlace, dob;
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        /* Pre-defined some people */
        binarySearchTree.insert(new Person("3", "Hieu", "Hanoi", "22/06/1994"));
        binarySearchTree.insert(new Person("5", "Duc", "Hanoi", "11/06/1991"));
        binarySearchTree.insert(new Person("7", "Quan", "Hanoi", "05/06/1989"));
        binarySearchTree.insert(new Person("8", "test8", "Hanoi", "05/06/1989"));
        binarySearchTree.insert(new Person("9", "test9", "Hanoi", "05/06/1989"));

        /* Khởi tạo graph với trọng số như đề bài */
        WeightedGraph graph = new WeightedGraph(7);

        /* Các cạnh đi từ đỉnh A */
        graph.setEdge(graph.getMapStringToIndex().get('A'), graph.getMapStringToIndex().get('B'), 10);
        graph.setEdge(graph.getMapStringToIndex().get('A'), graph.getMapStringToIndex().get('G'), 8);

        /* Các cạnh đi từ đỉnh B */
        graph.setEdge(graph.getMapStringToIndex().get('B'), graph.getMapStringToIndex().get('C'), 2);
        graph.setEdge(graph.getMapStringToIndex().get('B'), graph.getMapStringToIndex().get('D'), 10);
        graph.setEdge(graph.getMapStringToIndex().get('B'), graph.getMapStringToIndex().get('E'), 25);
        graph.setEdge(graph.getMapStringToIndex().get('B'), graph.getMapStringToIndex().get('F'), 80);

        /* Các cạnh đi từ đỉnh C */
        graph.setEdge(graph.getMapStringToIndex().get('C'), graph.getMapStringToIndex().get('A'), 30);
        graph.setEdge(graph.getMapStringToIndex().get('C'), graph.getMapStringToIndex().get('D'), 8);
        graph.setEdge(graph.getMapStringToIndex().get('C'), graph.getMapStringToIndex().get('E'), 3);
        graph.setEdge(graph.getMapStringToIndex().get('C'), graph.getMapStringToIndex().get('F'), 20);

        /* Các cạnh đi từ đỉnh D */
        graph.setEdge(graph.getMapStringToIndex().get('D'), graph.getMapStringToIndex().get('A'), 20);
        graph.setEdge(graph.getMapStringToIndex().get('D'), graph.getMapStringToIndex().get('F'), 5);
        graph.setEdge(graph.getMapStringToIndex().get('D'), graph.getMapStringToIndex().get('G'), 10);

        /* Các cạnh đi từ đỉnh E */
        graph.setEdge(graph.getMapStringToIndex().get('E'), graph.getMapStringToIndex().get('D'), 4);

        /* Các cạnh đi từ đỉnh F */
        graph.setEdge(graph.getMapStringToIndex().get('F'), graph.getMapStringToIndex().get('A'), 8);
        graph.setEdge(graph.getMapStringToIndex().get('F'), graph.getMapStringToIndex().get('G'), 5);

        /* Các cạnh đi từ đỉnh G */
        graph.setEdge(graph.getMapStringToIndex().get('G'), graph.getMapStringToIndex().get('A'), 8);
        graph.setEdge(graph.getMapStringToIndex().get('G'), graph.getMapStringToIndex().get('D'), 10);
        graph.setEdge(graph.getMapStringToIndex().get('G'), graph.getMapStringToIndex().get('F'), 5);

        while (selectOption != 0) {
            Scanner sc = new Scanner(System.in);
            LogMenu.createBreakLine();
            LogMenu.logMenuOptions();
            LogMenu.log("Your choice: ");
            selectOption = sc.nextInt();
            sc.nextLine();
            if (selectOption == 0) {
                LogMenu.log("Bye");
            } else {
                switch (selectOption) {
                    case 1 -> {
                        LogMenu.log("Choice 1: Insert a new Person.");
                        LogMenu.log("Please input the ID: ");
                        id = sc.nextLine();
                        LogMenu.log("Please input the name of new person: ");
                        name = sc.nextLine();
                        LogMenu.log("Please input the birthplace: ");
                        birthPlace = sc.nextLine();
                        LogMenu.log("Please input the birthday (dd/mm/yyyy): ");
                        dob = sc.nextLine();
                        Person newPerson = new Person(id, name, birthPlace, dob);
                        binarySearchTree.insert(newPerson);
                        LogMenu.log("Successfully");
                    }
                    case 2 -> {
                        LogMenu.log("Choice 2: Inorder traverse");
                        binarySearchTree.length();
                        LogMenu.log("Total of people: " + binarySearchTree.getTotal());
                        binarySearchTree.traversalInOrder();
                        LogMenu.log("Successfully");
                    }
                    case 3 -> {
                        LogMenu.log("Choice 3: Breadth-First Traversal traverse");
                        binarySearchTree.breadthFirstTraversal();
                        LogMenu.log("Successfully");
                    }
                    case 4 -> {
                        LogMenu.log("Choice 4: Search by Person ID.");
                        LogMenu.log("Please input the ID you want to search: ");
                        id = sc.nextLine();
                        TreeNode treeNode = binarySearchTree.find(id);
                        if (treeNode == null) {
                            LogMenu.log("Couldn't find the person with id " + id);
                        } else LogMenu.log("Found person: " + treeNode.getPerson().toString());
                        LogMenu.log("Successfully");
                    }
                    case 5 -> {
                        LogMenu.log("Choice 5: Delete by Person ID.");
                        LogMenu.log("Please input the ID of the person you want to delete:  ");
                        id = sc.nextLine();
                        binarySearchTree.delete(id);
                        LogMenu.log("Successfully");
                    }
                    case 6 -> {
                        LogMenu.log("Choice 6: Balancing Binary Search Tree.");
                        LogMenu.log("This is how the binary search tree looked before balancing");
                        binarySearchTree.traversalPreOrder();
                        LogMenu.log("This is how the binary search tree looked after balancing:");
                        binarySearchTree.buildTree(binarySearchTree.getRoot());
                        LogMenu.log("New root node of balanced tree: " + binarySearchTree.getRoot().getPerson());
                        binarySearchTree.traversalPreOrder();
                        LogMenu.log("Successfully");
                    }
                    case 7 -> {
                        LogMenu.log("Choice 7: DFS_Graph.");
                        LogMenu.log("Depth First Traversal start from A");
                        /* Khởi tạo một array với các value FALSE để đánh dấu các đỉnh đã đi qua */
                        Boolean[] visitedArray = new Boolean[graph.getNumberOfVertices()];
                        Arrays.fill(visitedArray, Boolean.FALSE);

                        /* Thực hiện duyệt đồ thị theo chiều sâu, bắt đầu từ đỉnh A */
                        graph.depthFirstTraversal(graph.getMapStringToIndex().get('A'), new Stack(graph.getNumberOfVertices()), visitedArray);

                        LogMenu.log("");
                        LogMenu.log("Successfully");
                    }
                    case 8 -> {
                        LogMenu.log("Choice 8: Dijkstra.");
                        LogMenu.log("The shortest way from A to E is: ");
                        graph.dijkstra('A', 'E');
                        LogMenu.log("");
                        LogMenu.log("Successfully");
                    }
                    default -> LogMenu.log("Please enter a number with range from 0 to 8");

                }
            }
        }
    }
}
