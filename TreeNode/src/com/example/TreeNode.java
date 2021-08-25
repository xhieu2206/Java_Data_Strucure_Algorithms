package com.example;

import com.sun.source.tree.Tree;

public class TreeNode {
    private Integer data;
    private TreeNode leftChild;
    private TreeNode rightChild;
    private boolean isDeleted = false;

    public TreeNode(Integer data) {
        this.data = data;
    }

    public Integer getData() {
        return data;
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

    public TreeNode find(Integer data) {
        if (this.data == data && !this.isDeleted) {
            return this;
        } else if (this.data > data && this.getLeftChild() != null) {
            return this.getLeftChild().find(data);
        } else if (this.data < data && this.getRightChild() != null) {
            return this.getRightChild().find(data);
        }
        return null;
    }

    public void insert(Integer newData) {
        TreeNode newNode = new TreeNode(newData);
        if (this.getRightChild() == null && newData >= data) {
            this.setRightChild(newNode);
        } else if (this.getLeftChild() == null && newData <= data) {
            this.setLeftChild(newNode);
        } else if (this.getRightChild() != null && newData >= data) {
            this.getRightChild().insert(newData);
        } else if (this.getLeftChild() != null && newData <= data) {
            this.getLeftChild().insert(newData);
        }
    }

    public void delete() {
        this.isDeleted = true;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public Integer smallest() {
        if (this.getLeftChild() == null) {
            return this.getData();
        } else {
            return this.getLeftChild().smallest();
        }
    }

    public Integer largest() {
        if (this.getRightChild() == null) {
            return this.getData();
        } else {
            return this.getRightChild().smallest();
        }
    }

    public void traversalInOrder() {
        if (this.getLeftChild() != null) {
            this.getLeftChild().traversalInOrder();
        }
        System.out.println(this.data);
        if (this.getRightChild() != null) {
            this.getRightChild().traversalInOrder();
        }
    }

    public void traversalPreOrder() {
        System.out.println(this.data);
        if (this.getLeftChild() != null) {
            this.getLeftChild().traversalPreOrder();
        }
        if (this.getRightChild() != null) {
            this.getRightChild().traversalPreOrder();
        }
    }

    public void traversalPostOrder() {
        if (this.getLeftChild() != null) {
            this.getLeftChild().traversalPostOrder();
        }
        if (this.getRightChild() != null) {
            this.getRightChild().traversalPostOrder();
        }
        System.out.println(this.data);
    }
}
