package funix.hieunxfx08030;

import java.util.Arrays;

public class Graph {

    private final int numberOfVertices;
    private final Boolean[][] edge;

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public Graph(int n) {
        this.numberOfVertices = n;
        this.edge = new Boolean[n][n];
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                this.edge[i][j] = false;
            }
        }
    }

    public void setEdge(int v1, int v2) {
        if (v1 == v2) {
            System.out.println("this is not gonna happen my friend!!!");
            return;
        }
        this.edge[v1][v2] = true;
        this.edge[v2][v1] = true;
    }

    public void breadthFirstTraversal(int vertex) {
        Boolean[] visitedVertexArr = new Boolean[this.numberOfVertices];
        Arrays.fill(visitedVertexArr, Boolean.FALSE);
        Queue queue = new Queue(numberOfVertices);
        queue.enqueue(vertex);
        visitedVertexArr[vertex] = true;
        while (!queue.isEmpty()) {
            for (int i = 0; i < numberOfVertices; i++) {
                if (this.edge[queue.peek()][i] && !visitedVertexArr[i]) {
                    visitedVertexArr[i] = true;
                    queue.enqueue(i);
                }
            }
            System.out.println(queue.dequeue());
        }
    }

    public void depthFirstTraversalLogging(int vertex, Stack stack, Boolean[] visitedVertices) {
        stack.push(vertex);
        visitedVertices[vertex] = true;
        System.out.println(vertex);
        for (int i = 0; i < numberOfVertices; i++) {
            if (!visitedVertices[i] && edge[vertex][i]) {
                visitedVertices[i] = true;
                depthFirstTraversalLogging(i, stack, visitedVertices);
            }
        }
        stack.pop();
    }

    public void depthFirstTraversal(int vertex, Stack stack, Boolean[] visitedVertices) {
        stack.push(vertex);
        visitedVertices[vertex] = true;
        for (int i = 0; i < numberOfVertices; i++) {
            if (!visitedVertices[i] && edge[vertex][i]) {
                visitedVertices[i] = true;
                depthFirstTraversal(i, stack, visitedVertices);
            }
        }
        stack.pop();
    }

    public int numberOfComponents() {
        int result = 0;
        Boolean[] visitedArray = new Boolean[numberOfVertices];
        Arrays.fill(visitedArray, Boolean.FALSE);
        for (int i = 0; i < numberOfVertices; i++) {
            if (!visitedArray[i]) {
                this.depthFirstTraversal(i, new Stack(this.numberOfVertices), visitedArray);
                result++;
            }
        }
        return result;
    }
}
