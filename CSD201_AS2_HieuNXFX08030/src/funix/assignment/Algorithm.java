package funix.assignment;

import java.io.FileNotFoundException;

public class Algorithm {
    /*
        Method để get tail của LinkedList, vì chúng ta không sử dụng Doubly Ended List nên method này sẽ không được đặt ở trong Linked List class và sẽ được đặt trong class Algorithm
     */
    public static Node getTail(LinkedList list) {
        Node current = list.getHead();
        if (current == null) return null;
        while (current != null) {
            if (current.getNextNode() == null) return current;
            current = current.getNextNode();
        }
        return null;
    }

    /*
        Method để duyệt qua linked list và print các product ra màn hình
     */
    public static void logLinkedList(LinkedList list) {
        Node current = list.getHead();
        LogMenu.createShortBreakLine();
        LogMenu.log("ID | Title | Quantity | Price");
        if (current == null) {
            LogMenu.log("There aren't any products for yet");
        } else {
            while (current != null) {
                LogMenu.log(current.getData().toString());
                current = current.getNextNode();
            }
        }
    }

    /*
        Method để compare 2 string. Trả về negative value nếu như str1 < str2 và ngược lại, trả về 0 nếu 2 string giống nhau.
     */
    public static int stringCompare(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);

        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int)str1.charAt(i);
            int str2_ch = (int)str2.charAt(i);

            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }

        // Edge case for strings like
        if (l1 != l2) {
            return l1 - l2;
        }

        // If none of the above conditions is true,
        // it implies both the strings are equal
        else {
            return 0;
        }
    }

    /*
        Method để sắp xếp Linked list với ID của product sắp xếp từ A - Z. Sử dụng thuật toán selection sort cho chức năng này.
     */
    public static void sortList(LinkedList list) {
        //Node current will point to head
        Node current = list.getHead();
        Node index;
        Product temp;

        if (list.getHead() == null) {
            return;
        } else {
            while (current != null) {
                //Node index sẽ trỏ đến next node của current
                index = current.getNextNode();

                while (index != null) {
                    // Sử dụng method stringCompare để so sánh ID của 2 nodes
                    if (stringCompare(index.getData().getId(), current.getData().getId()) < 0) {
                        temp = current.getData();
                        current.setData(index.getData());
                        index.setData(temp);
                    }
                    index = index.getNextNode();
                }
                current = current.getNextNode();
            }
        }
    }

    /*
        Sắp xếp linked list sử dụng insertion sort
     */
    public static void selectionSortLinkedList(LinkedList list) {
        Node current = list.getHead();
        Node index;
        Product temp;

        if (list.getHead() == null) {
            return;
        } else {
            while (current != null) {
                String min = current.getData().getId();
                Node minNode = null;
                index = current.getNextNode();
                while (index != null) {
                    // Sử dụng method stringCompare để so sánh ID của 2 nodes
                    if (stringCompare(index.getData().getId(), min) < 0) {
                        minNode = index;
                        min = minNode.getData().getId();
                    }
                    index = index.getNextNode();
                }
                // Nếu như tìm thấy minNode, thực hiện swap data của current node với min node (chỉ swap data)
                if (minNode != null) {
                    temp = current.getData();
                    current.setData(minNode.getData());
                    minNode.setData(temp);
                }
                current = current.getNextNode();
            }
        }
    }

    /*
        Method để convert một số từ hệ thập phân sang nhị phân bằng đệ quy
     */
    public static String decimalToBinaryRecursive(int n) {
        if (n / 2 > 0) {
            return decimalToBinaryRecursive(n / 2) + String.valueOf(n % 2);
        } else {
            return String.valueOf(1);
        }
    }

    /*
        Method để push các products trong linked list vào stack, return stack này
     */
    public static Stack linkedListToStack(LinkedList list) {
        // Độ tài của stack đúng bằng length của Linked List, do đó ta khởi tạo một stack với max size bằng length của linked list
        Stack stack = new Stack(list.length());
        /*
            Lần lượt duyệt qua các phần tử trong linked list products và push vào stack.
         */
        Node current = list.getHead();
        if (current == null) return stack;
        while (current != null) {
            stack.push(current.getData());
            current = current.getNextNode();
        }
        return stack;
    }

    /*
        Method để duyệt qua các phần tử của linked list products và lần lượt enqueue các phần tử này vào queue (thêm vào từ tail của queue)
     */
    public static Queue linkedListToQueue(LinkedList list) {
        // Độ tài của queue đúng bằng length của Linked List, do đó ta khởi tạo một queue với max size bằng length của linked list
        Queue queue = new Queue(list.length());
        /*
            Lần lượt duyệt qua các phần tử trong linked list products và enqueue vào queue
         */
        Node current = list.getHead();
        if (current == null) return queue;
        while (current != null) {
            queue.enqueue(current.getData());
            current = current.getNextNode();
        }
        return queue;
    }

    /*
        Method để duyệt qua stack từ cuối về đầu để in ra các products ngược với thử tự đọc vào stack, vì trong stack các phần tử thêm sau cùng sẽ được xuất ra đầu tiên (LIFO)
     */
    public static void logStack(Stack stack) throws FileNotFoundException {
        LogMenu.createShortBreakLine();
        FileTask.clearFile(FileTask.OUTPUT);
        LogMenu.log("ID | Title | Quantity | Price");
        for (int i = stack.getMaxSize() - 1; i >= 0; i--) {
            LogMenu.log(stack.getStack()[i].toString());
            FileTask.appendToFile(FileTask.OUTPUT, stack.getStack()[i].toString());
        }
    }

    /*
        Method để duyệt qua queue các products và print các product ra màn hình
     */
    public static void logQueue(Queue queue) throws FileNotFoundException {
        LogMenu.createShortBreakLine();
        FileTask.clearFile(FileTask.OUTPUT);
        LogMenu.log("ID | Title | Quantity | Price");
        for (Product p : queue.getArr()) {
            LogMenu.log(p.toString());
            FileTask.appendToFile(FileTask.OUTPUT, p.toString());
        }
    }
}
