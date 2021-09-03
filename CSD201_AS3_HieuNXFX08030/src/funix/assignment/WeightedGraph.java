package funix.assignment;

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
