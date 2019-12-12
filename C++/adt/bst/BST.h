//
// Created by crwen on 2019/12/12.
//

#ifndef DATASTRUCTURE_BST_H
#define DATASTRUCTURE_BST_H

#include <iostream>
#include <cassert>
#include <queue>
#include <stack>
#include "../queue/LinkedListQueue.h"
#include "../queue/ArrayQueue.h"
#include "../stack/LinkedListStack.h"

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

    bool contains(BNode<T> *node, T e) {
        if (node == nullptr)
            return false;
        if (e < node->e) {
            return contains(node->left, e);
        } else if (node->e < e) {
            return contains(node->right, e);
        }
        return true;
    }

    /**
     *  返回二叉搜索树中最小元素的节点
     * @param node
     * @return
     */
    BNode<T> *min(BNode<T> *node) {
        if (node->left == nullptr)
            return node;
        return min(node->left);
    }

    /**
 *  返回二叉搜索树中元素最大的节点
 * @return
 */
    BNode<T> *max(BNode<T> *node) {
        if (node->right == nullptr)
            return node;
        return max(node->right);
    }

    /**
     *  移除最小的节点，返回删除后以 node为根的子树
     * @param node
     * @return
     */
    BNode<T> *removeMin(BNode<T> *node) {
        if (node->left == nullptr) {
            BNode<T> *rightNode = node->right;
            delete node;
            size--;
            return rightNode;
        }

        node->left = removeMin(node->left);
        return node;
    }

    /**
     *  移除最大节点，返回以 node 为根的子树
     * @param node
     * @return
     */
    BNode<T> *removeMax(BNode<T> *node) {
        if (node->right == nullptr) {
            BNode<T> *leftNode = node->left;
            delete node;
            size--;
            return leftNode;
        }

        node->right = removeMax(node->right);
        return node;
    }

    /**
     *  移除元素为 e 的节点，返回以 node 为根的子树
     * @param node
     * @param e
     * @return
     */
    BNode<T> *remove(BNode<T> *node, T e) {
        if (node == nullptr) {
            return nullptr;
        }
        if (e < node->e) {
            node->left = remove(node->left, e);
            return node;
        } else if (node->e < e) {
            node->right = remove(node->right, e);
            return node;
        } else {
            if (node->left == nullptr) {
                BNode<T> *rightNode = node->right;
                delete node;
                size--;
                return rightNode;
            }

            if (node->right == nullptr) {
                BNode<T> *leftNode = node->left;
                delete node;
                size--;
                return leftNode;
            }

            BNode<T> *successor = new BNode<T>(min(node->right)->e);
            size++;

            successor->right = removeMin(node->right);
            successor->left = node->left;
            node->left = node->right = nullptr;
            delete node;
            size--;

            return node;
        }
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

    bool contains(T e) {
        return contains(root, e);
    }

    void inOrder() {
        inOrder(root);
        std::cout << std::endl;
    }

    void inOrderNRRight() {
        std::stack<BNode<T> *> stack;
        BNode<T> *cur = root;
        while (cur != nullptr || !stack.empty()) {
            while (cur != nullptr) {
                stack.push(cur);
                cur = cur->left;
            }
            if (!stack.empty()) {
                cur = stack.top();
                std::cout << cur->e << " ";
                stack.pop();
                cur = cur->right;
            }
        }
        std::cout << std::endl;

    }

    void inOrderNR() {
        LinkedListStack<BNode<T> *> *stack = new LinkedListStack<BNode<T> *>();
        BNode<T> *cur = root;

        while(cur != nullptr || !stack->isEmpty()) {
            while (cur != nullptr) {
                stack->push(cur);
                cur = cur->left;
            }
            if (!stack->isEmpty()) {
                cur = stack->pop();
                std::cout << cur->e << " ";
                cur = cur->right;
            }
        }
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

    void levelOrderRight() {
        std::queue<BNode<T> *> *q = new std::queue<BNode<T> *>();
        q->push(root);
        while (! q->empty()) {
            BNode<T> *node = q->front();
            q->pop();
            std::cout << node->e << " ";
            if (node->left != nullptr) {
                q->push(node->left);
            }
            if (node->right != nullptr) {
                q->push(node->right);
            }
        }
        std::cout << std::endl;
    }

    void levelOrder() {
//        ArrayQueue<BNode<T> *> *q = new ArrayQueue<BNode<T> *> ();
        LinkedListQueue<BNode<T> *> *q = new LinkedListQueue<BNode<T> *> ();
        q->enqueue(root);
        while (! q->isEmpty()) {
            BNode<T> *node = q->dequeue();
            std::cout << node->e << " ";
            if (node->left != nullptr) {
                q->enqueue(node->left);
            }
            if (node->right != nullptr) {
                q->enqueue(node->right);
            }
        }
        std::cout << std::endl;
    }

    T maximun() {
        assert(size > 0);
        return max(root)->e;
    }

    T minimun() {
        assert(size > 0);
        return min(root)->e;
    }

    T removeMin() {
        T ret = minimun();
        root = removeMin(root);
        return ret;
    }

    T removeMax() {
        T ret = maximun();
        root = removeMax(root);
        return ret;
    }

    void remove(T e) {
        remove(root, e);
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
