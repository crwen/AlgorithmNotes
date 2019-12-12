//
// Created by crwen on 2019/12/11.
//

#ifndef DATASTRUCTURE_LINKEDLISTQUEUE_H
#define DATASTRUCTURE_LINKEDLISTQUEUE_H

#include "../list/LinkedList.h"
#include "Queue.h"
#include <cassert>

template <class T>
class QNode {
public:
    T e;
    QNode *next;

    QNode(T e, QNode *next) : e(e), next(next) {}

    QNode(T e) : e(e), next(nullptr) {}

    QNode() : next(nullptr) {}
};

template <class T>
class LinkedListQueue : public Queue<T> {
public:

    LinkedListQueue() {
        head = nullptr;
        tail = nullptr;
        size = 0;
    }

    int getSize() override {
        return size;
    }

    bool isEmpty() override {
        return size == 0;
    }

    void enqueue(T e) override {
        if (tail == nullptr) {
            tail = new QNode<T>(e);
            head = tail;
        } else {
            tail->next = new QNode<T>(e);
            tail = tail->next;
        }
        size++;
    }

    T dequeue() override {
        assert(!isEmpty());
        QNode<T> *node = head;
        head = head->next;
        node->next = nullptr;
        delete node;
        if (head == nullptr) {
            tail = nullptr;
        }
        size--;
        return node->e;
    }

    T getFront() override {
        assert(!isEmpty());
        return head->e;
    }

    void print() {
        QNode<T> *prev = head;
        std::cout << "LinkListQueue: size = " << size << std::endl;
        std::cout << "front ";
        std::cout << "[";
        while (prev != nullptr) {
            std::cout << prev->e;
            if (prev->next != nullptr) {
                std::cout << ", ";
            }
            prev = prev->next;
        }
        std::cout << "] tail" << std::endl;
    }

private:
    QNode<T> *head;
    QNode<T> *tail;
    int size;
};


#endif //DATASTRUCTURE_LINKEDLISTQUEUE_H
