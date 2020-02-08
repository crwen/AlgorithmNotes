//
// Created by crwen on 2019/12/11.
//

#ifndef DATASTRUCTURE_LINKEDLISTSTACK_H
#define DATASTRUCTURE_LINKEDLISTSTACK_H

#include "Stack.h"
#include "../list/LinkedList.h"

template <class T>
class LinkedListStack : public Stack<T> {
public:

    LinkedListStack() {
        list = new LinkedList<T>();
    }

    int getSize() override {
        return list->getSize();
    }

    bool isEmpty() override {
        return list->isEmpty();
    }

    void push(T e) override {
        list->addLast(e);
    }

    T pop() override {
        return list->removeLast();
    }

    T peek() override {
        return list->getLast();
    }

    void print() {
        std::cout << "Stack: size = " << list->getSize() << std::endl;
        std::cout << "bottom ";
        list->toPrint();
        std::cout << " top" << std::endl;
    }
private:
    LinkedList<T> *list;
};


#endif //DATASTRUCTURE_LINKEDLISTSTACK_H
