//
// Created by crwen on 2019/12/7.
//

#ifndef DATASTRUCTURE_ARRAYQUEUE_H
#define DATASTRUCTURE_ARRAYQUEUE_H

#include "Queue.h"
#include "Array.h"

template <class T>
class ArrayQueue : public Queue<T> {
public:
    ArrayQueue() {
        array = new Array<T>(10);
    }

    ArrayQueue(int capacity) {
        array = new Array<T>(capacity);
    }

    ~ArrayQueue() {
        delete [] array;
        array = nullptr;
    }

    /**
     *  返回队列的大小
     */
    int getSize() {
        return array->getSize();
    }

    /**
     *  判断队列是否为空
     * @return
     */
    bool isEmpty() {
        return array->isEmpty();
    }

    /**
     *  将元素 e 入队
     */
    void enqueue(T e) {
        array->addLast(e);
    }

    /**
     *  将队首元素出队，并返回
     * @return
     */
    T dequeue() {
        return array->removeFirst();
    }

    /**
     *  获取队首元素
     * @return
     */
    T getFront() override {
        return array->getFirst();
    }

    void print() {
        std::cout << "Queue: size = " << getSize() << ", capacity = " << array->getCapacity() << std::endl;
        std::cout << "front ";
        array->toPrint();
        std::cout << "tail" << std::endl;
    }

private:
    Array<T> *array;
};

#endif //DATASTRUCTURE_ARRAYQUEUE_H
