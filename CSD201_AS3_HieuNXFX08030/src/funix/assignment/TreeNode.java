package funix.assignment;

import java.util.Objects;

public class TreeNode {
    private final Person person;
    public TreeNode leftChild;
    public TreeNode rightChild;
    private boolean isDeleted = false;

    public TreeNode(Person person) {
        this.person = person;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public Person getPerson() {
        return person;
    }

    /* Duyệt cây nhị phân theo thứ tự InOrder, với cách duyệt này, chúng ta sử dụng đệ quy, khi duyệt bằng cách này, chúng ta sẽ lần lượt duyệt từ left sub tree trước, rồi đến root node và cuối cùng là right sub tree, đối với những node bị đánh dấu là deleted, chúng ta sẽ không in những phần tử này ra. */
    public void traversalInOrder() {
        if (this.getLeftChild() != null) {
            this.getLeftChild().traversalInOrder();
        }
        if (!this.isDeleted) {
            /* chỉ in ra node nếu như node này chưa bị deleted khỏi tree */
            System.out.println(this.person.toString());
        }
        if (this.getRightChild() != null) {
            this.getRightChild().traversalInOrder();
        }
    }


    /* sử dụng phương pháp duyệt PreOrder để duyệt qua các phần tử của Tree */
    public void traversalPreOrder(BinarySearchTree tree) {
        /* Mỗi khi duyệt qua một phần tử, tăng số lượng nodes đếm được thêm 1 đơn vị */
        if (!this.isDeleted()) {
            tree.setTotal(tree.getTotal() + 1);
        }
        /* Nếu tồn tại left child, duyệt sang node này */
        if (this.getLeftChild() != null) {
            this.getLeftChild().traversalPreOrder(tree);
        }
        /* tương tự với right child */
        if (this.getRightChild() != null) {
            this.getRightChild().traversalPreOrder(tree);
        }
    }

    /* Thêm mới một node trong cây nhị phân, so sánh ID của newPerson và this.person để tìm vị thêm vào kết hợp với đệ quy để duyệt đến Node lá để thêm phân tử mới vào TreeNode */
    public void insert(Person newPerson) {
        TreeNode newNode = new TreeNode(newPerson);
        if (this.person.getId().equals(newPerson.getId())) {
            System.out.println("The Person with this ID has been already existed");
            return;
        }
        if (this.getRightChild() == null && stringCompare(newPerson.getId(), this.person.getId()) > 0) {
            this.setRightChild(newNode);
        } else if (this.getLeftChild() == null && stringCompare(newPerson.getId(), this.person.getId()) < 0) {
            this.setLeftChild(newNode);
        } else if (this.getRightChild() != null && stringCompare(newPerson.getId(), this.person.getId()) > 0) {
            this.getRightChild().insert(newPerson);
        } else if (this.getLeftChild() != null && stringCompare(newPerson.getId(), this.person.getId()) < 0) {
            this.getLeftChild().insert(newPerson);
        }
    }

    /* Method để tìm kiếm Person theo ID, sử dụng đệ quy để tìm giữa các Node */
    public TreeNode find(String id) {
        if (Objects.equals(this.person.getId(), id) && !this.isDeleted) {
            return this;
        } else if (stringCompare(this.person.getId(), id) > 0 && this.getLeftChild() != null) {
            return this.getLeftChild().find(id);
        } else if (stringCompare(this.person.getId(), id) < 0 && this.getRightChild() != null) {
            return this.getRightChild().find(id);
        }
        return null;
    }

    /* Sử dụng soft delete để xóa một node ra khỏi cây nhị phân, bằng cách đánh dấu isDeleted = true */
    public void delete() {
        this.isDeleted = true;
    }

    /* Cho biết node này có bị deleted ra khỏi cây nhị phân hay không */
    public boolean isDeleted() {
        return isDeleted;
    }

    /*
        Method để compare 2 string. Trả về negative value nếu như str1 < str2 và ngược lại, trả về 0 nếu 2 string giống nhau. Sử dụng để compare ID string trước khi thêm vào Tree
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

    public void traversalPreOrder() {
        if (!this.isDeleted) {
            /* chỉ in ra node nếu như node này chưa bị deleted khỏi tree */
            System.out.println(this.person.toString());
        }
        if (this.getLeftChild() != null) {
            this.getLeftChild().traversalPreOrder();
        }
        if (this.getRightChild() != null) {
            this.getRightChild().traversalPreOrder();
        }
    }

    /* Post-Order traversal */
    public void traversalPostOrder() {
        if (this.getLeftChild() != null) {
            this.getLeftChild().traversalPostOrder();
        }
        if (this.getRightChild() != null) {
            this.getRightChild().traversalPostOrder();
        }
        if (!this.isDeleted) {
            /* chỉ in ra node nếu như node này chưa bị deleted khỏi tree */
            System.out.println(this.person.toString());
        }
    }
}
