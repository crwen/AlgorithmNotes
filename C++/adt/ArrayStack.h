//
// Created by crwen on 2019/12/7.
//

#ifndef DATASTRUCTURE_ARRAYSTACK_H
#define DATASTRUCTURE_ARRAYSTACK_H

#include "Array.h"
#include "Stack.h"

template<class T>
class ArrayStack;

template<class T>
class ArrayStack : public Stack<T> {
public:
    ArrayStack(int capacity) {
        array = new Array<T>(capacity);
    }

    ArrayStack() {
        array = new Array<T>();
    }

    ~ArrayStack() {
        delete[] array;
        array = nullptr;
    }

    int getSize() {
        return array->getSize();
    }

    bool isEmpty() {
        return array->isEmpty();
    }

    void push(T e) {
        array->addLast(e);
    }

    T pop() {
        return array->removeLast();
    }

    T peek() {
        return array->getLast();
    }


    /**
     * 打印数组所有元素
     */
    void print() {
        std::cout << "Stack: size = " << array->getSize() << ", capacity = " << array->getCapacity() << std::endl;
        std::cout << "bottom ";
        array->toPrint();
        std::cout << " top" << std::endl;
    }

private:
    Array<T> *array;
};


#endif //DATASTRUCTURE_ARRAYSTACK_H
