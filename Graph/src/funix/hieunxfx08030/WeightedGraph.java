package funix.hieunxfx08030;

public class WeightedGraph {
    private final int numberOfVertices;
    private final int[][] edge;

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public WeightedGraph(int n) {
        this.numberOfVertices = n;
        this.edge = new int[n][n];
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                this.edge[i][j] = -1;
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
}
