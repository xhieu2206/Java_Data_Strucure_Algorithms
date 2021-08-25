package com.example;

public class BinarySearchTree {
    private TreeNode root;

    public void insert(Integer data) {
        if (root == null) {
            this.root = new TreeNode(data);
        } else {
            root.insert(data);
        }
    }

    public TreeNode find(Integer data) {
        if (root != null) {
            return root.find(data);
        }
        return null;
    }

    public void delete(Integer data) {
        TreeNode toDel = find(data);
        toDel.delete();
    }

    public Integer smallest() {
        if (root == null) return null;
        return root.smallest();
    }

    public Integer largest() {
        if (root == null) return null;
        return root.largest();
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

    public void traversalPostOrder() {
        if (root != null) {
            root.traversalPostOrder();
        }
    }

    /* Phương pháp delete phức tạp, chúng ta sẽ sử dụng soft delete instead
    public void delete(Integer data) {
        TreeNode current = this.root;
        TreeNode parent = this.root;
        boolean isLeftChild = false;

        if (current == null) return; // return if the Tree was empty
        while (current != null && current.getData() != data) {
            parent = current;

            if (data < current.getData()) {
                current = current.getLeftChild();
                isLeftChild = true;
            } else {
                current = current.getRightChild();
                isLeftChild = false;
            }
        }

        if (current == null) return; // Not found the node
        if (current.getLeftChild() == null && current.getRightChild() == null) {
            if (current == root) {
                this.root = null;
            } else {
                if (isLeftChild) {
                    parent.setLeftChild(null);
                } else {
                    parent.setRightChild(null);
                }
            }
        } else if (current.getRightChild() == null && current.getLeftChild() != null) {
            if (current == root) {
                root = current.getLeftChild();
            } else if (isLeftChild) {
                parent.setLeftChild(current.getLeftChild());
            } else {
                parent.setRightChild(current.getLeftChild());
            }
        } else if (current.getLeftChild() == null && current.getRightChild() != null) {
            if (current == root) {
                root = current.getRightChild();
            } else if (isLeftChild) {
                parent.setLeftChild(current.getRightChild());
            } else {
                parent.setRightChild(current.getRightChild());
            }
        }
    }
     */
}
