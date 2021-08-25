package funix.assignment;

public class Node {
    private Product data;
    private Node nextNode;

    public Node(Product product) {
        data = product;
    }

    public void setData(Product data) {
        this.data = data;
    }

    public Product getData() {
        return data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
