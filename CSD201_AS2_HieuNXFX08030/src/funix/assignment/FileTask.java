package funix.assignment;

import java.io.*;
import java.util.Scanner;

public class FileTask {
    public final static String DATA = "DATA.txt";
    public final static String OUTPUT = "OUTPUT.txt";

    /*
        Method để xóa hết toàn bộ nội dung của file
     */
    public static void clearFile(String fileName) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("src/" + fileName);
        pw.close();
    }

    /*
        Method to write data to a new file, clear all the text in file then writing data to the file
     */
    public static void writeToFile(String fileName, String text) throws FileNotFoundException {
        try {
            FileWriter myWriter = new FileWriter("src/" + fileName);
            myWriter.write(text);
            myWriter.close();
            System.out.println("Successfully wrote to the file, you can check for file " + fileName + " for detail");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /*
        Method để thêm dòng với nội dung `text` vào cuối file
     */
    public static void appendToFile(String fileName, String text) {
        try (FileWriter fw = new FileWriter("src/" + fileName, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(text);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /*
        Method để đọc danh sách các products trong file. Các properties của Product sẽ hiển thị trên một dòng, với lần lượt các thuộc tính ID, name, quantity, price
        1 | Book | 10 | 2
        2 | Phone | 100 | 3
        Các products sẽ được đọc và lưu vào linked list, method sẽ return linked list này
     */
    public static LinkedList readProductsFromFile(String fileName) {
        LinkedList productList = new LinkedList();
        try {
            File myObj = new File("src/" + fileName);
            Scanner myReader = new Scanner(myObj);
            String[] data;
            while (myReader.hasNextLine()) {
                data = myReader.nextLine().trim().split(" \\| ");
                Product product = new Product(
                    data[0],
                    data[1],
                    Integer.parseInt(data[2]),
                    Integer.parseInt(data[3])
                );
                // thêm node data của product mới ở tail của linked list
                productList.insertAtTail(product);
            }
            return productList;
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + "not found");
            e.printStackTrace();
            return null;
        }
    }

    /*
        Method để listing các products ra file.
     */
    public static void writeProductsToFle(String fileName, LinkedList products) throws FileNotFoundException {
        clearFile(fileName);
        Node curent = products.getHead();
        if (curent == null) return;
        while (curent != null) {
            appendToFile(fileName, curent.getData().toString());
            curent = curent.getNextNode();
        }
    }
}
