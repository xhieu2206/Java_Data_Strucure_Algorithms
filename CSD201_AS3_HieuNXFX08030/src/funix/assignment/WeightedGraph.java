package funix.assignment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WeightedGraph {
    static int EDGE_NOT_FOUND_WEIGHT = 9999;
    private final int numberOfVertices;
    private final int[][] edge;
    private final HashMap<Character, Integer> mapStringToIndex;
    private final HashMap<Integer, Character> mapIndexToString;

    public Map<Character, Integer> getMapStringToIndex() {
        return mapStringToIndex;
    }

    public Map<Integer, Character> getMapIndexToString() {
        return this.mapIndexToString;
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public WeightedGraph(int n) {
        /* Khởi tạo một graph có trọng số theo yêu cầu đề bài */
        this.numberOfVertices = n;
        this.edge = new int[n][n];
        this.mapStringToIndex = new HashMap<>();
        this.mapIndexToString = new HashMap<>();

        /* mapping các đỉnh với các chữ cái */
        char character = 'A';
        int index = 0;
        while (index < this.numberOfVertices) {
            mapStringToIndex.put(character, index);
            mapIndexToString.put(index, character);
            index++;
            character++;
        }

        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                if (i == j) {
                    this.edge[i][j] = 0;
                } else {
                    this.edge[i][j] = 9999;
                }
            }
        }
    }

    public void setEdge(int v1, int v2, int weight) {
        if (v1 == v2) {
            System.out.println("this is not gonna happen my friend!!!");
            return;
        }
        this.edge[v1][v2] = weight;
    }

    public void depthFirstTraversal(int vertexIndex, Stack stack, Boolean[] visitedVertices) {
        stack.push(vertexIndex);
        visitedVertices[vertexIndex] = true;
        System.out.print(this.mapIndexToString.get(vertexIndex) + " ");
        for (int i = 0; i < numberOfVertices; i++) {
            if (!visitedVertices[i] && edge[vertexIndex][i] > 0 && edge[vertexIndex][i] < 9999) {
                visitedVertices[i] = true;
                depthFirstTraversal(i, stack, visitedVertices);
            }
        }
        stack.pop();
    }

    /* Duyệt đồ thị theo chiều rộng */
    public void breadthFirstTraversal(char vertexString) {
        /* chuyển từ đỉnh dạng letter sang index */
        int startVertex = this.mapStringToIndex.get(vertexString);

        /* Tạo một mảng rỗng để đánh dấu các đỉnh đã đi qua, ban đầu các đỉnh sẽ được đánh dấu là FALSE, vì chưa có đỉnh nào được duyệt qua */
        Boolean[] visitedVertexArr = new Boolean[this.numberOfVertices];
        Arrays.fill(visitedVertexArr, Boolean.FALSE);

        /* tạo một queue để đẩy các đỉnh được duyệt vào queue này, mỗi khi thực hiện duyệt các đỉnh liền kề của đỉnh này xong, chúng ta sẽ dequeue đỉnh đó đi và duyệt tiếp ở đỉnh đầu tiên */
        QueueInteger queue = new QueueInteger(this.numberOfVertices);

        /* đưa đỉnh startVertex vào queue và thực hiện duyệt các đỉnh liền kề với đỉnh này, đồng thời đánh dấu đỉnh này đã được visited */
        queue.enqueue(startVertex);
        visitedVertexArr[startVertex] = true;

        while (!queue.isEmpty()) {
            for (int j = 0; j < numberOfVertices; j++) {
                /* kiểm tra nếu có đường đi từ đỉnh đầu tiên trong queue đến các đỉnh còn lại, nếu như đó là đỉnh liền kề và chưa được visted, đánh dấu là visited và thêm vào queue */
                if (this.edge[queue.peek()][j] > 0 && this.edge[queue.peek()][j] < 9999 && !visitedVertexArr[j]) {
                    visitedVertexArr[j] = true;
                    queue.enqueue(j);
                }
            }
            /* Thực hiện bỏ đỉnh đầu tiên ra khỏi queue, đồng thời in tên thành phố tương ứng với đỉnh đó */
            System.out.print(this.mapIndexToString.get(queue.dequeue()) + " ");
        }
    }

    /* method để kiểm tra xem đã thử đi qua hết các đỉnh chưa */
    static boolean isVisitedALlVertex(TrackingNode[] trackingNodes) {
        for (TrackingNode node : trackingNodes) {
            if (!node.isVisited) {
                return false;
            }
        }
        return true;
    }

    public void dijkstra(char v1, char v2) {
        /* Xác định điểm bắt đầu và kết thúc */
        int startVertex = this.mapStringToIndex.get(v1);
        int finalVertext = this.mapStringToIndex.get(v2);

        /* Tạo một array rỗng, tính toán đường đi ngắn nhất từ mọi đỉnh trong graph đến đỉnh v1. Mỗi phần tử sẽ store tổng trọng số của đường đi ngắn nhất và đỉnh trỏ đến nó ở ngay trước đó. Ban đầu ta sẽ gán trọng số là MAX_INT, và tracked node trước đó là -1 */
        TrackingNode[] trackingNodes = new TrackingNode[this.numberOfVertices];
        for (int i = 0; i < trackingNodes.length; i++) {
            trackingNodes[i] = new TrackingNode();
            trackingNodes[i].setWeight(Integer.MAX_VALUE);
            trackingNodes[i].setPreviousVertex(-1);
            trackingNodes[i].setVisited(false);
        }

        trackingNodes[startVertex].setWeight(0);
        trackingNodes[startVertex].setPreviousVertex(startVertex);

        /* thực hiện đi qua tất cả các đinh để tìm cách rút ngắn đường đi, loop đến khi nào tất cả các đỉnh đều đã được xét */
        while(!isVisitedALlVertex(trackingNodes)) {
            int minValue = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < trackingNodes.length; i++) {
                /* Tìm đỉnh hiện tại có trọng số bé nhất để xét */
                if (!trackingNodes[i].isVisited() && trackingNodes[i].getWeight() < minValue) {
                    minValue = trackingNodes[i].getWeight();
                    minIndex = i;
                }
            }

            /* Sau khi đã tìm được đỉnh thích hợp để xét, bắt đầu thực hiện tìm đường đi từ đỉnh này đến các đỉnh còn lại để xem xem có thể rút ngắn được đường đi không */
            for (int j = 0; j < numberOfVertices; j++) {
                if (edge[minIndex][j] > 0 && edge[minIndex][j] < EDGE_NOT_FOUND_WEIGHT && (edge[minIndex][j] + trackingNodes[minIndex].getWeight() < trackingNodes[j].getWeight())) {
                    trackingNodes[j].setWeight(edge[minIndex][j] + trackingNodes[minIndex].getWeight());
                    trackingNodes[j].setPreviousVertex(minIndex);
                }
            }

            /* Đánh dấu node này đã được duyệt */
            trackingNodes[minIndex].setVisited(true);
        }

        /* Kết thúc thuật toán, chúng ta có được mảng trackingNodes lưu trọng số của đường đi ngắn nhất từ đỉnh v1 tới các đỉnh còn lại, và đỉnh trước đó để đến mỗi đỉnh, giờ ta sẽ tracking ngược lại từ đỉnh v2 về đỉnh v1, ta sẽ dùng stack vì chúng ta sẽ duyệt ngược lại */
        Stack result = new Stack(numberOfVertices);
        int currentVertexIndex = finalVertext;
        while (currentVertexIndex != startVertex) {
            result.push(currentVertexIndex);
            currentVertexIndex = trackingNodes[currentVertexIndex].getPreviousVertex();
        }
        result.push(startVertex);

        while (!result.isEmpty()) {
            System.out.print(this.mapIndexToString.get(result.pop()) + " ");
        }
        System.out.println();
        System.out.println("Total weighted of shortest path from " + v1 + " to " + v2 + ": " + trackingNodes[this.mapStringToIndex.get(v2)].getWeight());
        System.out.println("Dijkstra algorithm for shortest path from " + v1 + " to other vertex:");
        for (int i = 0; i < trackingNodes.length; i++) {
            System.out.println("From " + v1 + " to " + this.mapIndexToString.get(i) + " is " + trackingNodes[i].getWeight());
        }
    }

    public void graphDisplay() {
        LogMenu.log("The weighted matrix of the graph:");
        LogMenu.createBreakLine();
        for (int i = 0; i < this.numberOfVertices; i++) {
            for (int j = 0; j < this.numberOfVertices; j++) {
                if (this.edge[i][j] == EDGE_NOT_FOUND_WEIGHT) {
                    System.out.print("INF" + "    ");
                } else {
                    System.out.print(this.edge[i][j] + "    ");
                }
            }
            System.out.println();
        }
        LogMenu.createBreakLine();
    }
}

class TrackingNode {
    int weight;
    int previousVertex;
    boolean isVisited = false;

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPreviousVertex() {
        return previousVertex;
    }

    public void setPreviousVertex(int previousVertex) {
        this.previousVertex = previousVertex;
    }
}

class QueueInteger {
    private int head;
    private int tail;
    private final int maxSize;
    private final int[] arr;

    public QueueInteger(int max) {
        this.maxSize = max;
        this.arr = new int[maxSize];
        this.head = -1;
        this.tail = -1;
    }

    public void enqueue(int data) {
        if ((tail + 1) % maxSize == head) {
            System.out.println("Queue if full!");
        } else {
            tail = (tail + 1) % maxSize;
            arr[tail] = data;
            if (head == -1) {
                head = tail;
            }
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            int item = arr[head];
            if (head == tail) {
                head = -1;
                tail = -1;
            } else {
                head = (head + 1) % maxSize;
            }
            return item;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return this.arr[this.head];
    }

    public int length() {
        return Math.abs(this.head - this.tail) + 1;
    }

    public boolean isEmpty() {
        return head == -1;
    }

}
