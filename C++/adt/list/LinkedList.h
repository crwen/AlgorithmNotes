//
// Created by crwen on 2019/12/8.
//

#ifndef DATASTRUCTURE_LINKEDLIST_H
#define DATASTRUCTURE_LINKEDLIST_H

#include "List.h"
#include <iostream>
#include <cassert>

template <class T>
class Node {
public:
    T e;
    Node *next;

    Node(T e, Node *next) : e(e), next(next) {}

    Node(T e) : e(e), next(nullptr) {}

    Node() : next(nullptr) {}

    ~Node() {
        delete [] next;
        next = nullptr;
    }
};

template <class T>
class LinkedList : public List<T> {
public:

    LinkedList() {
        head = new Node<T>();
        size = 0;
    }

    ~LinkedList() {
        delete [] head;
        head = nullptr;
    }

    /**
     *  获取元素个数
     * @return
     */
    int getSize() override {
        return size;
    }

    /**
     *  判断链表是否为空
     * @return
     */
    bool isEmpty() override {
        return size == 0;
    }

    /**
     *  在下标为 index 处添加元素 e
     * @param index
     * @param e
     */
    void add(int index, T e) override {
        assert(index >= 0 && index <= size);
        Node<T> *prev = head;
        for (int i = 0; i < index; ++i) {
            prev = prev->next;
        }
        prev->next = new Node<T>(e, prev->next);
        size++;
    }

    void addFirst(T e) {
//        Node<T> *prev = head;
//        head->next = new Node<T>(e, prev->next);
//        size++;
        add(0, e);
    }

    void addLast(T e) {
//        Node<T> *prev = head;
//        while (prev->next != nullptr) {
//            prev = prev->next;
//        }
//        prev->next = new Node<T>(e);
//        size++;
        add(size, e);
    }

    /**
     *  获取下标为 index 的元素
     * @param index
     * @return
     */
    T get(int index) override {
        assert(index >= 0 && index < size);
        Node<T> *cur = head->next;
        for (int i = 0; i < index; i++) {
            cur = cur->next;
        }
        return cur->e;
    }

    T getFirst() {
        return get(0);
    }

    T getLast() {
        return get(size - 1);
    }

    /**
     *  删除下标为 index 处的元素并返回
     * @param index
     * @return
     */
    T remove(int index) override {
        assert(index >= 0 && index < size);
        Node<T> *prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev->next;
        }
        Node<T> *node = prev->next;
        prev->next = node->next;
        node->next = nullptr;
        int ret = node->e;

        size--;
        return ret;
    }

    T removeFirst() {
        return remove(0);
    }

    T removeLast() {
        return remove(size -1);
    }

    /**
     *  修改下标 index 处元素为 e
     * @param index
     * @param e
     * @return
     */
    T set(int index, T e) override {
        assert(index > 0 && index < size);
        Node<T> *cur = head->next;
        for (int i = 0; i < index; i++)
            cur = cur->next;
        T ret = cur->e;
        cur->e = e;
        return ret;
    }

    T setFirst(T e) {
        set(0, e);
    }

    T setLast(T e) {
        set(size - 1, e);
    }

    void removeElement(T e) {
        Node<T> *prev = head;
        while (prev->next->e != e && prev->next != nullptr) {
            prev = prev->next;
        }
        if (prev->next != nullptr) {
            Node<T> *node = prev->next;
            prev->next = node->next;
            node->next = nullptr;
            size--;
        }
    }

    bool contains(T e) {
        Node<T> *prev = head;
        while (prev->next->e != e && prev->next != nullptr) {
            prev = prev->next;
        }
        if (prev->next->e != nullptr)
            return true;
        return false;
    }

    void print() {
        Node<T> *prev = head;
        std::cout << "LinkedList: size = " << size << std::endl;
        std::cout << "[";
        for (int i = 0; i < size; ++i) {
            prev = prev->next;
            std::cout << prev->e;
            if (i < size - 1) {
                std::cout << ", ";
            }
        }
        std::cout << "]" << std::endl;
    }


private:
    Node<T> *head;
    int size;
};

#endif //DATASTRUCTURE_LINKEDLIST_H
