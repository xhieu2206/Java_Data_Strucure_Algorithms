package funix.assignment;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        int selectOption = 1;
        String id, name;
        int price, quantity;
        while (selectOption != 0) {
            Scanner sc = new Scanner(System.in);
            LinkedList products = FileTask.readProductsFromFile(FileTask.DATA);
            /*
                Đọc các products đọc từ file `DATA.txt` và gán vào Linked List `products`
             */
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
                        LogMenu.log("Choice: 1");
                        LogMenu.log("Load data from file `DATA.txt` and display the product list");
                        Algorithm.logLinkedList(products);
                        LogMenu.log("Successfully");
                    }
                    case 2 -> {
                        LogMenu.log("Choice: 2");
                        LogMenu.log("Input and Add a new Product to the end");
                        LogMenu.log("Please input the ID: ");
                        id = sc.nextLine();
                        LogMenu.log("Please input the product's name: ");
                        name = sc.nextLine();
                        LogMenu.log("Please input the product's quantity: ");
                        quantity = sc.nextInt();
                        LogMenu.log("Please input the product's price: ");
                        price = sc.nextInt();
                        sc.nextLine();
                        products.insertAtTail(new Product(id, name, quantity, price));
                        /*
                            Lấy ra tail của products list và thêm vào file.
                         */
                        FileTask.appendToFile(FileTask.DATA, Algorithm.getTail(products).getData().toString());
                        LogMenu.log("The new product was saved to the " + FileTask.DATA + " file.");
                        FileTask.writeProductsToFle(FileTask.OUTPUT, products);
                        LogMenu.log("The new product was saved to the " + FileTask.OUTPUT + " file.");
                        LogMenu.log("Successfully");
                    }
                    case 3 -> {
                        LogMenu.log("Choice: 3");
                        LogMenu.log("Display Data");
                        LogMenu.log("Number of products: " + products.length());
                        Algorithm.logLinkedList(products);
                        LogMenu.log("Successfully");
                    }
                    case 4 -> {
                        LogMenu.log("Choice: 4");
                        LogMenu.log("Save product list to file " + FileTask.OUTPUT);
                        FileTask.writeProductsToFle(FileTask.OUTPUT, products);
                        FileTask.writeProductsToFle(FileTask.DATA, products);
                        LogMenu.log("Current product list has been wrote to file " + FileTask.OUTPUT + "and file " + FileTask.DATA + " successfully, please check for this file for detail");
                        LogMenu.log("Successfully");
                    }
                    case 5 -> {
                        LogMenu.log("Choice: 5");
                        LogMenu.log("Search by ID");
                        LogMenu.log("Please input the ID you want for searching: ");
                        id = sc.nextLine();
                        Node result = products.findById(id);
                        if (result == null) {
                            LogMenu.log("There isn't product with ID " + id);
                        } else {
                            LogMenu.log("Result: " + result.getData().toString());
                        }
                        LogMenu.log("Successfully");
                    }
                    case 6 -> {
                        LogMenu.log("Choice: 6");
                        LogMenu.log("Delete by ID");
                        LogMenu.log("Please input the ID of the product want for deleting: ");
                        id = sc.nextLine();
                        products.deleteById(id);
                        /*
                            Listing lại product list ra file `Data.txt` sau khi đã xóa phần tử, file `OUTPUT.txt` sẽ vẫn được giữ nguyên.
                         */
                        FileTask.writeProductsToFle(FileTask.DATA, products);
                        LogMenu.log("Please re-check file " + FileTask.DATA + " for the product list after deleting the product");
                        LogMenu.log("Successfully");
                    }
                    case 7 -> {
                        LogMenu.log("Choice: 7");
                        LogMenu.log("Sort by ID.");
                        LogMenu.log("Please re-check file " + FileTask.OUTPUT + " for the product list after sorting by ID, the product list in the " + FileTask.DATA + " and the product list will stay the same");
                        LinkedList sortedProducts = FileTask.readProductsFromFile(FileTask.DATA);
                        LogMenu.log("The product list after sorting by ID: ");
                        Algorithm.selectionSortLinkedList(sortedProducts);
                        Algorithm.logLinkedList(sortedProducts);
                        LogMenu.createShortBreakLine();
                        FileTask.writeProductsToFle(FileTask.OUTPUT, sortedProducts);
                        LogMenu.log("Successfully");
                    }
                    case 8 -> {
                        LogMenu.log("Choice: 8");
                        LogMenu.log("Convert to Binary");
                        LogMenu.log("The quantity of first product in decimal: " + products.getHead().getData().getQuantity());
                        LogMenu.log("The quantity of first product in binary: " + Algorithm.decimalToBinaryRecursive(products.getHead().getData().getQuantity()));
                        LogMenu.log("Successfully");
                    }
                    case 9 -> {
                        LogMenu.log("Choice: 9");
                        LogMenu.log("Load to stack and display");
                        Stack productStack = Algorithm.linkedListToStack(products);
                        Algorithm.logStack(productStack);
                        LogMenu.log("Please re-check file " + FileTask.OUTPUT + " for the product list came from the Stack");
                        LogMenu.log("Successfully");
                    }
                    case 10 -> {
                        LogMenu.log("Choice: 10");
                        LogMenu.log("Load to queue and display.");
                        Queue productQueue = Algorithm.linkedListToQueue(products);
                        Algorithm.logQueue(productQueue);
                        LogMenu.log("Please re-check file " + FileTask.OUTPUT + " for the product list came from the Queue");
                        LogMenu.log("Successfully");
                    }
                    case 0 -> {
                        LogMenu.log("BYE!!!");
                    }
                    default -> LogMenu.log("Please enter a number with range from 0 to 10");
                }
            }
        }
    }
}
