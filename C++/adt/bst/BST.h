//
// Created by crwen on 2019/12/12.
//

#ifndef DATASTRUCTURE_BST_H
#define DATASTRUCTURE_BST_H

#include <iostream>

template <class T>
class BNode {
public:
    T e;
    BNode *left, *right;
    BNode(T e) {
        this->e = e;
        left = nullptr;
        right = nullptr;
    }
};

template <class T>
class BST {
private:
    BNode<T> *root;
    int size;

    BNode<T> *add(BNode<T> *node, T e) {
        if (node == nullptr) {
            size++;
            return new BNode<T>(e);
        }
        if (node->e > e) {
            node->left = add(node->left, e);
        } else if (node->e < e) {
            node->right = add(node->right, e);
        }
        return node;
    }

    void inOrder(BNode<T> *node) {
        if (node == nullptr)
            return;
        inOrder(node->left);
        std::cout << node->e << " ";
        inOrder(node->right);
    }

    void preOrder(BNode<T> *node) {
        if (node == nullptr)
            return;
        std::cout << node->e << " ";
        preOrder(node->left);
        preOrder(node->right);
    }

    void postOrder(BNode<T> *node) {
        if (node == nullptr)
            return ;
        postOrder(node->left);
        postOrder(node->right);
        std::cout << node->e << " ";
    }
public:

    BST() {
        root = nullptr;
        size = 0;
    }

    int getSize() {
        return size;
    }

    bool isEmpty() {
        return size == 0;
    }

    void add(T e) {
        if (root == nullptr) {
            root = new BNode<T>(e);
            size++;
        } else {
            add(root, e);
        }
    }

    void inOrder() {
        inOrder(root);
        std::cout << std::endl;
    }

    void preOrder() {
        preOrder(root);
        std::cout << std::endl;
    }

    void postOrder() {
        postOrder(root);
        std::cout << std::endl;
    }

    void generateDepthString(int depth) {
        for (int i = 0; i < depth; ++i) {
            std::cout << "--";
        }
    }

    void generateBSTString(BNode<T> *node, int depth) {
        if (node == nullptr) {
            generateDepthString(depth);
            std::cout << "NULL" << std::endl;
            return;
        }
        generateDepthString(depth);
        std::cout << node->e << std::endl;
        generateBSTString(node->left, depth + 1);
        generateBSTString(node->right, depth + 1);
    }

    void print() {
        generateBSTString(root, 0);
    }
};


#endif //DATASTRUCTURE_BST_H
