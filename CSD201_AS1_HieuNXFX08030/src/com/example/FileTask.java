package com.example;

import java.io.*;
import java.util.Scanner;

public class FileTask {
    public final static String INPUT = "INPUT.txt";
    public final static String FIRST_OUTPUT_FILE = "OUTPUT1.txt";
    public final static String SECOND_OUTPUT_FILE = "OUTPUT2.txt";
    public final static String THIRD_OUTPUT_FILE = "OUTPUT3.txt";
    public final static String FOURTH_OUTPUT_FILE = "OUTPUT4.txt";
    public final static String FIFTH_OUTPUT_FILE = "OUTPUT5.txt";

    /*
        Method to write data to a new file, clear all the text in file then writing data to the file
     */
    public static void writeToFile(String fileName, String text) throws FileNotFoundException {
        clearFile(fileName);
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
        Method to append data to file in the new line, doesn't erase the old data
     */
    public static void appendToFile(String fileName, String text) {
        try(FileWriter fw = new FileWriter("src/" + fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(text);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /*
        Method to clear all the text in the file
     */
    public static void clearFile(String fileName) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("src/" + fileName);
        pw.close();
    }

    /*
        Method to read the lass line of the file, and return a String for that line
     */
    public static String readFile(String fileName) {
        try {
            File myObj = new File("src/" + fileName);
            Scanner myReader = new Scanner(myObj);
            String data = "";
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }
            myReader.close();
            return data;
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + "not found");
            e.printStackTrace();
            return "File " + fileName + "not found";
        }
    }
}
