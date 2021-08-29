package funix.assignment;

import java.util.Vector;

public class BinarySearchTree {

    private TreeNode root;
    private int total = 0;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void insert(Person person) {
        if (root == null) {
            this.root = new TreeNode(person);
        } else {
            root.insert(person);
        }
    }

    public int getTotal() {
        return total;
    }

    public TreeNode find(String id) {
        if (root != null && !root.isDeleted()) {
            return root.find(id);
        }
        return null;
    }

    public void delete(String id) {
        if (root.getPerson().getId() == id) {
            LogMenu.log("You cannot delete the root node");
            return;
        }
        if (root != null && !root.isDeleted()) {
            /* Tìm node tương ứng với Person sẽ bị deleted */
            TreeNode deleteNode = root.find(id);

            /* Soft delete bằng cách set isDeleted thành true nếu như có tìm thấy item để xóa */
            if (deleteNode != null) {
                deleteNode.delete();
                LogMenu.log("The person with ID " + id + " was deleted");

                /* Thực hiện duyệt lại toàn bộ tree đê chứng mình Node đó đã bị xóa khỏi Tree */
                traversalInOrder();
            } else {
                LogMenu.log("Couldn't find the Person with ID " + id + " for deleting");
            }
        } else {
            LogMenu.log("There is nothing to delete");
        }
    }

    public void traversalInOrder() {
        if (root != null) {
            root.traversalInOrder();
        }
    }

    public void traversalPreOrder() {
        if (root != null) {
            root.traversalPreOrder();
        }
    }

    /* method để tính số lượng các nodes trong cây nhị phân, sử dụng đệ quy để duyệt qua các node này, sau mỗi lần duyệt 1 phần tử thì tăng length lên 1 nếu như node đó chưa bị xóa khỏi cây nhị phân */
    public void length() {
        if (root != null) {
            root.traversalPreOrder(this);
        }
    }

    /* Duyệt cây nhị phân theo chiều rộng, đối với cách duyệt này chúng ta sẽ không sử dụng đệ quy, mà đối với mỗi node, chúng ta sẽ duyệt qua các node con của nó, đưa vào Stack (First in first out), duyệt qua từng level của Tree, với mỗi node đã duyệt qua chúng ta sẽ đánh dấu là true và không thực hiện duyệt lại nữa */
    public void breadthFirstTraversal() {
        /* Nếu như Tree hiện tại đang rỗng thì thông báo tree đang empty và return */
        if (this.root == null || this.root.isDeleted()) {
            LogMenu.log("This Binary Tree is empty");
            return;
        }

        /* tạo ra một queue để đưa vào danh sách các Node trong Tree sẽ được duyệt, sẽ duyệt đến khi nào queue này empty, độ dài của Queue sẽ bằng với số lượng các persons trong Tree Node, khi một node được duyệt qua, chúng ta sẽ dequeue node này ra khỏi queue */
        /* calculate total of nodes */
        this.length();
        Queue queue = new Queue(this.total);
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            /* Log ra màn hình thông tin của Person tương ứng với node đang duyệt, tuy nhiên node này phải được đánh dấu là chưa bị xóa khỏi Tree */
            if (!queue.peek().isDeleted()) {
                System.out.println(queue.peek().getPerson().toString());
            }

            /* nếu như tồn tại left child hoặc right child thì enqueue node này vào queue */
            if (queue.peek().getLeftChild() != null) {
                queue.enqueue(queue.peek().getLeftChild());
            }
            if (queue.peek().getRightChild() != null) {
                queue.enqueue(queue.peek().getRightChild());
            }

            /* dequeue node đang duyệt ra khỏi queue, tiếp tục thực hiện lại vòng lặp cho đến khi nào queue empty */
            queue.dequeue();
        }
    }

    /* function với chức năng duyệt qua tất cả các node của BST và lưu các Node trỏ đến các node của BST này */
    void storeBinarySearchTreeNodes(TreeNode node, Vector<TreeNode> nodes) {
        if (node == null)
            return;

        /* Store nodes theo cách duyệt Inorder, bằng cách duyệt này ta đảm bảo list các Node có ID tăng dần theo bảng chữ cái */
        storeBinarySearchTreeNodes(node.leftChild, nodes);
        if (!node.isDeleted()) {
            nodes.add(node);
        }
        storeBinarySearchTreeNodes(node.rightChild, nodes);
    }

    TreeNode buildBalancedTreeUtil(Vector<TreeNode> nodes, int start, int end) {
        /* khởi tạo một BST mới, nếu đây là lần duyệt đầu tiên thì node chính giữa chính là root của tree */
        if (start == 0 && end == nodes.size() - 1) {
            this.setRoot(nodes.get((start + end) /2));
        }
        if (start > end)
            return null;

        /* Lấy ra node ở giữa và coi node đó là root */
        int mid = (start + end) / 2;
        TreeNode node = nodes.get(mid);

        /* tiếp tục khởi tạo left and right subtress sử dụng đệ quy */
        node.leftChild = buildBalancedTreeUtil(nodes, start, mid - 1);
        node.rightChild = buildBalancedTreeUtil(nodes, mid + 1, end);

        return node;
    }

    /* function để convert một Unbalance Binary Search Tree thành một balance search tree */
    public void buildTree(TreeNode root) {
        /* store các nodes của tree hiện tại theo sorted order */
        Vector<TreeNode> nodes = new Vector<>();
        storeBinarySearchTreeNodes(root, nodes);

        // xây dựng cây nhị phân cân bằng từ array nodes được store ở trên
        int n = nodes.size();
        buildBalancedTreeUtil(nodes, 0, n - 1);
    }
}
