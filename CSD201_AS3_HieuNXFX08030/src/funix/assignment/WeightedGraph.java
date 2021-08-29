package funix.assignment;

import java.util.HashMap;
import java.util.Map;

public class WeightedGraph {
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
}
