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

    int getSize() override {
        return size;
    }

    bool isEmpty() override {
        return size == 0;
    }

    void add(int index, T e) override {
        assert(index >= 0 && index < size);
        Node<T> *prev = head;
        for (int i = 0; i < index; ++i) {
            prev = prev->next;
        }
        prev->next = new Node<T>(e, prev->next);
        size++;
    }

    T get(int index) override {
        assert(index >= 0 && index < size);
        Node<T> *cur = head->next;
        for (int i = 0; i < index; i++) {
            cur = cur->next;
        }
        return cur->e;
    }

    T remove(int index) override {
        assert(index >= 0 && index < size);
        Node<T> *prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev->next;
        }
        Node<T> node = prev->next;
        prev->next = node.next;
        node->next = nullptr;
        int ret = node->e;

        size--;
        return ret;
    }

private:
    Node<T> *head;
    int size;
};

#endif //DATASTRUCTURE_LINKEDLIST_H
